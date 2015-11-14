package com.cardsgame.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

enum KEY {
    UP, RIGHT, DOWN, LEFT, RIGHT_UP, RIGHT_DOWN, LEFT_UP, LEFT_DOWN
}

enum HORIZION {
    LEFT, RIGHT
}

enum VERTICAL {
    UP, DOWN
}

public class Test {
    JFrame win;
    Icon img;
    JLabel lb;
    static final int STEP = 2;
    KEY key;
    HORIZION hor;
    VERTICAL ver;

    public Test() {
        hor = null;
        ver = null;

        win = new JFrame("MoveImage");
        win.setLayout(null);
        // 加载图片
        img = new ImageIcon(getClass().getResource("c6.jpg"));
        lb = new JLabel();
        lb.setSize(img.getIconWidth(), img.getIconHeight());
        // 装载图片
        lb.setIcon(img);

        win.setBounds(200, 0, 400, 300);
        // 响应键盘上的键按下事件
        win.addKeyListener(new KeyAdapter() {
            // 键值临时量
            int k;

            @Override
            public void keyPressed(KeyEvent e) {
                k = e.getKeyCode();

                switch (k) {
                case KeyEvent.VK_UP:
                    ver = VERTICAL.UP;
                    break;
                case KeyEvent.VK_DOWN:
                    ver = VERTICAL.DOWN;
                    break;
                case KeyEvent.VK_RIGHT:
                    hor = HORIZION.RIGHT;
                    break;
                case KeyEvent.VK_LEFT:
                    hor = HORIZION.LEFT;
                    break;
                }
                if (ver == null) {
                    if (hor == HORIZION.RIGHT) {
                        key = KEY.RIGHT;
                    } else {
                        key = KEY.LEFT;
                    }

                } else if (hor == null) {
                    if (ver == VERTICAL.UP) {
                        key = KEY.UP;
                    } else {
                        key = KEY.DOWN;
                    }
                } else {
                    if (hor == HORIZION.RIGHT) {
                        if (ver == VERTICAL.UP) {
                            key = KEY.RIGHT_UP;
                        } else {
                            key = KEY.RIGHT_DOWN;
                        }
                    } else {
                        if (ver == VERTICAL.UP) {
                            key = KEY.LEFT_UP;
                        } else {
                            key = KEY.LEFT_DOWN;
                        }
                    }
                }

                move(key);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                k = e.getKeyCode();
                switch (k) {
                case KeyEvent.VK_UP:
                    ver = null;
                    break;
                case KeyEvent.VK_DOWN:
                    ver = null;
                    break;
                case KeyEvent.VK_RIGHT:
                    hor = null;
                    break;
                case KeyEvent.VK_LEFT:
                    hor = null;
                    break;
                }
            }
        });

        win.add(lb);
        win.getContentPane().setBackground(Color.WHITE);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.validate();
    }

    /**
     * 移动图片， 只处理上下左右4个方向键，其它的不处理
     * 
     * @param keyCode
     *            按下的键盘上的键的键值
     */
    void move(KEY key) {
        // 记下当前的位置
        Point pos = lb.getLocation();
        switch (key) {
        case UP:// 上方向
            pos.y -= STEP;
            break;
        case RIGHT:// 右方向
            pos.x += STEP;
            break;
        case DOWN:// 下方向
            pos.y += STEP;
            break;
        case LEFT:// 左方向
            pos.x -= STEP;
            break;
        case RIGHT_UP:// 右上方向
            pos.x += STEP;
            pos.y -= STEP;
            break;
        case RIGHT_DOWN:// 右下方向
            pos.x += STEP;
            pos.y += STEP;
            break;
        case LEFT_DOWN:// 左下方向
            pos.x -= STEP;
            pos.y += STEP;
            break;
        case LEFT_UP:// 左上方向
            pos.x -= STEP;
            pos.y -= STEP;
            break;
        }
        // 是否移动到了边缘
        if (pos.x >= win.getWidth() - lb.getWidth() || pos.x < 0
                || pos.y >= win.getHeight() - lb.getHeight() || pos.y < 0)
            return;
        // 设置新位置
        lb.setLocation(pos);
        lb.validate();
    }

    public static void main(String[] args) {
        Test m = new Test();
    }
}