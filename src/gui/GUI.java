package gui;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class GUI extends JFrame {
	//Add components
	JFrame frame = new JFrame();
	JPanel top = new JPanel();
	JPanel center = new JPanel();
	public void setup() {
		//Setup frame
		frame.setTitle("Strategy Tournament v0.1");
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		//Initialize components
		JLabel textLabel = new JLabel("Click me!");
		JButton next = new JButton("Got it!");
		JPanel buttons = new JPanel();
		JPanel credits = new JPanel();
		JLabel credit1 = new JLabel("Inspired by Universal Paperclips;");
		JLabel credit2 = new JLabel("made during the quarantine on 4/8/20.");
		//Add buttton action
		ActionListener nextClicked = new ActionListener() {
			public void actionPerformed(ActionEvent clicked) {
				textLabel.setText(":)");
			}
		};
		next.addActionListener(nextClicked);
		//Display frame
		top.add(textLabel);
		top.add(next);
		frame.add(top, BorderLayout.PAGE_START);
		frame.add(buttons, BorderLayout.LINE_START);
		frame.add(center, BorderLayout.CENTER);
		credits.add(credit1);
		credits.add(credit2);
		frame.add(credits, BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	public void update() {
		
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setup();
	}
}