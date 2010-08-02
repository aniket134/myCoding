import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;

public class First extends JFrame{
	/**
	 * Hello There
	 */
	public First()
	{
		int width = 300;
		int height = 250;
		JPanel main = new JPanel();
		JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton ok = new JButton("OK");
        JButton close = new JButton("Close");
        JTextField jtf1 = new JTextField("Hello there! No. 1");
        jtf1.setMaximumSize(new Dimension(main.getMaximumSize().width, 20));
        JTextField jtf2 = new JTextField("Hello there! No. 2");
        JTextField jtf3 = new JTextField("Hello there! No. 3");
        

        top.setBorder(BorderFactory.createTitledBorder("Search"));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        //jtf1.setAlignmentX(Component.LEFT_ALIGNMENT);
        jtf2.setAlignmentX(Component.LEFT_ALIGNMENT);
        jtf3.setAlignmentX(Component.LEFT_ALIGNMENT);
        top.add(jtf1);
        top.add(jtf2);
        top.add(jtf3);
        
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        ok.setAlignmentX(Component.LEFT_ALIGNMENT);
        close.setAlignmentX(Component.LEFT_ALIGNMENT);
        bottom.add(ok);
        bottom.add(close);
        
        //main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
        //main.setLayout(new BorderLayout(30, 30));
        //main.setAlignmentX(Component.LEFT_ALIGNMENT);
        //main.add(top);
        //main.add(bottom);
        Box boxes[] = new Box[4];
        boxes[ 2 ] = Box.createHorizontalBox();
        boxes[ 3 ] = Box.createVerticalBox();
        boxes[ 3 ].add(Box.createRigidArea(new Dimension(12, 8)));
        for ( int i = 0; i < 2; i++ ) {
            boxes[ 2 ].add( new JButton( "boxes[2]: " + i ) );
            boxes[ 2 ].add(Box.createRigidArea(new Dimension(12, 8)));
        }
        boxes[ 3 ].add(Box.createRigidArea(new Dimension(12, 8)));
        boxes[ 3 ].add( jtf1 );
        main.setLayout( new BorderLayout(30, 30) );
        main.add( boxes[ 2 ], BorderLayout.EAST);
        main.add( boxes[ 3 ], BorderLayout.WEST );
        add(main);
        setSize(width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	public static void main(String args[]) {
		new First();
	}
}
