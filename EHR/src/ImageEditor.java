import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class ImageEditor extends JComponent
{
  private Image image;
  private Graphics2D graphics; 
  private int cX, cY, oX, oY;
  
  public ImageEditor()
  {
	  setDoubleBuffered(false);
	  addMouseListener(new MouseAdapter()
	  {
		public void mousePressed(MouseEvent e)
		{
			oX = e.getX();
			oY = e.getY();
		}
	  });
	  
	  addMouseMotionListener(new MouseMotionAdapter()
	  {
		  public void mouseDragged(MouseEvent e)
		  {
			  cX = e.getX();
			  cY = e.getY();
			  
			  if(graphics != null)
			  {
				  graphics.drawLine(oX, oY, cX, cY);
				  repaint();
				  oX = cX;
				  oY = cY;
			  }
			  
		  }
	  });
  }
  
  protected void paintComponent(Graphics g)
  {
	  if(image  == null)
	  {
		  image = createImage(getSize().width, getSize().height);
		  graphics = (Graphics2D) image.getGraphics();
		  graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		  clear();
	  }
	  
	  g.drawImage(image, 0, 0, null);  
  }
  
  public void clear() {
	    graphics.setPaint(Color.white);
	    // draw white on entire draw area to clear
	    graphics.fillRect(0, 0, getSize().width, getSize().height);
	    graphics.setPaint(Color.black);
	    repaint();
	  }
 public void Draw(Color color)
 {
	 graphics.setPaint(color);
 }
  
  
}
