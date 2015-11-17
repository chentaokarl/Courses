package com.cardsgame.server;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextArea;

import com.alibaba.message.ListMessage;
import com.alibaba.message.Message;
import com.alibaba.user.AddUser;
import com.alibaba.user.CheckIn;

public class Server {
	int count = 0;//���ڼ���(�������ӿͻ���)
	CheckIn ci ;//���ں˲��û���������
	Socket sk;//���ڽ������Կͻ��˵�Socket
	Socket ssend;//���ڷ���ʱ�õ�list�е�Socket
	ServerSocket ss;//���ڽ���������
	JButton send;//���ڽ�������CocoJFrame�������еİ�ť,�Ա㴴����ť�ļ���
	Message msg; //���ڽ������Կͻ��˵ķ�װ��Ϣ��ͷ��͵ķ�װ��Ϣ��
	Message rsmsg;//������ת�ͻ��������Ϣ�ķ�װ��Ϣ��
	CocoJFrame coco;//���ڴ���һ�����������(û��ʵ���ô�,����ɾ��)
	JTextArea input;//���ڽ�������CocoJFrame�е�input,������ʾ���յ�����Ϣ
	JTextArea output;//���ڽ�������CocoJFrame�е�output,������ʾ���͵���Ϣ
	ObjectOutputStream os;//���ڷ���ʱ�õ�listo�е�ObjectOutputStream
	String deletename = new String();//���ڽ������Կͻ��˵�������Ϣ�е�����,�Ա��б��еĸ���ɾ��
	ListMessage lmsg = new ListMessage();//���ڷ�װmessage���������ߵĿͻ�����
	ArrayList list = new ArrayList();//���ڴ洢�Ѿ����ӵĿͻ���Socket
	ArrayList listo = new ArrayList();//���ڴ洢�����Ѿ����ӵĿͻ���Socket��OutputStream�����ObjectOutputStream
	ArrayList listi = new ArrayList();//���ڴ洢�����Ѿ����ӵĿͻ���Socket��InputStream�����ObjectInputStream
	ArrayList listname = new ArrayList();//���ڴ洢�����û�������,�Ա㷢�͸��û������估ʱ����
	AddUser add;//ע���û���
	SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");//��ʽ��ʱ��
   
	/**
	 * Server:used to accept link 
	 * Made by TaoChen
	 * Time:2010-04
	 */
	
