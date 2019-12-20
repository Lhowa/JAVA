package instaClone;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class InstaClone, this class contains the main method as
 * well as the GUI and Cards for each "Page".
 */
public class InstaClone extends JFrame {

	File fileToSave;
	String currentFilePathString;
	JLabel filePathLabel;
	int count = 0;
	private JPanel contentPane;
	JProgressBar progressBar;
	JButton uploadbutton;
	JButton uploadMenuButton = new JButton("Upload");
	JButton homeMenuButton = new JButton("Home");
	JButton profileMenuButton = new JButton("Profile");
	JPanel imagePanel = new JPanel();//Creates the panel to store the images. This will later be placed on the scrollPane
	

	//The below file path will need to be altered to the location of users image folder within the package.******************
	String imagePathPrepend = "/Users/landonhowa/eclipse-workspace/TestInstaClone/src/images/";
	String stockImagePathPrepend = "/Users/landonhowa/eclipse-workspace/TestInstaClone/src/stockImages/";
	
	private JTextField captionTextField;
	String imageUploadCaption;
	public List <String> imagepaths = new ArrayList<>();
	public List <String> imageCaptions = new ArrayList<>();
	
	public List <String> stockImageCaptions = new ArrayList<>();
	public List <String> stockImagepaths = new ArrayList<>();
	JScrollPane scrollPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstaClone frame = new InstaClone();
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
	public InstaClone() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);//Default Size
		
		/**
		 * Generates the menu bar, navigates to the
		 * three pages.
		 */
		menuBarMethod();
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel homePanel = homePagePanelMethod();
		contentPane.add(homePanel, "p1");
		
		
		JPanel uploadPanel = uploadPagePanelMethod();
		contentPane.add(uploadPanel, "p2");
		
		JPanel liveFeedPanel = profilePagePanelMethod();
		contentPane.add(liveFeedPanel, "p3");
	}

	private JPanel profilePagePanelMethod() {
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout(0, 0));
		
		/**
		 * TODO
		 * Add Profile image and name in the profileLabel
		 */
		JLabel profileLabel = new JLabel("Profile");
		profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profilePanel.add(profileLabel, BorderLayout.NORTH);
		
		/**
		 * TODO
		 * Images to be added below in scrollPane in a three columns? forEachLoop through imagePaths arrayList?
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profilePanel.add(scrollPane, BorderLayout.CENTER);
		return profilePanel;
	}
	
	/********************************************************************************* End Profile Page */
	private JPanel uploadPagePanelMethod() {
		JPanel uploadPanel = new JPanel();
		uploadPanel.setLayout(new BorderLayout(0, 0));
		
		
		JLabel uploadLabel = new JLabel("Upload");
		uploadPanel.add(uploadLabel, BorderLayout.NORTH);
		uploadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel subUploadPanel = new JPanel();
		subUploadPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		subUploadPanel.setForeground(new Color(0, 0, 0));
		uploadPanel.add(subUploadPanel);
		subUploadPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
		filePathLabel = new JLabel("Select a file to upload");
		filePathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		filePathLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		subUploadPanel.add(filePathLabel);
		

		
		JButton browseButton = new JButton("Browse...");
		subUploadPanel.add(browseButton);
		captionTextField = new JTextField();
		captionTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(captionTextField.isEnabled() == true) {
					captionTextField.setText("");
				}
				
			}
		});
		captionTextField.setText("Write Caption Here....\r\n");
		subUploadPanel.add(captionTextField);
		captionTextField.setEnabled(false);
		captionTextField.setColumns(10);
		progressBar = new JProgressBar();
		subUploadPanel.add(progressBar);
		
		uploadbutton = new JButton("Upload...");
		subUploadPanel.add(uploadbutton);
		uploadbutton.setEnabled(false);
		uploadbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				//The below file path will need to be altered to the location of users image folder within the package.******************
				File newFile = new File(imagePathPrepend + "image" + count + ".jpg");
				fileToSave.renameTo(newFile);
				imagepaths.add("image" + count + ".jpg");//adds image path to array
				//System.out.println(imagepaths);
				imageUploadCaption = captionTextField.getText();//set variable to image caption
				//System.out.println(imageUploadCaption);
				imageCaptions.add(imageUploadCaption);//adds caption to array
				progressBar.setValue(100);
				captionTextField.setText("");
				
				//Files.copy(currentFilePathString, "/instaClone/workingimages/");
				
				
			}
		});
		
		
		
		/**
		 * Allows you to browse for images, "uploads" the image,  then saves the filepath to the array.
		 */		
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg"));
				if (fileChooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				  fileToSave = fileChooser.getSelectedFile();
				  currentFilePathString = fileChooser.getSelectedFile().toString();
				  System.out.println(currentFilePathString);
				  filePathLabel.setText("File to Upload: " + currentFilePathString);
				  uploadbutton.setEnabled(true);
				  captionTextField.setEnabled(true);
				 
				}
			}
		});
		return uploadPanel;
	}
	
	/********************************************************************************* End Upload Page */
	
	private JPanel homePagePanelMethod() {
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout(0, 0));
		JLabel homeLabel = new JLabel("Home");
		homePanel.add(homeLabel, BorderLayout.NORTH);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		/**
		 * TODO
		 * Images to be added below in scrollPane in a single column? forEachLoop through imagePaths arrayList?
		 * Padding between images will need to be added.
		 * On press of Refresh, the event handler should query the imagepath array, then create a new JLabel
		 * using the image path to set the background.
		 */
		
		/**
		 * @ author Amelia 
		 *  I removed the refresh button and linked it to the home button. So now when the user clicks the home button it will auto refresh. 
		 */
		
		/*JButton homeRefreshButton = new JButton("Refresh...");
		homeRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String p : imagepaths) {
					//add an image and caption at the index
					JLabel testLabel = new JLabel("Test worked");
					testLabel.setHorizontalAlignment(SwingConstants.CENTER);
					scrollPane.setViewportView(testLabel);
					
				}
			}
		});
		homePanel.add(homeRefreshButton, BorderLayout.SOUTH);*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		homePanel.add(scrollPane, BorderLayout.CENTER);
		
		/*
		
		JLabel stockImageLabel1 = new JLabel();//creates a label to house the first image
		stockImageLabel1.setIcon(new ImageIcon(stockImagePathPrepend + stockImagepaths.get(0).toString()));//sets image to first position in array
		stockImageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		stockImageLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		imagePanel.add( stockImageLabel1 );//forcing first image in array and adding to imagePanel
		JLabel stockTextLabel1 = new JLabel();//creates a label to house the first caption
		stockTextLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		stockTextLabel1.setText(stockImageCaptions.get(0));//sets text tom first caption in array
		imagePanel.add( stockTextLabel1 );
		JLabel stockImageLabel2 = new JLabel();//creates a label to house the first image
		stockImageLabel2.setIcon(new ImageIcon(stockImagePathPrepend + stockImagepaths.get(1).toString()));//sets image to first position in array
		stockImageLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		stockImageLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		imagePanel.add( stockImageLabel2 );//forcing first image in array and adding to imagePanel
		JLabel stockTextLabel2 = new JLabel();//creates a label to house the second caption
		stockTextLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		stockTextLabel2.setText(stockImageCaptions.get(1));//sets text tom second caption in array
		imagePanel.add( stockTextLabel2 );
		JLabel stockImageLabel3 = new JLabel();//creates a label to house the second image
		stockImageLabel3.setIcon(new ImageIcon(stockImagePathPrepend + stockImagepaths.get(2).toString()));//sets image to second position in array
		stockImageLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		stockImageLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		imagePanel.add( stockImageLabel3 );//forcing third image in array and adding to imagePanel
		JLabel stockTextLabel3 = new JLabel();//creates a label to house the third caption
		stockTextLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		stockTextLabel3.setText(stockImageCaptions.get(2));//sets text to third caption in array
		imagePanel.add( stockTextLabel3 );
			
		*/
		
		return homePanel;
	}
	
	/********************************************************************************* End HomePage */

	private void menuBarMethod() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(10, 0, 10, 0));
		setJMenuBar(menuBar);
		
		/**
		 * Navigates to the Upload page.
		 */
		
		/**
		 * Navigates to the Home page.
		 */
		
		
		/**
		 * Navigates to the Profile page.
		 */
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 10, 0, 10));
		menuBar.add(panel);
		panel.setLayout(new GridLayout(1, 0, 10, 0));
		//uploadMenuButton.setIcon(new ImageIcon(InstaClone.class.getResource("/resources/uploadSize25Pxl.png")));
		panel.add(uploadMenuButton);
		uploadMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnterHoverColorChange(uploadMenuButton);
			}

			
			@Override
			public void mouseExited(MouseEvent e) {
				mousExitHoverColorChange(uploadMenuButton);
			}


			
		});
		uploadMenuButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		uploadMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p2");
				changeBackgroundWhenClick(uploadMenuButton);
			}

			
		});
		//homeMenuButton.setIcon(new ImageIcon(InstaClone.class.getResource("/resources/homeSize25Pxl.png")));
		homeMenuButton.setBackground(backgroundColorPicker());
		panel.add(homeMenuButton);
		homeMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnterHoverColorChange(homeMenuButton);
			}

			
			@Override
			public void mouseExited(MouseEvent e) {
				mousExitHoverColorChange(homeMenuButton);
			}
		});
		
		homeMenuButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		homeMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p1");
				changeBackgroundWhenClick(homeMenuButton);
			}
			
			
		});
		
		// This is the new refresh button
		homeMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String p : imagepaths) {
					//Test data below *******************
					JLabel imageLabel1 = new JLabel();//creates a label to house the first image
					imageLabel1.setIcon(new ImageIcon(imagePathPrepend + imagepaths.get(0).toString()));//sets image to first position in array
					imageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
					imageLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
					JLabel textLabel1 = new JLabel();//creates a label to house the first caption
					textLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					textLabel1.setText(imageCaptions.get(0));//sets text tom first caption in array
					JLabel imageLabel2 = new JLabel();//creates a label to house the second image
					imageLabel2.setIcon(new ImageIcon(imagePathPrepend + imagepaths.get(1).toString()));//sets the image to second image in array
					imageLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
					imageLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
					JLabel textLabel2 = new JLabel();//creates the second label for the second caption
					textLabel2.setHorizontalAlignment(SwingConstants.CENTER);
					textLabel2.setText(imageCaptions.get(1));//sets the text to be the second in the caption array

					imagePanel.add( imageLabel1 );//forcing first image in array and adding to imagePanel
					imagePanel.add( textLabel1 );//forcing first caption in array and adding to imagePanel
					imagePanel.add( imageLabel2 );//forcing second image in array and adding to imagePanel
					imagePanel.add( textLabel2 );//forcing second image in array and adding to imagePanel

					scrollPane.setViewportView(imagePanel);//adds the image panel to the scrollPane itself
					//End Test **********************
					
					//This will be used to generate a new label forEach image Path in the array.
//					for (String p : imagepaths) {
//					}
					
		
					
				}
				
			}
		});
		
		
		
		
