/*<applet code=swing10 width=500 height=100></applet>*/
import java.awt.*;
import javax.swing.*;
public class swing10 extends JApplet
{
	public void init()
	{
		Container contentPane = getContentPane();
//		contentPane.setLayout(new BorderLayout());
		String[] names = {"Name","Phone","Fax"};
		Object[][] data={
			{"Gail","4567",8675},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			{"Ken","1290",3478},
			};
		JTable jt = new JTable(data,names);	
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(jt,v,h);	
		contentPane.add(jsp);	
	}
}