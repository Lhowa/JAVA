package guiIntro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LabGuiIntro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiIntro frame = new LabGuiIntro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LabGuiIntro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblLbltitle = newLblTitle();
		contentPane.add(lblLbltitle, BorderLayout.NORTH);
		
		JButton btnWest = newLblBtn();
		contentPane.add(btnWest, BorderLayout.WEST);
		{
			JPanel textPanel = newTextPanel();
			contentPane.add(textPanel, BorderLayout.SOUTH);
		}
		{
			JLabel lblLblcenter = redLbl();
			contentPane.add(lblLblcenter, BorderLayout.CENTER);
		}
	}

	private JLabel redLbl() {
		JLabel lblLblcenter = new JLabel("Hi");
		lblLblcenter.setOpaque(true);
		lblLblcenter.setBackground(Color.RED);
		lblLblcenter.setForeground(Color.ORANGE);
		lblLblcenter.setFont(new Font("Lucida Grande", Font.PLAIN, 77));
		lblLblcenter.setHorizontalAlignment(SwingConstants.CENTER);
		return lblLblcenter;
	}

	private JPanel newTextPanel() {
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.GRAY);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			textPanel.add(lblName);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			textPanel.add(textField);
			textField.setColumns(16);
		}
		return textPanel;
	}

	private JButton newLblBtn() {
		JButton btnWest = new JButton("WEST");
		return btnWest;
	}

	private JLabel newLblTitle() {
		JLabel lblLbltitle = new JLabel("My First Gui");
		lblLbltitle.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		lblLbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbltitle.setForeground(Color.GREEN);
		lblLbltitle.setOpaque(true);
		lblLbltitle.setBackground(Color.BLUE);
		return lblLbltitle;
	}

}
