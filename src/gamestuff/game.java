package gamestuff;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class game {
	public static String consoleMessage;

	static JFrame frame = new JFrame("A Free Game about Adventures!");
	static JPanel panel = new JPanel(new GridBagLayout());
	static GridBagConstraints c = new GridBagConstraints();
	static JTextArea console = new JTextArea();
	static int health = 100;
	static JTextArea HUD = new JTextArea("Health: " + health +  "\n Inventory: \n none");
	static JTextArea userInput = new JTextArea();
	static Font tnr = new Font("Times New Roman", Font.PLAIN, 24);
	static String inputText = "";
	static Boolean acceptInput = false;
	static ChapterOne chapterone = new ChapterOne();

	public static void main(String[] args) {
		startup();
		chapterone.start();
	}

	public static void startup() {
		addTextBox(console, 0, 0, 600, 300, 2, 1, false);
		addTextBox(HUD, 2, 0, 300, 300, 2, 1, false);
		addTextBox(userInput, 0, 3, 300, 24, 1, 2, true);
		userInput.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					inputText = userInput.getText();
					inputText = inputText.replaceAll("\n", "");
					userInput.setText("");
					printMessage("\n" + "-" + inputText + "\n");
					chapterone.interrupt();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});
		printMessage("Welcome!");
		frame.add(panel);
		frame.setSize(1000, 600);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void addTextBox(JTextArea textbox, int localx, int localy, int sizex, int sizey, int width,
			int height, boolean editable) {
		JScrollPane scroll = new JScrollPane(textbox);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		c.gridwidth = width;
		c.gridheight = height;
		c.ipadx = sizex;
		c.ipady = sizey;
		c.gridx = localx;
		c.gridy = localy;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 0);
		panel.add(scroll, c);
		textbox.setFont(tnr);
		textbox.setEditable(editable);
		textbox.setMinimumSize(new Dimension(sizex, sizey));
	}

	public static void printMessage(String text) {
		consoleMessage = ("\n" + text);
		console.append(consoleMessage);
		console.setCaretPosition(console.getText().length());

	}

	public static void clearConsole() {
		consoleMessage = "";
		console.setText("");
	}
	public static void changeHealth (int amount){
		HUD.setText(HUD.getText().replaceAll(Integer.toString(health), Integer.toString(health+amount)));
		health+= amount;
	}

}
