/*<applet code=swing08 width=500 height=500></applet>*/
import java.awt.*;
import javax.swing.*;
public class swing08 extends JApplet 
{
	public void init()
	{
		Container contentPane = getContentPane();
//		contentPane.setLayout(new BorderLayout());;
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(20,20,2,5));
		int b=0;
		for(int i=0; i<400; i++)
			jp.add(new JButton("Button "+i));
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

		JScrollPane jsp = new JScrollPane(jp,v,h);

		contentPane.add(jsp);
	}
}
/*
    THE BorderLayout IN THESE EXAMPLES DOES NOT ALLOW THE COTENT TO GO OUT OF THE 500x500 SIZE THAT WE HAVE ALLOTED FOR THE APPLET.
WHILE THE JScrollPane PROVIDES US WITH SCROLL BARS SO THAT THE SIZE DOES NOT SHRINK IN ORDER TO FIT THE 400 BUTTONS.
IF WE DO NOT USE JScrollPane THEN WE GET 400 BUTTONS BUT SO SMALL SO THEY CAN FIT 500x500 BUT THE BORDER LAYOUT PREVENTS ITS OVERFLOW OUT OF THE SIZE OF THE APPLET(AS IT IS Center THERE IS VERY THIN BORDER ON ALL FOUR SIDES.
NO NEED OF BORDER LAYOUT WITH JScrollPane
*/