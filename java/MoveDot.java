/**************************************************************************/
/*
/* MoveDot.java -- A simple jlirc demo.
/* Copyright (C) 2001 Bjorn Bringert (bjorn@mumblebee.com)
/*
/* This program is free software; you can redistribute it and/or
/* modify it under the terms of the GNU General Public License
/* as published by the Free Software Foundation; either version 2
/* of the License, or (at your option) any later version.
/*
/* This program is distributed in the hope that it will be useful,
/* but WITHOUT ANY WARRANTY; without even the implied warranty of
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
/* GNU General Public License for more details.
/*
/* You should have received a copy of the GNU General Public License
/* along with this program; if not, write to the Free Software
/* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
/*
/**************************************************************************/

import org.lirc.*;
import org.lirc.util.*;
import org.lirc.ui.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.*;

/** Lets the user move a dot on the screen using remote control buttons.
	Demonstrates usage of the SimpleLIRCClient class.

	@version $Revision: 1.7 $
	@author Bjorn Bringert (bjorn@mumblebee.com)
*/
public class MoveDot extends JFrame {
	private DotPanel panel;
	private JLabel label;
	private SimpleLIRCClient client;

	/** Creates a new panel with a point that can be moved. */
	public MoveDot(String configFile, int width, int height) throws LIRCException, FileNotFoundException, IOException {
		super("MoveDot");
		addWindowListener(new WindowAdapter() {
		  	public void windowClosing(WindowEvent e) {
				quit();
			}
		});
		panel = new DotPanel(width, height);
		label = new JLabel("Hello there");
		setContentPane(panel);
		pack();
		show();

		client = new SimpleLIRCClient(configFile);
		client.addIRActionListener(new MoveListener());
	}

	/** Moves the dot one step upwards. */
	public void moveUp() {
		panel.moveDot(0, -1);
	}

	/** Moves the dot one step downwards. */
	public void moveDown() {
		panel.moveDot(0, 1);
	}

	/** Moves the dot one step left. */
	public void moveLeft() {
		panel.moveDot(-1, 0);
	}

	/** Moves the dot one step right. */
	public void moveRight() {
		panel.moveDot(1, 0);
	}
	
	public void printA() {
		label.setText("AAAAAA");
	}

	public void printB() {
		label.setText("BBBBBB");
	}

	/** Exits this program. */
	public void quit() {
		dispose();
		client.stopListening();
		System.exit(0);
	}

	/** Prints an error message. */
	private static void error(Exception ex) {
		System.err.println(ex.toString());
	}

	private class MoveListener implements IRActionListener {
		/** 	Invokes a method specifed by an string.
			@param act an string which will give the name of a
			method of the MoveDot class that will be invoked.
		*/
		public void action(String command) {
			try {
				Method m = MoveDot.class.getMethod(command, null);
				m.invoke(MoveDot.this, null);
				//if(command.equals("moveUp")){
				//	MoveDot.this.moveUp();
				//}
			} catch (NoSuchMethodException ex) {
				error(ex);
			} catch (IllegalAccessException ex) {
				error(ex);
			} catch (InvocationTargetException ex) {
				error(ex);
			} catch (Exception e) {
			}
		}
	}

	private class DotPanel extends JPanel{
		private int width;
		private int height;
		private Point dot;

		public DotPanel(int width, int height) {
			this.width = width;
			this.height = height;
			dot = new Point(width / 2, height / 2);
			setPreferredSize(new Dimension(width, height));
   		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(dot.x-1, dot.y-1, 3, 3);
		}

		/** 	Moves the dot.
			@param dx x difference
			@param dx y difference
		*/
		public void moveDot(int dx, int dy) {
			dot.x += dx;
			dot.y += dy;
			repaint();
		}
	}

	public static void main(String[] args) {
		try {
			MoveDot game = new MoveDot("MoveDot.lirc", 200, 200);
		} catch (FileNotFoundException ex) {
			error(ex);
		} catch (LIRCException ex) {
			error(ex);
		} catch (IOException ex) {
			error(ex);
		}
	}

}

