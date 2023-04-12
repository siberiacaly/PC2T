
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

public class calc {
	public calc() {
		initComponents();
	}
	
	private void initComponents() {
		
		
		JPanel gui = new JPanel(new BorderLayout(800,5));
		
		
		JLabel screen = new JLabel();
		gui.add(screen, BorderLayout.NORTH);
		
		JPanel eqCls = new JPanel();
		eqCls.setLayout(new GridLayout(2,1));

		JFrame frame = new JFrame("CALCULATOR");
		frame.setContentPane(gui);
		frame.setSize(1000, 800);
		
		
		
		JPanel panel = new JPanel(new GridLayout(4,3,3,3));
		
		
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "1");
			}
		});
		panel.add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "2");
			}
		});
		panel.add(twoButton);
		
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "3");
			}
		});
		panel.add(threeButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "4");
			}
		});
		panel.add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "5");
			}
		});
		panel.add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "6");
			}
		});
		panel.add(sixButton);

		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "7");
			}
		});
		panel.add(sevenButton);

		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "8");
			}
		});
		panel.add(eightButton);

		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "9");
			}
		});
		panel.add(nineButton);

		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "0");
			}
		});
		panel.add(zeroButton);
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "+");
			}
		});
		panel.add(plusButton);
		
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				screen.setText(help + "-");
			}
		});
		panel.add(minusButton);
		
		
		JButton eqvButton = new JButton("=");
		eqvButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String help = screen.getText();
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("JavaScript");
				int result;
				try {
					result = (int) engine.eval(help);
					screen.setText(String.valueOf(result));
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
			}
		});
		eqCls.add(eqvButton);

		
		JButton clearButton = new JButton("CLS");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("CLS")) {
		            screen.setText("");
		        }
			}
		});
		eqCls.add(clearButton);
		
		gui.add(eqCls,BorderLayout.SOUTH);
		
		
		gui.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new calc();
			}
		});
	}
	
}
