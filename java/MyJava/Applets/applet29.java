/*<applet code=applet29 width=500 height=500></applet>*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class applet29 extends Applet
{
	public void init()
	{
		String s = "There are two ways of constructing " +
"a software design.\n" +
"One way is to make it so simple\n" +
"that there are obviously no deficiencies.\n" +
"And the other way is to make it so complicated\n" +
"that there are no obvious deficiencies.\n\n" +
" -C.A.R. Hoare\n\n" +
"There's an old story about the person who wished\n" +
"his computer were as easy to use as his telephone.\n" +
"That wish has come true,\n" +
"since I no longer know how to use my telephone.\n\n" +
" -Bjarne Stroustrup, AT&T, (inventor of C++)";
		TextArea t = new TextArea(s,20,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
		add(t);
	}
}