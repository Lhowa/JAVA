package m03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class Module03Gui. This app dispays an image, a title label, and a button.
 * when the button is clicked, the image and the title label should reflect
 * each other.
 * @author landonhowa
 *
 */
public class Module03Gui extends JFrame {
	private JLabel imageLabel;
	private JLabel titleLabel;
	private JButton bottomButton;
	private String[] seasonsImage = {"fall.png","winter.png","spring.png","summer.png"};
	private String[] seasonsText = {"Fall","Winter","Spring","Summer"};
	private int seasonIndex = 0;
	private int seasonTextIndex = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Module03Gui frame = new Module03Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Cycles through the array, then repeats following the final index.
	 */
	public void cycleSeasons(){
		seasonIndex = ++seasonIndex % seasonsImage.length;
	}
	
	/**
	 * Cycles through the array, then repeats following the final index.
	 */
	public void cycleSeasonsText(){
		seasonTextIndex = ++seasonTextIndex % seasonsText.length;
	}

	/**
	 * Create the frame. This includes the titleLable, imageLabel, and the bottomButton.
	 */
	public Module03Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		titleLabel = titleLabel();
		contentPane.add(titleLabel, BorderLayout.NORTH);
		
		imageLabel = imageLabel();
		contentPane.add(imageLabel, BorderLayout.CENTER);
		
		bottomButton = bottomButton();
		contentPane.add(bottomButton, BorderLayout.SOUTH);
	}
	
	/**
	 * title label: this label starts with the text "Four Seasons".
	 * When the button is clicked, the title will reflect the array position.
	 * @return titleLabel.
	 */
	private JLabel titleLabel() {
		JLabel titleLabel = new JLabel("Four Seasons");
		titleLabel.setForeground(new Color(211,211,211));
		titleLabel.setBackground(new Color(230,230,230));
		titleLabel.setOpaque(true);
		titleLabel.setBorder(new EmptyBorder(10, 0, 8, 0));
		titleLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return titleLabel;
	}

	/**
	 * Image label: this label starts with the fall Image.
	 * When the button is clicked, the image will reflect the array position.
	 * @return imageLabel.
	 */
	private JLabel imageLabel() {
		JLabel imageLabel = new JLabel("");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setIcon(new ImageIcon(Module03Gui.class.getResource("/m03.images/" + seasonsImage[0])));;
		return imageLabel;
	}

	/**
	 * This button includes the test "As Time Moves On...".
	 * When selected this invokes both a cycleSeasons and a cycleSeasonsText methods
	 * mentioned above. This then changes the text and images to reflect their 
	 * respective arrays.
	 * @return bottomButton.
	 */
	private JButton bottomButton() {
		JButton bottomButton = new JButton("As Time Moves On...");
		bottomButton.setOpaque(true);
		bottomButton.setBackground(new Color(155,155,155));
		bottomButton.setForeground(new Color(230,230,230));
		bottomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cycleSeasons();
					cycleSeasonsText();
					titleLabel.setText(seasonsText[seasonTextIndex]);
		    		imageLabel.setIcon(new ImageIcon(Module03Gui.class.getResource("/m03.images/" + seasonsImage[seasonIndex])));;
			}
		});
		bottomButton.setBorder(new EmptyBorder(4, 0, 4, 0));
		return bottomButton;
	}

}
