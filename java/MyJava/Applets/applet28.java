/*<applet code=applet28 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class applet28 extends Applet implements ActionListener
{
	TextField name,pass;
	String msg="";
	public void init()
	{
		Label n = new Label("Name: ",Label.RIGHT);
		Label p = new Label("Password: ",Label.LEFT);
		name = new TextField("Your Name",12);
		pass = new TextField(8);
		add(name);
		add(pass);
		add(n);
		add(p);
		name.select(0,name.getText().length());
		pass.setEchoChar('*');
		name.addActionListener(this);
		pass.addActionListener(this);
		
		
		
		resumewebd r = new resumewebd();
		try{
			r.publishDocument();
			}
			catch(Exception e){
			System.out.println(e);
			}
	}
	public void actionPerformed(ActionEvent ae)
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString("Name: "+name.getText(),6,60);
		g.drawString("The selected text is: "+name.getSelectedText(),6,80);	
		g.drawString("Password: "+pass.getText(),6,100);	
	}
}