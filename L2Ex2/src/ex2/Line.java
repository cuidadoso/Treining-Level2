package ex2;

public class Line {
   int x0,y0,x1,y1;
   
   public Line(int x0, int y0, int x1, int y1){
       this.x0=x0;
       this.y0=y0;
       this.x1=x1;
       this.y1=y1;
   }
   public void draw(java.awt.Graphics g){
       g.drawLine(x0, y0, x1, y1);
   }
}
