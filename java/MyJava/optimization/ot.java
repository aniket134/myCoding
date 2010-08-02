
/* IF THIS CLASS WAS NOT MADE A PART OF THIS PACKAGE, THEN OT1.CLASS WOULD NOT HAVE BEEN IMPORTED
BECAUSE OT1.CLASS IS A PART OF package OT */

/* IT WILL COMPILE LIKE ORDINARY, BUT TO RUN IT: 
java OT.OT
AND WE WILL ALSO HAVE TO BE IN THE DIRECTORY ABOVE THIS DIRECTORY.
FOR MORE READ PG-227 OF COMPLETE REFERENCE*/
/*<applet code=ot width=500 height=500></applet>*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ot extends JApplet implements ActionListener{

	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	String s1 = "Enter Objective function:";
	String s2 = "Enter constraint 1:";
	String s3 = "Enter constraint 2:";
	float [] answer = new float[3];
	ot1 first = new ot1();

	public void init(){
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
//		first = new org.ot1(3);
		
		jtf1 = new JTextField(s1,10);
		jtf2 = new JTextField(s2,10);
		jtf3 = new JTextField(s3,10);
		jtf1.selectAll();
		jtf2.selectAll();
		jtf3.selectAll();
		cp.add(jtf1);
		cp.add(jtf2);
		cp.add(jtf3);

		JButton jb = new JButton("Solve");
		jb.addActionListener(this);
		cp.add(jb);
		
	}
	public void actionPerformed(ActionEvent ae){
		s1=jtf1.getText();
		s2=jtf2.getText();
		s3=jtf3.getText();
		
		repaint();
	}
	public void paint(Graphics g){
		
		if(s1!=null){
			g.drawString(s1,30,100);
		}
		if(s2!=null){
			g.drawString(s2,20,120);
		}
		if(s3!=null){
			g.drawString(s3,20,170);
		}
	}
}