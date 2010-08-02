
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
class FrameForFileDemo extends Frame
{
	FrameForFileDemo(String title)
	{
		super(title);
	MyWindowAdapter3 m = new MyWindowAdapter3(this);
	addWindowListener(m);
	}
}
class MyWindowAdapter3 extends WindowAdapter
{
	public MyWindowAdapter3(FrameForFileDemo f)
	{
		this.f = f;
	}
	FrameForFileDemo f;
	public void windowClosing(WindowEvent we)
	{
		f.setVisible(false);
	}	
}
class fileDialogDemo
{
	public static void main(String args[])	
	{
		Frame f = new FrameForFileDemo("File Dialog Demo");
		f.setVisible(true);
		f.setSize(200,200);
		FileDialog fd = new FileDialog(f,"Open File");
		fd.setVisible(true);
	}
}