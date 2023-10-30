 //2034355
package CW3;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author andrew.abel
 */
public class ImagePanel extends JPanel {

    private final Image myImage;
    private final int myX, myY;
    private final int myWidth, myHeight;
    private final Person id;

    
public ImagePanel(Person dispID,
                        int myX, 
                        int myY, 
                        int myWidth, 
                        int myHeight) {
        
        // Constructor for image panel
        
        // Complete this method
        super();
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.id = dispID;
        this.myImage=dispID.getPhoto();
        setBackground(new Color(177,121,72));

    }

   @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the wanted poster
        
        // Complete this method
           super.paintComponent(g);
        try{
        
            int age = id.getAgeinYears();
            super.paintComponent(g);
            
            //DRAW TRAINGLE
            g.draw3DRect(44,42,500,600,true);
            g.setColor(new Color(194,142,82)); 
            g.fill3DRect(44,42,500,600,true);
            g.drawImage(this.myImage, 208,150, 200, 200,this);

            //DRAW LINE
           g.setColor(new Color(220,203,177)); 
           Graphics2D   g2d   =   (Graphics2D)g;  
           Stroke   st   =   g2d.getStroke();   
           Stroke   bs;   
           bs   =   new   BasicStroke(50,   BasicStroke.CAP_BUTT,   
                                                            BasicStroke.JOIN_BEVEL,   0,   
                                                            new   float[]{13,   4},   0);   
           g2d.setStroke(bs);   
           g2d.drawLine(28,130,   543,   30);    
           g2d.setStroke(st);
           
           //DRAW WORD
           
            int windowWidth=this.getWidth();
            
            Font myFont = new Font("Nimbus Roman No9 L", Font.BOLD,100 );
            g.setFont(myFont);
            g.setColor(new Color(128,128,128)); 
            g.drawString("WANTED",65,105);
            g.setColor(Color.BLACK); 
            g.drawString("WANTED",60,100);
          
         
            g.setColor(new Color(90,90,90)); 
            Font font1 = new Font("Bitstream Charter",Font.BOLD+Font.ITALIC, 30);
            FontMetrics fontMetrics2 = g.getFontMetrics(font1);
            int width2 = fontMetrics2.stringWidth(id.getCrimes());
            int a=(windowWidth-width2)/2;
            g.setFont(font1);
            g.drawString(id.getCrimes(),a,400);
            
             g.setColor(Color.black); 
             
            Font font2 = new Font("Javanese Text",Font.BOLD+Font.ITALIC, 35);
            FontMetrics fontMetrics = g.getFontMetrics(font2);
            int width = fontMetrics.stringWidth(id.getFirstName()+" "+id.getFamilyName());
            int m=(windowWidth-width)/2;
            g.setFont(font2);
            g.drawString(id.getFirstName()+" "+id.getFamilyName(),m,450);
           
     
            Font font3 = new Font("Century Schoolbook L",Font.BOLD, 40);
            FontMetrics fontMetrics1 = g.getFontMetrics(font3);
            int width1 = fontMetrics1.stringWidth("REWARD: $"+id.getReward());
            int n=(windowWidth-width1)/2;
            g.setFont(font3);
            g.drawString("REWARD: $"+id.getReward(),n,500);
            
            Font font4 = new Font("DejaVu Math TeX Gyre",Font.BOLD, 33);
            FontMetrics fontMetrics4 = g.getFontMetrics(font4);
            int width4 = fontMetrics4.stringWidth("Age:"+age+" years old");
            int q=(windowWidth-width4)/2;
            g.setFont(font4);
            g.drawString("Age:"+age+" "+"years old",q,550);
           
            Font font5 = new Font("DejaVu Math TeX Gyre",Font.BOLD, 33);
            FontMetrics fontMetrics5 = g.getFontMetrics(font5);
            int width5 = fontMetrics4.stringWidth("ID Code:"+id.getIdCode());
            int p=(windowWidth-width5)/2;
            g.setFont(font5);
            g.drawString("ID Code:"+id.getIdCode(),p,600);
             
            g.setColor(Color.red); 
            int[] xPoints = new int[] {n-40, n-60,  n-10, n-70, n-20,n-40 };
            int[] yPoints = new int[] {460,  510, 475,  475, 510,460 };
            int nPoints = 6;
            g2d.drawPolyline(xPoints, yPoints, nPoints);
            g2d.dispose();
      
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    
   
    // Getters, do not need to change
 // Getters, do not need to change
     @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public int getWidth() {
        return myWidth;
    }

    @Override
    public int getHeight() {
        return myHeight;

    }

}