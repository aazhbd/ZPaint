import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ZPaint extends JApplet{
	private int xValue = -10, yValue = -10;
	private int xSize=4, ySize=4;
	private Button red, blue, yellow, green, incSize, resSize;
	private Panel p;
	private int r=0, b=0, y=0, gr=0, n=0;
	private Container c;
	
	public void init(){
		c=getContentPane();
		p=new Panel();
		c.add(p, BorderLayout.SOUTH);		
		red=new Button("Red");
		blue=new Button("blue");
		yellow=new Button("Yellow");
		green=new Button("Green");
		
		incSize=new Button("Increse Brush");
		resSize=new Button("Reset Brush");
		
		p.add(red);
		p.add(blue);
		p.add(yellow);
		p.add(green);
		p.add(new Label("Drag the mouse to draw"));
		p.add(incSize);
		p.add(resSize);
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e)
			{
				xValue = e.getX();
				yValue = e.getY();
				repaint();
			}
		});
		
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				r=1;
				b=0;
				y=0;
				gr=0;
			}
		});
		
		blue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b=1;
				r=0;
				y=0;
				gr=0;
			}
		});
		
		yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				y=1;
				r=0;
				b=0;
				gr=0;
			}
		});
		
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gr=1;
				r=0;
				b=0;
				y=0;
			}
		});
		
		incSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				xSize=xSize+2;
				ySize=ySize+2;
			}
		});
		
		resSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				xSize=4;
				ySize=4;
			}
		});
	}
	
	public void paint(Graphics g){
		if(r==0 && b==0 && y==0){
			g.setColor(Color.black);
			g.fillOval(xValue, yValue, xSize, ySize);
		}
		if(r==1){
			g.setColor(Color.red);
			g.fillRect(xValue, yValue, xSize, ySize);
		}
		if(b==1){
			g.setColor(Color.blue);
			g.fillOval(xValue, yValue, xSize, ySize);
		}
		if(y==1){
			g.setColor(Color.yellow);
			g.fillOval(xValue, yValue, xSize, ySize);
		}
		if(gr==1){
			g.setColor(Color.green);
			g.fillOval(xValue, yValue, xSize, ySize);
		}
	}
}