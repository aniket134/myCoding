/*<applet code=applet33 height=500 width=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet33 extends Applet implements ActionListener,MouseListener
{
	Checkbox Win98,WinNT,Solaris,Mac;
	Button Win,Other;
	Panel osCards;
	CardLayout cardLO;
	public void init()
	{
		Win = new Button("Windows");
		Other = new Button("Others");
		
		add(Win);
		add(Other);
		
		cardLO = new CardLayout();
		osCards = new Panel();
		osCards.setLayout(cardLO);
		
		Win98 = new Checkbox("Windows 98/XP",true);
		WinNT = new Checkbox("Windows NT/200");
		Solaris = new Checkbox("Solaris");
		Mac = new Checkbox("Macintosh");
		
		Panel winPanel = new Panel();
		Panel otherPanel = new Panel();
		
		winPanel.add(Win98);
		winPanel.add(WinNT);
		
		otherPanel.add(Solaris);
		otherPanel.add(Mac);
		
		osCards.add(winPanel,"Windows");
		osCards.add(otherPanel,"Others");
	
		add(osCards);
			
		Win.addActionListener(this);
		Other.addActionListener(this);
		
		addMouseListener(this);
	}
	public void mousePressed(MouseEvent me)
	{
		cardLO.next(osCards);
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me)
	{
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}
	public void actionPerformed(ActionEvent ae)
	{
	if (ae.getSource()==Win) cardLO.show(osCards,"Windows");
	else cardLO.show(osCards,"Others");
	}
}