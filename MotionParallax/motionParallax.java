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
	
	Parallax
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