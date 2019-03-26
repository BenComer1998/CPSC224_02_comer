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

  ParallaxTimerPanel ptp;

  public MotionParallax(){
    setTitle("Motion Parallax");
    setSize(1000, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
	ptp = new ParallaxTimerPanel();
	ptp.setOpaque(false);
    getContentPane().setBackground(new Color(190, 255, 255));
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
	ptp.sX = 0; // These snap the picture back where it
	ptp.sY = 0; // was upon releasing
  }

  public void mouseDragged(MouseEvent e)
  {
    ptp.sX = e.getX() - currentX;
    ptp.sY = e.getY() - currentY;
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
    ptp.sR = 255; // change to sun
    ptp.sG = 255;
    ptp.sB = 0;
  }

  public void mouseExited(MouseEvent e)
  {
    getContentPane().setBackground(new Color (0, 0, 0)); //change to night sky
    ptp.sR = 180; // change to moon
    ptp.sG = 180;
    ptp.sB = 180;
  }

  public void mouseMoved(MouseEvent e)
  {
    // MouseMotionListener event, so no code necessary
  }

  public static void main(String[] args){
    new MotionParallax();
  }
}

class ParallaxTimerPanel extends JPanel implements ActionListener{

  public int sX = 0; // drag position x
  public int sY = 0; // drag position y

  // Changes in position for our graphics based
  // on dragging or time.
  public int birdDX = 3;
  public int sunDX = 1;
  public int sunDY = 1;
  public int pinkMountainDX = 2;
  public int pinkMountainDY = 2;
  public int brownMountainDX = 4;
  public int brownMountainDY = 4;
  public int grassDY = 8;

  // Current X and Y Values for our graphics
  private int birdCurrentX = 0;
  private int birdCurrentY = 280;
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
    g.setColor(new Color(sR, sG, sB));
    g.fillOval(sunCurrentX + ((sunDX * sX) / 10), sunCurrentY + ((sunDY * sY) / 10), 150, 150);
    g.setColor(Color.BLACK);
    g.drawOval(sunCurrentX + ((sunDX * sX) / 10), sunCurrentY + ((sunDY * sY) / 10), 150, 150);
	
    g.setColor(new Color(r1, g1, b1)); // This sets the color to a greyish pink.
    int pinkMountainXValues[] = new int [3];
    pinkMountainXValues[0] = pinkMountainCurrentX + (pinkMountainDX * sX / 10);
    pinkMountainXValues[1] = pinkMountainCurrentX + 600 + (pinkMountainDX * sX / 10);
    pinkMountainXValues[2] = pinkMountainCurrentX + 300 + (pinkMountainDX * sX / 10);
    int pinkMountainYValues[] = new int [3];
    pinkMountainYValues[0] = pinkMountainCurrentY + (pinkMountainDY * sY / 10);
    pinkMountainYValues[1] = pinkMountainCurrentY + (pinkMountainDY * sY / 10);
    pinkMountainYValues[2] = pinkMountainCurrentY - 650 + (pinkMountainDY * sY / 10);
    g.fillPolygon(pinkMountainXValues, pinkMountainYValues, 3);

    g.setColor(new Color(r2, g2, b2)); // This sets the color to brown.
    int brownMountainXValues[] = new int [3];
    brownMountainXValues[0] = brownMountainCurrentX + (brownMountainDX * sX / 10);
    brownMountainXValues[1] = brownMountainCurrentX + 600 + (brownMountainDX * sX / 10);
    brownMountainXValues[2] = brownMountainCurrentX + 300 + (brownMountainDX * sX / 10);
    int brownMountainYValues[] = new int [3];
    brownMountainYValues[0] = brownMountainCurrentY + (brownMountainDY * sY / 10);
    brownMountainYValues[1] = brownMountainCurrentY + (brownMountainDY * sY / 10);
    brownMountainYValues[2] = brownMountainCurrentY - 650 + (brownMountainDY * sY / 10);
    g.fillPolygon(brownMountainXValues, brownMountainYValues, 3);

    g.setColor(new Color(32, 173, 33)); // This sets the color to a grass green.
    g.fillRect(-1000, grassCurrentY + ((grassDY + sY) / 10), 3000, 1300); // Creates the grass.
	
	if (birdCurrentX > 1000)
		birdCurrentX = -160;
	birdCurrentX += birdDX;
	
    g.setColor(Color.RED);
    int birdXValues[] = new int [4];
    birdXValues[0] = birdCurrentX;
    birdXValues[1] = birdCurrentX + 20;
    birdXValues[2] = birdCurrentX + 40;
    birdXValues[3] = birdCurrentX + 20;
    int birdYValues[] = new int [4];
    birdYValues[0] = 280;
    birdYValues[1] = 290;
    birdYValues[2] = 280;
    birdYValues[3] = 300;
    g.fillPolygon(birdXValues, birdYValues, 4);
	
	g.setColor(new Color(160, 0, 255));
    birdXValues[0] = birdCurrentX + 40;
    birdXValues[1] = birdCurrentX + 60;
    birdXValues[2] = birdCurrentX + 80;
    birdXValues[3] = birdCurrentX + 60;
    birdYValues[0] = 290;
    birdYValues[1] = 300;
    birdYValues[2] = 290;
    birdYValues[3] = 310;
    g.fillPolygon(birdXValues, birdYValues, 4);
  }

  public void actionPerformed(ActionEvent e){
    repaint();
  }
}
