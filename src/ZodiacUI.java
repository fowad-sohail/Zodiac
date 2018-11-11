import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;

public class ZodiacUI extends JFrame {

	private Dimension dim;
	private int xLocation;
	private int yLocation;
	private JPanel panel;
	private JPanel inputArea;

	public ZodiacUI() {

		xLocation = 800;
		yLocation = 100;
		dim = new Dimension(400, 150);

		panel = makeBackground();
		inputArea = makeInputArea();

		constructGUI();

	}

	private JPanel makeBackground() {
		// This is the background
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setSize(dim);
		panel.setBackground(Color.DARK_GRAY);
		add(panel);

		return panel;

	}

	private JPanel makeInputArea() {

		// Input area that has enter ur birthdate and the textfield
		JPanel inputArea = new JPanel();
		inputArea.setLayout(new FlowLayout());
		// inputArea.setMinimumSize(new Dimension(400,150));
		inputArea.setPreferredSize(new Dimension(380, 50));
		inputArea.setBackground(new Color(250, 230, 230));
		inputArea.setBorder(BorderFactory.createTitledBorder("Input Area"));
		// inputArea.add(new JLabel("Enter your birthday in DD/MM/YYYY format:"));
		panel.add(inputArea);

		return inputArea;
	}

	
	
	// this is a mess and should be written in separate methods like
	// createInputArea() that would make all those components and add them to the
	// panel
	// I didnt really have time to do fix up formatting here, but it works as is
	private void constructGUI() {
		setTitle("What's Your Sign?");

		setMinimumSize(dim);

		setPreferredSize(dim);
		setLocation(xLocation, yLocation);

		JLabel birthdatePrompt = new JLabel("Enter your birthday in DD/MM/YYYY format:");
		// birthdatePrompt.setFont(birthdatePrompt.getFont().deriveFont(8.49f));
		JTextField textbox = new JTextField(10);
		// textbox.setPreferredSize(new Dimension(1s,10));
		JTextField zodiacSign = new JTextField();
		textbox.addKeyListener(new KeyListener() {

			// spin up zodiac and figure out the zodiac sign for the given date

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					String userDate = textbox.getText();
					try {
						zodiacSign.setText(getZodiacSign(userDate));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// textbox.setPreferredSize(new Dimension(1,1));
		inputArea.add(birthdatePrompt);
		inputArea.add(textbox);
		panel.add(inputArea);

		JPanel zodiacPrompt = new JPanel();
		zodiacPrompt.setLayout(new GridLayout(1, 1));
		zodiacPrompt.setPreferredSize(new Dimension(150, 48));
		zodiacPrompt.setBackground(new Color(250, 200, 200));
		Border bord = BorderFactory.createTitledBorder("Your Zodiac Sign");
		zodiacPrompt.setBorder(bord);

		panel.add(zodiacPrompt);

		zodiacSign.setEditable(false);
		zodiacPrompt.add(zodiacSign);

		JButton clear = new JButton();
		clear.setText("Clear Text");
		panel.add(clear);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textbox.setText("");
				zodiacSign.setText("");
			}
		});

//		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public String getZodiacSign(String date) throws ParseException {
		Driver.createZodiacTable();
		Date birthdate = Driver.getBirthdate(date);
		return ZodiacTable.determineSign(birthdate);
	}

}
