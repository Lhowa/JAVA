package changingImages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JCheckBox;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
/**
 * Class ChangingImages.
 * This application allows you to select an 
 * image that you would like to change. If
 * no image was selected, the app will default.
 * @author landonhowa
 *
 */
public class ChangingImages extends JFrame {
	private String[] topImages = {"top3.png","top1.png","top2.png"};
	private String[] middleImages = {"middle3.png","middle1.png","middle2.png"};
	private String[] bottomImages = {"bottom3.png","bottom1.png","bottom2.png"};
	private String[] defaultImages = {"defaultTop.png","defaultMiddle.png","defaultBottom.png"};
	private int topImageIndex = 0;
	private int middleImageIndex = 0;
	private int bottomImageIndex = 0;

	
	private JPanel contentPane;
	private JCheckBox checkBoxTop;
	private JLabel labelTop;
	private JCheckBox checkBoxBottom;
	private JCheckBox checkBoxMiddle;
	private JLabel labelMiddle;
	private JLabel labelBottom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangingImages frame = new ChangingImages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Cycles through the array of images
	 */
	public void cycleTopImages(){
		topImageIndex = ++topImageIndex % topImages.length;
	}
	public void cycleMiddleImages(){
		middleImageIndex = ++middleImageIndex % middleImages.length;
	}
	public void cycleBottomImages(){
		bottomImageIndex = ++bottomImageIndex % bottomImages.length;
	}

	/**
	 * Create the frame.
	 */
	public ChangingImages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = mainPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		JPanel controlPanel = controlPanel();
		controlPanel.setLayout(new GridLayout(4, 1, 0, 0));
	}

	/**
	 * Creates and returns the control panel
	 * including the change button and the
	 * check boxes.
	 * @return Change button and check boxes.
	 */
	private JPanel controlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
		contentPane.add(controlPanel, BorderLayout.WEST);
		{
			checkBoxTop = new JCheckBox("Top Box");
			controlPanel.add(checkBoxTop);
		}
		{
			checkBoxMiddle = new JCheckBox("Middle Box");
			controlPanel.add(checkBoxMiddle);
		}
		{
			checkBoxBottom = new JCheckBox("Bottom Box");
			controlPanel.add(checkBoxBottom);
		}
		{
			/**
			 * Implements the new backgrounds and cycles the images.
			 */
			JButton updateButton = new JButton("Change");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkBoxTop.isSelected()) {
						cycleTopImages();
			    		labelTop.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + topImages[topImageIndex])));;
					}
					if (checkBoxMiddle.isSelected()) {
						cycleMiddleImages();
						labelMiddle.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + middleImages[middleImageIndex])));;
					}
					if (checkBoxBottom.isSelected()) {
						cycleBottomImages();
						labelBottom.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + bottomImages[bottomImageIndex])));;
					}
					if(!checkBoxTop.isSelected() && !checkBoxMiddle.isSelected() && !checkBoxBottom.isSelected()) {
						labelTop.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + defaultImages[0])));;
						labelMiddle.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + defaultImages[1])));;
						labelBottom.setIcon(new ImageIcon(ChangingImages.class.getResource("/images/" + defaultImages[2])));;
					}
				}
			});
			controlPanel.add(updateButton);
		}
		return controlPanel;
	}
	
	/**
	 * Implements and returns the main panel.
	 * This panel includes the labels with the
	 * images.
	 * @return labels with images.
	 */
	private JPanel mainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1, 0, 0));
		{
			labelTop = new JLabel();
			mainPanel.add(labelTop);
		}
		{
			labelMiddle = new JLabel();
			mainPanel.add(labelMiddle);
		}
		{
			labelBottom = new JLabel();
			mainPanel.add(labelBottom);
		}
		return mainPanel;
	}
	

}
