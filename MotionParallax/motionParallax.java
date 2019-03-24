/****************
Homework #4
March 25, 2019
Alex Weaver and Ben Comer
****************/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MotionParallax extends JFrame implements MouseListener, MouseMotionListener{

  private int delay = 16;
  protected Timer timer;
  private int currentX = 0;
  private int currentY = 0;

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

    int pinkMountainCurrentX = 300;
    int pinkMountainCurrentY = 900;
    int brownMountainCurrentX = 200;
    int brownMountainCurrentY = 950;
    int grasscurrentY = 700;
	
	int r1 = 211; int g1 = 168; int b1 = 198; // Color for the bigger mountain
	int r2 = 144; int g2 = 104; int b2 = 54; // Color for the smaller mountain
  }

  public void paint(Graphics g) {
    g.setColor(Color.rgb(r1, g1, b1)); // This sets the color to a greyish pink.
	int pinkMountainXValues[] = new int [3];
    pinkMountainXValues = {pinkMountainCurrentX, pinkMountainCurrentX + 600, pinkMountainCurrentX + 300};
	int pinkMountainYValues[] = new int [3];
    pinkMountainYValues = {pinkMountainCurrentY, pinkMountainCurrentY, pinkMountainCurrentY - 650};
    g.fillPolygon(pinkMountainXValues, pinkMountainYValues, 3);

    g.setColor(Color.rgb(r2, g2, b2)); // This sets the color to brown.
	int brownMountainXValues[] = new int [3];
    brownMountainXValues = {brownMountainCurrentX, brownMountainCurrentX + 400, brownMountainCurrentX + 200};
    int brownMountainYValues[] = new int [3];
	brownMountainYValues = {brownMountainCurrentY, brownMountainCurrentY, brownMountainCurrentY - 600};
    g.fillPolygon(brownMountainXValues, brownMountainYValues, 3);

    g.setColor(Color.rgb(32, 173, 33)); // This sets the color to a grass green.
    g.fillRect(-1000, grassCurrentY, 3000, 1300); // Creates the grass.
  }

  public void mousePressed(MouseEvent e) {
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

  }

  public void mouseClicked(MouseEvent e)
  {
    // generate the random integers for r, g and b value
    // code cited -> https://stackoverflow.com/questions/20560899/generate-a-random-color-java?lq=1
    Random rand = new Random();
    int r = rand.nextInt(255);
    int g = rand.nextInt(255);
    int b = rand.nextInt(255);
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  private class ParallaxTimer implements ActionListener{
    public void actionPerformed(ActionEvent e){
      repaint();
    }
  }


  public static void main(String[] args){
    new motionParallax();
  }
}
