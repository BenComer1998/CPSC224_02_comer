/****************
Homework #4
March 25, 2019
Alex Weaver and Ben Comer
****************/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MotionParallax extends JFrame implements MouseListener, MouseMotionListener{

  private boolean dragging = false;
  private int currentX = 0; //mouse position x
  private int currentY = 0; //mouse position Y
  private int sX = 0; //drag position x
  private int sY = 0; //drag position y

  ParallaxTimerPanel ptp;

  public MotionParallax(){
    setTitle("Motion Parallax");
    setSize(1000, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
	  ptp = new ParallaxTimerPanel();
	  ptp.setOpaque(false);
    addMouseListener(this);
    addMouseMotionListener(this);
    this.add(ptp);
    setVisible(true);
  }


  public void mousePressed(MouseEvent e)
  {
    // Get the mouse cursor coordinates.
    currentX = e.getX();
    currentY = e.getY();
    dragging = true;
   }

  public void mouseReleased(MouseEvent e)
  {
	dragging = false;
  }

  public void mouseDragged(MouseEvent e)
  {
    sX = e.getX();
    sY = e.getY();
  }

  public void mouseClicked(MouseEvent e)
  {
    // generate the random integers for r, g and b value. used for mountains
    // code cited -> https://stackoverflow.com/questions/20560899/generate-a-random-color-java?lq=1
    Random rand = new Random();
    ptp.r1 = rand.nextInt(255);
    ptp.g1 = rand.nextInt(255);
    ptp.b1 = rand.nextInt(255);

    ptp.r2 = rand.nextInt(255);
    ptp.g2 = rand.nextInt(255);
    ptp.b2 = rand.nextInt(255);
  }

  public void mouseEntered(MouseEvent e)
  {
    getContentPane().setBackground(new Color(190, 255, 255)); //change to day sky
    ptp.sR = 255; //change to sun
    ptp.sG = 255;
    ptp.sB = 0;
  }

  public void mouseExited(MouseEvent e)
  {
    getContentPane().setBackground(new Color (0, 0, 0)); //change to night sky
    ptp.sR = 128; //change to moon
    ptp.sG = 128;
    ptp.sB = 128;
  }

  public void mouseMoved(MouseEvent e)
  {
    //MoustMotionListener event, so no code necessary
  }

  public static void main(String[] args){
    new MotionParallax();
  }
}

class ParallaxTimerPanel extends JPanel implements ActionListener{

  public int pinkMountainDX = 1;
  public int pinkMountainDY = 1;
  public int brownMountainDX = 2;
  public int brownMountainDY = 2;
  public int grassDY = 4;

  private int pinkMountainCurrentX = 400;
  private int pinkMountainCurrentY = 900;
  private int brownMountainCurrentX = 100;
  private int brownMountainCurrentY = 950;
  private int grassCurrentY = 700;
  private int sunCurrentX = 200;
  private int sunCurrentY = 150;
  public int r1 = 211; public int g1 = 168; public int b1 = 198; // Color for the bigger mountain
  public int r2 = 144; public int g2 = 104; public int b2 = 54; // Color for the smaller mountain
  public int sR = 255; public int sG = 255; public int sB = 0; //Color for sun
  private int delay = 16;
  protected Timer timer;

  public ParallaxTimerPanel(){
    timer = new Timer(delay, this);
    timer.start();
  }

  public void paint(Graphics g) {
    g.setColor(new Color(r1, g1, b1)); // This sets the color to a greyish pink.
    int pinkMountainXValues[] = new int [3];
    pinkMountainXValues[0] = pinkMountainCurrentX;
    pinkMountainXValues[1] = pinkMountainCurrentX + 600;
    pinkMountainXValues[2] = pinkMountainCurrentX + 300;
    int pinkMountainYValues[] = new int [3];
    pinkMountainYValues[0] = pinkMountainCurrentY;
    pinkMountainYValues[1] = pinkMountainCurrentY;
    pinkMountainYValues[2] = pinkMountainCurrentY - 650;
    g.fillPolygon(pinkMountainXValues, pinkMountainYValues, 3);

    g.setColor(new Color(r2, g2, b2)); // This sets the color to brown.
    int brownMountainXValues[] = new int [3];
    brownMountainXValues[0] = brownMountainCurrentX;
    brownMountainXValues[1] = brownMountainCurrentX + 600;
    brownMountainXValues[2] = brownMountainCurrentX + 300;
    int brownMountainYValues[] = new int [3];
    brownMountainYValues[0] = brownMountainCurrentY;
    brownMountainYValues[1] = brownMountainCurrentY;
    brownMountainYValues[2] = brownMountainCurrentY - 650;
    g.fillPolygon(brownMountainXValues, brownMountainYValues, 3);

    g.setColor(new Color(32, 173, 33)); // This sets the color to a grass green.
    g.fillRect(-1000, grassCurrentY, 3000, 1300); // Creates the grass.

	g.setColor(new Color(sR, sG, sB));
	g.fillOval(sunCurrentX, sunCurrentY, 150, 150);
	g.setColor(Color.BLACK);
	g.drawOval(sunCurrentX, sunCurrentY, 150, 150);
  }

  public void actionPerformed(ActionEvent e){
    repaint();
  }
}
