package ex2;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame 
                     implements MouseListener, MouseMotionListener {
    public MyFrame(String title){
        super(title);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println(Thread.currentThread().getName());
                System.exit(0);
            }
        });
        this.add("South",new Button("Test"));        
        this.add("West",new Button("OK"));
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Line li : list) li.draw(g);
    }

    int x,y;
    java.util.LinkedList<Line> list=
            new java.util.LinkedList<Line>();
    
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        Graphics g=getGraphics();
        g.drawLine(x, y, e.getX(), e.getY());
        list.add(new Line(x, y, e.getX(), e.getY()));
        //System.out.println(e.getX()+" "+e.getY());
    }
    public void mouseMoved(MouseEvent e) {
    }
}
