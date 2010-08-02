/*<applet code=menuDemo width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
class MenuFrame extends Frame
{
	String msg="";
	CheckboxMenuItem debug,test;
	MenuFrame(String title)
	{
		super(title);
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		
		Menu file = new Menu("File");
		MenuItem item01,item02,item03,item04;	
		file.add(item01=new MenuItem("New..."));
		file.add(item02=new MenuItem("Open..."));
		file.add(item03=new MenuItem("Save..."));
		file.add(item04=new MenuItem("Quit"));
		mbar.add(file);
		
		Menu edit = new Menu("Edit");
		MenuItem item05,item06,item07,item08;
		edit.add(item05=new MenuItem("Cut"));
		edit.add(item06=new MenuItem("Copy"));
		edit.add(item07=new MenuItem("Paste"));
		edit.add(item08=new MenuItem("-"));
		Menu sub = new Menu("Special");
		MenuItem item09,item10,item11;
		sub.add(item09=new MenuItem("First"));
		sub.add(item10=new MenuItem("Second"));
		sub.add(item11=new MenuItem("Third"));
		edit.add(sub);
		debug = new CheckboxMenuItem("Debug");
		test = new CheckboxMenuItem("Testing");
		edit.add(debug);
		edit.add(test);
		mbar.add(edit);

		MyMenuHandler handler = new MyMenuHandler(this);
	
		item01.addActionListener(handler);
		item02.addActionListener(handler);
		item03.addActionListener(handler);
		item04.addActionListener(handler);
		item05.addActionListener(handler);
		item06.addActionListener(handler);
		item07.addActionListener(handler);
		item08.addActionListener(handler);
		item09.addActionListener(handler);
		item10.addActionListener(handler);
		item11.addActionListener(handler);
		debug.addItemListener(handler);
		test.addItemListener(handler);
		
		MyWindowAdapter2 adapter = new MyWindowAdapter2(this);
		addWindowListener(adapter);
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,10,200);
		if(debug.getState())g.drawString("Debug is ON.",10,220);
		else g.drawString("Debug is OFF.",10,240);
		if(test.getState())g.drawString("Test is ON.",10,260);
		else g.drawString("Test is ON.",10,280);
	}
}
class DialogDemo extends Dialog implements ActionListener
{
	DialogDemo(Frame f, String title)
	{
		super(f,title,false);
		setLayout(new FlowLayout());
		setSize(200,150);
		add(new Label("Press this to exit."));
		Button b;
		add(b=new Button("Cancel"));
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
	public void paint(Graphics g)
	{
		g.drawString("This is in the dialog",10,100);
	}
	public void stop()
	{
		dispose();
		setVisible(false);
	}
	public void destroy()
	{
		dispose();
		setVisible(false);
	}
}
class MyWindowAdapter2 extends WindowAdapter
{
	MenuFrame mf;
	public MyWindowAdapter2(MenuFrame mf)
	{
		this.mf=mf;
	}
	public void windowClosing(WindowEvent we)
	{
		mf.setVisible(false);
	}
}
class MyMenuHandler implements ActionListener,ItemListener
{
	MenuFrame mf;
	public MyMenuHandler(MenuFrame mf)
	{
		this.mf=mf;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String msg = "You selected:  ";
		String a = (String)ae.getActionCommand();
		if(a.equals("New..."))
		{
			msg+="New...";
			String str = "This is a demo Dialog frame.";
			DialogDemo d = new DialogDemo(mf,str);
			d.setVisible(true);	
		}
		else if(a.equals("Open..."))msg+="Open...";
		else if(a.equals("Save"))msg+="Close";
		else if(a.equals("Quit"))msg+="Quit";
		else if(a.equals("Edit"))msg+="Edit";
		else if(a.equals("Cut"))msg+="Cut";
		else if(a.equals("Copy"))msg+="Copy";
		else if(a.equals("Paste"))msg+="Paste";
		else if(a.equals("First"))msg+="First";
		else if(a.equals("Second"))msg+="Second";
		else if(a.equals("Third"))msg+="Third";
		else if(a.equals("Debug"))msg+="Debug";
		else if(a.equals("Testing"))msg+="Testing";
		else{}
		mf.msg=msg;
		mf.repaint();	
	}
	public void itemStateChanged(ItemEvent ie)
	{	
		mf.repaint();
	}
}
public class menuDemo extends Applet
{
	Frame f;
	public void init()
	{
		f = new MenuFrame("Menu Demo");
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		setSize(new Dimension(width,height));
		f.setSize(width,height);
		f.setVisible(true);
	}
	public void start()
	{
		f.setVisible(true);
	}
	public void stop()
	{
		f.setVisible(false);

	}
}