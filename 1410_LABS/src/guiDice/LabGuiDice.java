package guiDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;

import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class LabGuiDice extends JFrame {
	private JLabel lblNewLabel;
	private JPanel contentPane;
	private int roll;
	ArrayList<Integer> rolled = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame, includes the new button and label.
	 */
	public LabGuiDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnRollEm = newRollBtn();
		contentPane.add(btnRollEm, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = newDieLbl();
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * @return new Jlabel, if size of the array is 0 add the original dice number.
	 */
	private JLabel newDieLbl() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		    int randomDice = (int) (Math.random() * 6) + 1;
		lblNewLabel.setIcon(new ImageIcon(LabGuiDice.class.getResource("/images/die-" + randomDice + ".png")));
		if (rolled.size() == 0) {
			rolled.add(randomDice);
		}
		return lblNewLabel;
	}
	
	/**
	 * Generate a random number between 1-6.
	 * add it to the array for comparison
	 * @return new number
	 */
	private int rollTheDice() {
	    roll = (int) (Math.random() * 6) + 1;
	    rolled.add(roll);
	    return roll;
	}
	
	/**
	 * Roll the Dice, then check the previous number in the array
	 * to see if it matches, if so roll the dice again, otherwise
	 * add the number to the array and change the image.
	 * @return new dice image
	 */
	private JButton newRollBtn() {
		JButton btnRollEm = new JButton("Roll 'Em");
		btnRollEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JLabel lblNewLabel = newDieLbl();
			    
			    rollTheDice();

			    	if (rolled.get(rolled.size()-1) != rolled.get(rolled.size()-2)) {
			    		System.out.println(rolled);
			    		lblNewLabel.setIcon(new ImageIcon(LabGuiDice.class.getResource("/images/die-" + roll + ".png")));;
				    	contentPane.remove(1);
					    contentPane.add(lblNewLabel, BorderLayout.CENTER);
					    contentPane.revalidate();
					    contentPane.repaint();
			    	}else {
					    rollTheDice();
					    lblNewLabel.setIcon(new ImageIcon(LabGuiDice.class.getResource("/images/die-" + roll + ".png")));;
				    	contentPane.remove(1);
					    contentPane.add(lblNewLabel, BorderLayout.CENTER);
					    contentPane.revalidate();
					    contentPane.repaint();
			    	}
				}

		});
		btnRollEm.setFont(new Font("Optima", Font.BOLD, 20));
		btnRollEm.setForeground(Color.RED);
		btnRollEm.setBackground(Color.GREEN);
		return btnRollEm;
	}

}