//		profileMenuButton.setIcon(new ImageIcon(InstaClone.class.getResource("/resources/profileSize25Pxl.png")));
		panel.add(profileMenuButton);
		profileMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnterHoverColorChange(profileMenuButton);
			}

			
			@Override
			public void mouseExited(MouseEvent e) {
				mousExitHoverColorChange(profileMenuButton);
			}
		});
		
		profileMenuButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		profileMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p3");
				changeBackgroundWhenClick(profileMenuButton);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	/**
	 * Changes the background of the icon when clicked
	 * @param button
	 */
	private void changeBackgroundWhenClick(JButton button) {
		uploadMenuButton.setBackground(new JButton().getBackground());
		homeMenuButton.setBackground(new JButton().getBackground());
		profileMenuButton.setBackground(new JButton().getBackground());
		button.setBackground(backgroundColorPicker());
		//TODO
		//figure out a pleasing color to set the button when it's clicked
		
	}
	
	/**
	 * Changes the background of the icon when hovering over it.
	 * @param button
	 */
	private void mouseEnterHoverColorChange(JButton button) {
		button.setBackground(button.getBackground().darker());
		
	}
	
	/**
	 * Changes the background of the icon back to what it should be. 
	 * @param button
	 */
	private void mousExitHoverColorChange(JButton button) {
		if (button.getBackground().equals(new JButton().getBackground().darker())) {
			button.setBackground(new JButton().getBackground());	
		} else if (button.getBackground().equals(backgroundColorPicker().darker())) {
			button.setBackground(backgroundColorPicker());
		} else if (button.getBackground().equals(backgroundColorPicker())){
			button.setBackground(backgroundColorPicker());
		}
		else {
			button.setBackground(new JButton().getBackground());
		}
		
		
	}
	
	/**
	 * Chose the background of the buttons you like. 
	 * @return
	 */
	
	private Color backgroundColorPicker() {
		return Color.pink;
	}

}
