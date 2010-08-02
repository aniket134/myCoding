/*<applet code=swing09 width=500 height=500></applet>*/
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
import javax.swing.event.*;
public class swing09 extends JApplet implements TreeExpansionListener
{
	JTextField txt,jxt;
	JTree tree;
	public void init()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
		
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		
		DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
		
		top.add(a);
		a.add(a1);
		a.add(a2);
		top.add(b);
		b.add(b1);
		b.add(b2);
		
		tree = new JTree(top);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(tree,v,h);
		
		contentPane.add(jsp,BorderLayout.CENTER);	
		
		txt = new JTextField("",20);
		jxt = new JTextField("",20);
		contentPane.add(txt,BorderLayout.SOUTH);
		contentPane.add(jxt,BorderLayout.NORTH);		
		tree.addMouseListener(new MouseAdapter()
		{	
			public void mouseClicked(MouseEvent me)
			{	
				TreePath tp = tree.getPathForLocation(me.getX							(), me.getY());
				if(tp!=null) txt.setText(tp.toString());
				else {};
			}
		});
		tree.addTreeExpansionListener(this);
	}
		public void treeCollapsed(TreeExpansionEvent te)
		{
			jxt.setText(te.getPath().toString()+"  Tree Collapsed");
			txt.setText(te.getPath().toString()+"  Tree Collapsed");
		}
		public void treeExpanded(TreeExpansionEvent te)
		{	
			jxt.setText(te.getPath().toString()+"  Tree Expanded");
			txt.setText(te.getPath().toString()+"  Tree Expanded");
		}
}				