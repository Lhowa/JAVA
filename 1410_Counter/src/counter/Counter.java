package counter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
/**
 * Class Counter, includes two jlabels and a jbutton
 * @author landonhowa
 *
 */
public class Counter extends JFrame {
	private JPanel contentPane;
	private int redCounter = 0;
	private JLabel lblcounterLbl;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame, adds the Name lbl, counter lbl and click me button.
	 */
	public Counter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblLandonsGui = landonLbl();
		contentPane.add(lblLandonsGui, BorderLayout.SOUTH);
		
		lblcounterLbl = counterLbl();
		contentPane.add(lblcounterLbl, BorderLayout.CENTER);
		
		JButton btnClickMe = clickMeBtn();
		contentPane.add(btnClickMe, BorderLayout.EAST);
	}

	/**
	 * displays {Your Name)'s GUI
	 * @return
	 */
	private JLabel landonLbl() {
		JLabel lblLandonsGui = new JLabel("Landon's GUI");
		lblLandonsGui.setOpaque(true);
		lblLandonsGui.setBackground(Color.LIGHT_GRAY);
		lblLandonsGui.setHorizontalAlignment(SwingConstants.CENTER);
		return lblLandonsGui;
	}
	
	/**
	 * Jbutton that generates a random number that corresponds with a color.
	 * If the color is red this increments a red counter.
	 * @return
	 */
	private JButton clickMeBtn() {
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int randomNumber = (int) (Math.random() * 5) + 1;
	
				
				switch (randomNumber) {
				case 1:
					btnClickMe.setBackground(Color.RED);
					redCounter++;
					lblcounterLbl.setText("Red Counter: 0" + redCounter);
					break;
				case 2:
					btnClickMe.setBackground(Color.BLUE);
					break;
				case 3:
					btnClickMe.setBackground(Color.GREEN);
					break;
				case 4:
					btnClickMe.setBackground(Color.ORANGE);
					break;
				case 5:
					btnClickMe.setBackground(Color.MAGENTA);
					break;

		
				}		
			}
		});
		btnClickMe.setBackground(Color.BLUE);
		btnClickMe.setForeground(Color.WHITE);
		btnClickMe.setOpaque(true);
		btnClickMe.setBorderPainted(false);
		btnClickMe.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		return btnClickMe;
	}

	/**
	 * Displays Red Counter: {Count of red}
	 * @param redCounter
	 * @return
	 */
	private JLabel counterLbl() {
		JLabel lblNewLabel = new JLabel("Red Counter: 0");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return lblNewLabel;
	}

}
