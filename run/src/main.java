import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class main extends JFrame implements ActionListener{
    JButton st = new JButton("Start/Stop");
    JButton New = new JButton("New Game");
    JPanel panel = new JPanel();
    ImageIcon image = new ImageIcon(System.getProperty("user.dir") + File.separator + "3.gif");
    JLabel background = new JLabel(new ImageIcon(System.getProperty("user.dir") + File.separator + "lowing.png"));
    //new ImageIcon(System.getProperty("user.dir") + File.separator + "2.gif"
    JLabel l1 = new JLabel(image);
    MyThread myThread;
    int x,y;

    public main(){
        setSize(1020,590);
        setTitle("RUN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        New.setBounds(10,10,100,25);
        st.setBounds(130,10,100,25);
        panel.setLayout(null);
        panel.setBounds(0,0,1000,50);

        panel.setBackground(new Color(255,0,0));
        add(panel);

        panel.add(New);
        panel.add(st);

        background.setBounds(0,50,1000,500);
        panel.add(background);

        l1.setBounds(x=445,y=450,50,50);
        myThread = new MyThread(l1,x,y);
        myThread.start();
        background.add(l1);

        st.addActionListener(this);
        New.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == st){
            if (myThread.isflag()) myThread.setFlag(false);
            else myThread.setFlag(true);
        }
        if (e.getSource() == New){
            System.out.println("new");
        }
    }

    public static void main(String[] arg){
        main Main = new main();
        Main.setVisible(true);
    }
}
class MyThread extends Thread{
    JLabel panel;
    int x,y,sec;
    boolean check = false;
    public MyThread(JLabel panel1, int ssx, int ssy){
        panel = panel1;
        x = ssx;
        y = ssy;
    }

    @Override
    public void run() {
        sec = (int)(Math.random()*20+1);
        for(;;){
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {}
            for(;check;) {
                try {
                    if (x<950) x++;
                    if (x==950){
                        if (y>174) y--;
                        if (y==174){

                        }
                    }
                    panel.setLocation(x,y);
                    Thread.sleep(sec);
                }
                catch (InterruptedException e) {}
            }
        }
    }
    void setFlag (boolean flag) {
        this.check = flag;
    }
    boolean isflag() {
        return check;
    }
}