
from org.lirc import *;
from org.lirc.util import *;
from org.lirc.ui import *;

from java.awt import *;
from java.awt.event import *;
from javax.swing import *;
from java.lang.reflect import *;
from java.io import *;
from java.util import *;

class MoveDot extends JFrame 
	 DotPanel panel;
	
	 SimpleLIRCClient client;

	 MoveDot( configFile,  width,  height) throws LIRCException, FileNotFoundException, IOException 
		super("MoveDot");
		addWindowListener(new WindowAdapter() 
		  	 def windowClosing(WindowEvent e) 
				quit();
			
		);
		panel = new DotPanel(width, height);
		setContentPane(panel);
		pack();
		show();

		client = new SimpleLIRCClient(configFile);
		client.addIRActionListener(new MoveListener());
	

	 def moveUp() 
		panel.moveDot(0, -1);
	

	 def moveDown() 
		panel.moveDot(0, 1);
	

	 def moveLeft() 
		panel.moveDot(-1, 0);
	

	 def moveRight() 
		panel.moveDot(1, 0);
	

	 def quit() 
		dispose();
		client.stopListening();
		System.exit(0);
	

	  def error(Exception ex) 
		System.err.println(ex.to());
	

	 class MoveListener(IRActionListener):
		 def action( command) 
			try 
				Method m = MoveDot.class.getMethod(command, null);
				m.invoke(MoveDot.this, null);
			 catch (NoSuchMethodException ex) 
				error(ex);
			 catch (IllegalAccessException ex) 
				error(ex);
			 catch (InvocationTargetException ex) 
				error(ex);
			
		
	

	 class DotPanel(JPanel):
		  width;
		  height;
		  Point dot;

		 DotPanel( width,  height) 
			this.width = width;
			this.height = height;
			dot = new Point(width / 2, height / 2);
			setPreferredSize(new Dimension(width, height));
   		

		 def paintComponent(Graphics g) 
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(dot.x-1, dot.y-1, 3, 3);
		

		 def moveDot( dx,  dy) 
			dot.x += dx;
			dot.y += dy;
			repaint();
		
	

	  def main([] args) 
		try 
			MoveDot game = new MoveDot("MoveDot.lirc", 200, 200);
		 catch (FileNotFoundException ex) 
			error(ex);
		 catch (LIRCException ex) 
			error(ex);
		 catch (IOException ex) 
			error(ex);
		
	



