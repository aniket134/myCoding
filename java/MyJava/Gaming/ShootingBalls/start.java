/*<applet code=start height=700 width=700>
<param name=speed value=15 />
</applet>*/
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class start extends Applet implements Runnable,ActionListener
{
	Button bPause,bStop,bStart;
	private MyBall redball;
	private MyBall blueball;
	AudioClip shot;
	AudioClip hit;
	AudioClip out;
	Cursor c;
	private Image dbimage;
	private Graphics dbg;
	boolean isStopped;
	Thread th;
	private int speed;
	private Player player;
	public void init()
	{
		bPause = new Button("Pause/Resume");
		bStop = new Button("Stop");
		bStart = new Button("Start");
		c= new Cursor(Cursor.CROSSHAIR_CURSOR);
		this.setCursor(c);
		Color blue = new Color(0,0,255);
		setBackground(Color.black);	
		speed = Integer.parseInt(getParameter("speed"));
		hit = getAudioClip(getCodeBase(),"gun.au");
		shot = getAudioClip(getCodeBase(),"miss.au");
		out = getAudioClip(getCodeBase(),"error.au");
		player = new Player();
		redball=new MyBall(10,190,250,1,-1,4,Color.red,player,out,this);
		blueball = new MyBall(10,190,250,1,1,3,blue,player,out,this);
		addMouseListener(new MyMouseAdapter(this));
		add(bStart);
		add(bStop);
		add(bPause);
		bPause.addActionListener(this);
		bStart.addActionListener(this);	
		bStop.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bPause) 
		{
			if (isStopped) isStopped = false;
			else isStopped =true;
		}
		if(ae.getSource() == bStop) 
		{
			stop();
		}
		if(ae.getSource() == bStart) 
		{
			stop();
			start();
		}
	}
	public void start()
	{
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g)
	{
		if (player.getLives() >= 0)
		{
			g.setColor (Color.yellow);
			g.drawString ("Score: " + player.getScore(), 10, 40);
			g.drawString ("Lives: " + player.getLives(), 300, 40);
			redball.paint(g);
			blueball.paint(g);
			if (isStopped)
			{
				g.setColor (Color.yellow);
				g.drawString ("Click Start to start Game!", 40, 200);
			}
		}
		else if (player.getLives() < 0)
		{
			g.setColor (Color.yellow);
			g.drawString ("Game over!", 130, 100);
			g.drawString ("You scored " + player.getScore() + " Points!", 90, 140);
			if (player.getScore() < 300) g.drawString ("Well, it could be better!", 100, 190);
			else if (player.getScore() < 600 && player.getScore() >= 300) g.drawString ("That was not so bad", 100, 190);
			else if (player.getScore() < 900 && player.getScore() >= 600) g.drawString ("That was really good", 100, 190);
			else if (player.getScore() < 1200 && player.getScore() >= 900) g.drawString ("You seem to be very good!", 90, 190);
			else if (player.getScore() < 1500 && player.getScore() >= 1200) g.drawString ("That was nearly perfect!", 90, 190);
			else if (player.getScore() >= 1500) g.drawString ("You are the Champingon!",100, 190);
			g.drawString ("Doubleclick on the Applet, to play again!", 20, 220);
			isStopped = true;	
		}
	}
	public void update (Graphics g)
	{
		if (dbimage == null)
		{
			dbimage = createImage (this.getSize().width, this.getSize().height);
			dbg = dbimage.getGraphics ();
		}

		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor (getForeground());
		paint (dbg);
		g.drawImage (dbimage, 0, 0, this);
	}

	public void stop()
	{
		th.stop();
	}
	public void check(int x, int y)
	{
		if(!isStopped)
		{
			if(redball.isHit(x,y))
			{
				hit.play();
				redball.ballWasHit();
			}
			if(blueball.isHit(x,y))
			{
				hit.play();
				blueball.ballWasHit();
			}
			else
			{
				shot.play();
			}
		}
	
	}
	public void run()
	{
		while(true)
		{
			if(player.getLives() >= 0 && !isStopped)
			{	
				redball.move();
				blueball.move();
			}
			repaint();
			try
			{
				Thread.sleep(speed);
			}
			catch(Exception e)
			{
			}
		}
	}
}
class MyMouseAdapter extends MouseAdapter
{
	start Start;
	public MyMouseAdapter(start S)
	{
		Start = S;
	}
	public void mouseClicked(MouseEvent me)
	{
		int x = me.getX();
		int y = me.getY();
		Start.check(x,y);
	}
}