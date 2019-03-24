/****************
Homework #4
March 25, 2019
Alex Weaver and Ben Comer
****************/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class motionParallax extends JFrame{

  public motionParallax(){
    setTitle("Motion Parallax");
    setSize(1000, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    addMouseListener(new MyMouseListener);
    setVisible(true);
  }
  
  public void paint(Graphics g) {
	  g.setColor(Color(211, 168, 198)); // This sets the color to a greyish pink.
	  int pinkMountainXValues[3] = {pinkMountainCurrentX, pinkMountainCurrentX + 600, pinkMountainCurrentX + 300};
	  int pinkMountainYValues[3] = {pinkMountainCurrentY, pinkMountainCurrentY, pinkMountainCurrentY - 650};
	  g.fillPolygon(pinkMountainXValues, pinkMountainYValues, 3);
	  
	  g.setColor(Color(144, 104, 54)); // This sets the color to brown.
	  int brownMountainXValues[3] = {brownMountainCurrentX, brownMountainCurrentX + 400, brownMountainCurrentX + 200};
	  int brownMountainYValues[3] = {brownMountainCurrentY, brownMountainCurrentY, brownMountainCurrentY - 600};
	  g.fillPolygon(brownMountainXValues, brownMountainYValues, 3);
	  
	  g.setColor(Color(32, 173, 33)); // This sets the color to a grass green.
	  g.fillRect(-1000, grassCurrentY, 3000, 1300); // Creates the grass.
  }

  private class MyMouseListener implements MouseListener, MouseMotionListener
  {
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

     }

     public void mouseClicked(MouseEvent e)
     {
     }

     public void mouseEntered(MouseEvent e)
     {
     }

     public void mouseExited(MouseEvent e)
     {
     }
  }
  
  private class ParallaxTimer implements ActionListener{
	
  }

  public static void main(String[] args){
    new motionParallax();
  }
}