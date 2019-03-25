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
  private int delay = 16;
  private int currentX = 0; //mouse position x
  private int currentY = 0; //mouse position Y
  private int sX = 0; //drag position x
  private int sY = 0; //drag position y
  private int pinkMountainCurrentX = 300;
  private int pinkMountainCurrentY = 900;
  private int brownMountainCurrentX = 200;
  private int brownMountainCurrentY = 950;
  private int grassCurrentY = 700;
  private int r1 = 211; private int g1 = 168; private int b1 = 198; // Color for the bigger mountain
  private int r2 = 144; private int g2 = 104; private int b2 = 54; // Color for the smaller mountain
  protected Timer timer;


  public MotionParallax(){
    setTitle("Motion Parallax");
    setSize(1000, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    addMouseListener(this);
    addMouseMotionListener(this);
    addActionListener(new ParallaxTimer());
    timer = new Timer(delay, ParallaxTimer());
    timer.start();
    setVisible(true);
	
	getContentPane().setBackground(new Color(166, 255, 255));
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
    brownMountainXValues[1] = brownMountainCurrentX + 400;
    brownMountainXValues[2] = brownMountainCurrentX + 200;
    int brownMountainYValues[] = new int [3];
    brownMountainYValues[0] = brownMountainCurrentY;
    brownMountainYValues[0] = brownMountainCurrentY;
    brownMountainYValues[0] = brownMountainCurrentY - 600;
    g.fillPolygon(brownMountainXValues, brownMountainYValues, 3);

    g.setColor(new Color(32, 173, 33)); // This sets the color to a grass green.
    g.fillRect(-1000, grassCurrentY, 3000, 1300); // Creates the grass.
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
    if (dragging){
      repaint();
    }
  }

  public void mouseClicked(MouseEvent e)
  {
    // generate the random integers for r, g and b value
    // code cited -> https://stackoverflow.com/questions/20560899/generate-a-random-color-java?lq=1
    Random rand = new Random();
    r1 = rand.nextInt(255);
    g1 = rand.nextInt(255);
    b1 = rand.nextInt(255);

    r2 = rand.nextInt(255);
    g2 = rand.nextInt(255);
    b2 = rand.nextInt(255);
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  private class ParallaxTimer implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }


  public static void main(String[] args) {
    new MotionParallax();
  }
}