	//������
	public Server() {
		// TODO Auto-generated constructor stub
		coco = new CocoJFrame("CoCo-Server");//����һ������,������ʾ��Ϣ
		coco.myFrame.setDefaultCloseOperation(coco.myFrame.EXIT_ON_CLOSE);//�趨���洰�ڹر�ʱ�˳�����
		this.send = coco.send;//�������Խ����send��ť
		input = coco.input;
		output = coco.output;
		send.addActionListener(new ActionListener() {//��send��ť��ӷ��ͼ���

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SendMsg sendmsg = new SendMsg();
				sendmsg.start();//����������Ϣ���߳�
			}
		});
	}
	
    //�������,��������Server����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.startServer();

	}

	//����������,�ȴ��ͻ������ӣ�������һЩ���Ӻ�Ĵ���
	public void startServer() {
		try {
			ObjectInputStream fois;
			ObjectOutputStream foos;
			ss = new ServerSocket(9999);//��������
			msg = new Message("server", "", new Date());//�Է�װ��Ϣ���ʼ��,�����ָ��
			while (true) {//ѭ���ȴ�����,ʵ�ֶ�ͻ�����
				ssend = ss.accept();//���ܿͻ�������
				list.add(ssend);
				listi.add(new ObjectInputStream(ssend.getInputStream()));
				listo.add(new ObjectOutputStream(ssend.getOutputStream()));
				fois = (ObjectInputStream) listi.get(listi.size()-1);
				foos = (ObjectOutputStream) listo.get(listo.size()-1);
				Message mname = (Message) fois.readObject();
				if(mname.isRegister()){
					list.remove(list.size()-1);
					listi.remove(listi.size()-1);
					listo.remove(listo.size()-1);
					ServerRegister sr = new ServerRegister(foos,fois,mname);
					sr.start();
				}else{
				ci = new CheckIn(mname.getName(),mname.getPsw());
				ci.checkin();
				if(ci.isFlag()){
					if(ci.isFlag1()){
						int i = 0;
						for( ;i< listname.size();i++){
							String name = (String) listname.get(i);
							if(mname.getName().equals(name)){
								mname.setState(false);
								mname.setMsg("�û��ѵ�¼");
								foos.writeObject(mname);
								fois.close();
								foos.close();
								list.remove(list.size()-1);
								listi.remove(listi.size()-1);
								listo.remove(listo.size()-1);
								break;
							}
						}
						if(i==listname.size()){
						listname.add(mname.getName());
						mname.setState(true);
						foos.writeObject(mname);
						lmsg.setMsg(mname);
						lmsg.setNamenext((String) listname.get(listname.size() - 1));
						SendMsg sendmsg = new SendMsg();
						sendmsg.start();
						ReadMsg read = new ReadMsg((ObjectInputStream) listi.get(listi.size()-1));
						read.start();
						}
					}else{
						msg.setState(false);
						msg.setMsg("�������");
						foos.writeObject(msg);
						fois.close();
						foos.close();
						list.remove(list.size()-1);
						listi.remove(listi.size()-1);
						listo.remove(listo.size()-1);
						
					}
				}else{
					msg.setState(false);
					msg.setMsg("�û������ڣ���ע��");
					foos.writeObject(msg);
					fois.close();
					foos.close();
					list.remove(list.size()-1);
					listi.remove(listi.size()-1);
					listo.remove(listo.size()-1);
				}
				
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("socket closed");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    //��Ϣ�����߳�,ͨ����ť��������
	class SendMsg extends Thread {
		Socket sk;
		ObjectOutputStream os;
		ListMessage lmsg = new ListMessage();
		
		public SendMsg() {
			// TODO Auto-generated constructor stub
		}

		public void run() {
			try {
				
				String str = output.getText();
				msg.setMsg(str);
				msg.setOnlist(listname);
				lmsg.setDeletename(deletename);
				lmsg.setMsg(msg);
				if (listname.size() != 0)
					lmsg.setNamenext((String) listname
									.get(listname.size() - 1));
				for (int i = 0; i < list.size(); i++) {
					sk = (Socket) list.get(i);
					os = (ObjectOutputStream) listo.get(i);
					os.writeObject(lmsg);
				}
				input.append("��˵:" + myFmt.format(new Date()) + "\n" + str + "\n");
				input.setCaretPosition(input.getText().length()); 
				output.setText("");
				deletename = "";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println("socket closed");
			}
		}
	}
   //������Ϣ�߳�,���ڳ���״̬
	class ReadMsg extends Thread {
		ObjectInputStream ois;

		public ReadMsg(ObjectInputStream ois) {
			// TODO Auto-generated constructor stub
			this.ois = ois;
		}

		public void run() {
			try {

				while (true) {
					lmsg = (ListMessage) ois.readObject();
					if (lmsg.getMsg().getState()) {
						msg = lmsg.getMsg();
						msg.setOnlist(listname);
						rsmsg = msg;
						RSendMsg rsend = new RSendMsg();
						rsend.start();
					} else {
						for (int i = 0; i < listname.size(); i++) {
							if (((String) listname.get(i)).equals(lmsg.getMsg()
									.getName())) {
								((InputStream) listi.get(i)).close();
								((OutputStream) listo.get(i)).close();
								((Socket) list.get(i)).close();
								listi.remove(i);
								listo.remove(i);
								list.remove(i);
								listname.remove(i);

							}

						}
					}
				}
			} catch (IOException e) {
				if (!listname.isEmpty()) {
					System.out.println(listname.get(listname.size() - 1));
				
				deletename = lmsg.getMsg().getName();
				System.out.println(deletename);
				SendMsg sendmsg = new SendMsg();
				sendmsg.start();
				}

				// TODO Auto-generated catch block
				// e.printStackTrace();
				// System.out.println("socket closed");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
    //ת����Ϣ�߳�,ʵ�ֿͻ��������
	class RSendMsg extends Thread {
		ListMessage lmsg = new ListMessage();

		public void run() {
			try {
				rsmsg.setOnlist(listname);
				lmsg.setMsg(rsmsg);
				lmsg.setNamenext((String) listname.get(listname.size() - 1));
				for (int j = 0; j < listname.size(); j++) {
					if (rsmsg.getCname().equals("All")) {
						os = (ObjectOutputStream) listo.get(j);
						os.writeObject(lmsg);
					} else if (rsmsg.getCname()
							.equals((String) listname.get(j))) {
						os = (ObjectOutputStream) listo.get(j);
						os.writeObject(lmsg);
					}
				}
				input.append(rsmsg.toString());
				output.setText("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
