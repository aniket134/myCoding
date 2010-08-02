import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BoxLayoutTest extends JFrame {

    public BoxLayoutTest() {

        setTitle("Two Buttons");

        JPanel basic = new JPanel();
        JTextField jtf1 = new JTextField("Hello there! No. 1");
        JButton ok = new JButton("OK");
        JButton close = new JButton("Close");
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        //basic.add(Box.createVerticalGlue());
        add(basic);

        jtf1.setMaximumSize(new Dimension(50, 20));
        
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(Box.createRigidArea(new Dimension(15, 10)));
        top.add(jtf1);
        top.add(Box.createRigidArea(new Dimension(15, 10)));
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.add(ok);
        bottom.add(Box.createRigidArea(new Dimension(5, 0)));
        bottom.add(close);
        bottom.add(Box.createRigidArea(new Dimension(15, 0)));

        basic.add(top);
        basic.add(bottom);
        basic.add(Box.createRigidArea(new Dimension(0, 15)));

        setSize(500, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BoxLayoutTest();
    }
}
