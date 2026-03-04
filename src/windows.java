import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.Timer;

public class windows extends JFrame {
    public static boolean successornot=true;
    public Food food;
    public Snack snack;
    public java.util.Timer timer;
    public java.util.Timer timer2;
    public JPanel jPanel;
    public windows(){
        //初始化方框
        setSize(450,300);
        setLocation(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化食物集合
        initFood();
        //初始化蛇
        initsnack();
        //初始化画布
        initwindows();
        initTimer();
        //定时器1,每隔100ms执行一次定时任务
        //定时任务指的是将蛇按指定方向移动(删除尾坐标，添加头坐标),并用横线和竖线和新的蛇重新绘制画布
        setKey();
        //设置键盘输入改变蛇移动的方向
    }
    public void  initFood(){
        food=new Food();
        food.generateFood();
    }
    public void setKey(){

        addKeyListener(new KeyAdapter() {
            //当键盘按下时,会调用此方法
            @Override
            public void keyPressed(KeyEvent e) {
                //当键盘输入向上移动,且蛇的初始移动方向不向下时
                if(e.getKeyCode()==38&&snack.getDirection()!=1){
                    snack.setDirection(0);
                }
                //当键盘输入向下移动,且蛇的初始移动方向不向上时
                if(e.getKeyCode()==40&&snack.getDirection()!=0){
                    snack.setDirection(1);
                }
                //当键盘输入向左移动,且蛇的初始移动方向不向右时
                if(e.getKeyCode()==37&&snack.getDirection()!=3){
                    snack.setDirection(2);
                }
                //当键盘输入向右移动,且蛇的初始移动方向不向左时
                if(e.getKeyCode()==39&&snack.getDirection()!=2){
                    snack.setDirection(3);
                }
            }
        });
    }
    public void initsnack(){
        snack=new Snack();
    }
    private void initwindows() {
        jPanel = new JPanel() {
            public void paint(Graphics g) {
                g.clearRect(0,0,490,350);
                //先清空原本画布
                super.paintComponent(g);
                setBackground(Color.BLACK);
                int cell = 15;  
                int rows = 20;    
                int cols = 30;    
                // 画内部横线
                g.setColor(Color.WHITE);
                for (int r = 1; r < rows; r++) {
                    g.drawLine(0, r * cell, cols * cell, r * cell);
                }

                // 画内部竖线
                for (int c = 1; c < cols; c++) {
                    g.drawLine(c * cell, 0, c * cell, rows * cell);
                }

                // 画外圈 * 边框（黄色）
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Monospaced", Font.BOLD, 16));

                // 上边框
                for (int c = 0; c < cols; c++) {
                    g.drawString("*", c * cell, cell - 2);
                }
                // 下边框
                for (int c = 0; c < cols; c++) {
                    g.drawString("*", c * cell, rows * cell);
                }
                // 左边框
                for (int r = 0; r < rows; r++) {
                    g.drawString("*", 0, r * cell + cell - 2);
                }
                // 右边框
                for (int r = 0; r < rows; r++) {
                    g.drawString("*", (cols - 1) * cell, r * cell + cell - 2);
                }
                if(!successornot){
                    g.setColor(Color.RED);
                    g.setFont(new Font("黑体", Font.BOLD, 30));
                    g.drawString("游戏失败"+snack.score, 250, 200);
                }
                LinkedList<Point> points = snack.getLinkedList();
                LinkedList<Point> points2=food.getArrayList();
                for (Point point : points) {
                    g.setColor(Color.RED);
                    g.fillRect(point.x, point.y, 15, 15);
                }
                for(Point point:points2){
                    g.setColor(Color.RED);
                    g.fillRect(point.x, point.y, 15, 15);
                }
            }
        };
        //将画布加入方框
        add(jPanel);
        if(successornot==false){
            System.exit(0);
        }
    }

    public void initTimer(){
        timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            //每隔100ms移动一次蛇,若期间没有键盘输入,则按照原指定的方向移动
            public void run() {
                snack.move(food);
                //重绘画布,新画布中包含方格,蛇,和食物集合
                //其中蛇的移动会判断蛇是否触碰到食物集合中的任一食物
                //若有则修改蛇头,并且删除食物集合中的食物
                //以外还会判断临界条件,蛇是否移动到了边界位置;
                jPanel.repaint();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);
    }
    public static void main(String[] urgs) throws FileNotFoundException {
        new windows().setVisible(true);
    }
    public static  void setSuccessornot(){
        successornot=false;
    }
}
