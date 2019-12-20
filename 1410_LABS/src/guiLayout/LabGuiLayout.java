package guiLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
/**
 * Class GuiLayoutMananger.
 * This is an application that allows you to shift 
 * the blue background of a tile left or right.
 * @author landonhowa
 *
 */
public class LabGuiLayout extends JFrame {

	private JPanel contentPane;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblThree;
	private JLabel lblFour;
	int testPosition = 2;

	public int[] position = {0,1,2,3};
	private JPanel controlPanel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiLayout frame = new LabGuiLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame body including all elements.
	 */
	public LabGuiLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblDemoLayout = demo();
		contentPane.add(lblDemoLayout, BorderLayout.NORTH);
		
		JPanel controlPanel = control();
		controlPanel.setLayout(new GridLayout(4, 1, 0, 5));
		
		JButton btnLeftButton = left();
		controlPanel.add(btnLeftButton);
		
		JButton btnRightButton = right();
		controlPanel.add(btnRightButton);
		
		JPanel mainPanel = main();
		mainPanel.setLayout(new GridLayout(1, 0, 5, 0));
		
		lblOne = one();
		mainPanel.add(lblOne);
		
		lblTwo = two();
		mainPanel.add(lblTwo);
		
		lblThree = three();
		mainPanel.add(lblThree);
		
		lblFour = four();
		mainPanel.add(lblFour);
	}

	/**
	 * Creates the Fourth label.
	 * @return fourth label.
	 */
	private JLabel four() {
		JLabel lblFour = new JLabel("4");
		lblFour.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblFour.setOpaque(true);
		lblFour.setBackground(Color.YELLOW);
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		return lblFour;
	}

	/**
	 * Creates the Third label.
	 * @return third label.
	 */
	private JLabel three() {
		JLabel lblThree = new JLabel("3");
		lblThree.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblThree.setOpaque(true);
		lblThree.setBackground(Color.YELLOW);
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		return lblThree;
	}

	/**
	 * Creates the second label.
	 * @return second label.
	 */
	private JLabel two() {
		JLabel lblTwo = new JLabel("2");
		lblTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblTwo.setOpaque(true);
		lblTwo.setBackground(Color.BLUE);
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTwo;
	}
	
	/**
	 * Creates the first label
	 * @return main first
	 */
	private JLabel one() {
		JLabel lblOne = new JLabel("1");
		lblOne.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblOne.setOpaque(true);
		lblOne.setBackground(Color.YELLOW);
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		return lblOne;
	}
	
	/**
	 * Creates the main label
	 * @return main label
	 */
	private JPanel main() {
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		return mainPanel;
	}

	private JButton right() {
		JButton btnRightButton = new JButton("==>");
		btnRightButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnRightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * cycles through position, and sets the background colors for right.
				 */
				if (testPosition == 4) {
					testPosition = 1;
				}else {
					testPosition++;
				}
				//System.out.println(testPosition);
				
				switch (testPosition) {
				case 1: lblOne.setBackground(Color.BLUE);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.YELLOW);

					break;
				case 2: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.BLUE);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.YELLOW);
					
					break;
				case 3: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.BLUE);
						lblFour.setBackground(Color.YELLOW);
					
					break;
				case 4: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.BLUE);
					
					break;
				}
			}
		});
		btnRightButton.setHorizontalTextPosition(SwingConstants.LEADING);
		btnRightButton.setMinimumSize(new Dimension(20, 15));
		btnRightButton.setMaximumSize(new Dimension(20, 15));
		return btnRightButton;
	}

	private JButton left() {
		JButton btnLeftButton = new JButton("<==");
		btnLeftButton.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnLeftButton.addActionListener(new ActionListener() {
			/**
			 * cycles through position, and sets the background colors for left.
			 */
			public void actionPerformed(ActionEvent e) {	
				if (testPosition == 1) {
					testPosition = 4;
				}else {
					testPosition--;
				}
				//System.out.println(testPosition);
				
				switch (testPosition) {
				case 1: lblOne.setBackground(Color.BLUE);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.YELLOW);

					break;
				case 2: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.BLUE);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.YELLOW);
					
					break;
				case 3: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.BLUE);
						lblFour.setBackground(Color.YELLOW);
					
					break;
				case 4: lblOne.setBackground(Color.YELLOW);
						lblTwo.setBackground(Color.YELLOW);
						lblThree.setBackground(Color.YELLOW);
						lblFour.setBackground(Color.BLUE);
					
					break;
				}
			}
		});
		btnLeftButton.setMinimumSize(new Dimension(20, 15));
		btnLeftButton.setMaximumSize(new Dimension(20, 15));
		return btnLeftButton;
	}
	
	/**
	 * Creates the control panel.
	 * @return Control panel and dependencies
	 */
	private JPanel control() {
		controlPanel_1 = new JPanel();
		controlPanel_1.setBorder(new EmptyBorder(0, 5, 0, 5));
		contentPane.add(controlPanel_1, BorderLayout.WEST);
		return controlPanel_1;
	}

	/**
	 * Creates the demo panel.
	 * @return Demo panel and dependencies
	 */
	private JLabel demo() {
		JLabel lblDemoLayout = new JLabel("Demo Layout");
		lblDemoLayout.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblDemoLayout.setHorizontalAlignment(SwingConstants.CENTER);
		return lblDemoLayout;
	}

}
