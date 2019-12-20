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
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.FlowLayout;

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
	//The below file path will need to be altered to the location of users image folder within the package.******************
	String imagePathPrepend = "/Users/landonhowa/eclipse-workspace/TestInstaClone/src/images/";
	String stockImagePathPrepend = "/Users/landonhowa/eclipse-workspace/TestInstaClone/src/stockImages/";
	JProgressBar progressBar;
	JButton uploadbutton;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);//Default Size
		
		/**
		 * Generates the menu bar, navigates to the
		 * three pages with current UI.
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
	
	/*Begin Profile Page*********************************************************************************/
	
	private JPanel profilePagePanelMethod() {
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel profileHeaderPanel = new JPanel();//Used to house the profile image and User's name
		profileHeaderPanel.setBorder(new EmptyBorder(40, 0, 40, 0));
		profilePanel.add(profileHeaderPanel, BorderLayout.NORTH);
		profileHeaderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel profileImage = new JLabel("Profileimage");//This will be used to show an image of the User
		profileImage.setBorder(new EmptyBorder(0, 0, 0, 50));
		profileImage.setHorizontalAlignment(SwingConstants.LEFT);
		profileHeaderPanel.add(profileImage);
		
		JLabel profileHeaderUsername = new JLabel("username");//Display the user's name
		profileHeaderUsername.setBorder(new EmptyBorder(0, 50, 0, 0));
		profileHeaderUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		profileHeaderPanel.add(profileHeaderUsername);



		JPanel profileImagesPanel = new JPanel();//Images will be placed on this panel, this panel is then placed on the scrollPane
		profileImagesPanel.setLayout(new GridLayout(1, 3, 0, 1));//1row X 3collumn with no height gap and 1px width gap, add more rows for over 3 pic's
		
		//Below are the test Images, once these are forced to a smaller size these will fit to screen. Horizontal scrolling is disables
		//stockImagePathPrepend will need to be changed if not already done.
		JLabel testProfileImage1 = new JLabel();
		testProfileImage1.setIcon(new ImageIcon(stockImagePathPrepend +"stockImages1.jpg"));
		testProfileImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		testProfileImage1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		JLabel testProfileImage2 = new JLabel();
		testProfileImage2.setIcon(new ImageIcon(stockImagePathPrepend +"stockImages2.jpg"));
		testProfileImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		testProfileImage2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		
		JLabel testProfileImage3 = new JLabel();
		testProfileImage3.setIcon(new ImageIcon(stockImagePathPrepend +"stockImages3.jpg"));
		testProfileImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		testProfileImage3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		
		JScrollPane profileScrollPane = new JScrollPane(profileImagesPanel);
		profileScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profilePanel.add(profileScrollPane, BorderLayout.CENTER);
		
		//adds the test images to the profileImagePanel
		profileImagesPanel.add( testProfileImage1 );
		profileImagesPanel.add( testProfileImage2 );
		profileImagesPanel.add( testProfileImage3 );
		profileScrollPane.setViewportView(profileImagesPanel);//Display's the imagePanel on the scrollPane
		
		return profilePanel;
		
		
	}
	
	/*Begin Upload Page******************************************************************************** End Profile Page */

	private JPanel uploadPagePanelMethod() {
		JPanel uploadPanel = new JPanel();
		uploadPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JLabel uploadLabel = new JLabel("Upload");
		uploadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uploadPanel.add(uploadLabel);
		
		filePathLabel = new JLabel("Select a file to upload");
		uploadPanel.add(filePathLabel);
		
		uploadbutton = new JButton("Upload...");
		uploadbutton.setEnabled(false);
		captionTextField = new JTextField();
		captionTextField.setEnabled(false);
		uploadbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				File newFile = new File(imagePathPrepend + "image" + count + ".jpg");
				fileToSave.renameTo(newFile);
				imagepaths.add("image" + count + ".jpg");//adds image path to array
				//System.out.println(imagepaths);
				imageUploadCaption = captionTextField.getText();//set variable to image caption
				//System.out.println(imageUploadCaption);
				imageCaptions.add(imageUploadCaption);//adds caption to array
				progressBar.setValue(100);
				captionTextField.setText("");

			}
		});
		

		/**
		 * Allows you to browse for images, "uploads" the image,  then saves the filepath to the array.
		 */
		JButton browseButton = new JButton("Browse...");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(filter);
				if (fileChooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				  fileToSave = fileChooser.getSelectedFile();
				  currentFilePathString = fileChooser.getSelectedFile().toString();
				  //System.out.println(currentFilePathString);
				  filePathLabel.setText("File to Upload: " + currentFilePathString);
				  uploadbutton.setEnabled(true);
				  captionTextField.setEnabled(true);
				}
			}
		});
		uploadPanel.add(browseButton);
		
		JLabel imageCaptionLabel = new JLabel("Place image caption below...");
		imageCaptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		uploadPanel.add(imageCaptionLabel);
		uploadPanel.add(captionTextField);
		captionTextField.setColumns(10);
		progressBar = new JProgressBar();
		uploadPanel.add(progressBar);
		uploadPanel.add(uploadbutton);
		return uploadPanel;
	}
	
	/*Begin Home Page******************************************************************************** End Upload Page */
	
	private JPanel homePagePanelMethod() {
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout(0, 0));
		JLabel homeLabel = new JLabel("Home");
		homePanel.add(homeLabel, BorderLayout.NORTH);
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel imagePanel = new JPanel();//Creates the panel to store the images. This will later be placed on the scrollPane
		
		
		
		JButton homeRefreshButton = new JButton("Refresh...");
		homeRefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
//				for (String p : imagepaths) {
//				}
			}
		});
		
		//Stock image and caption logic below...
		stockImagepaths.add("stockImages1.jpg");
		stockImagepaths.add("stockImages2.jpg");
		stockImagepaths.add("stockImages3.jpg");
		stockImageCaptions.add("Stock image test 1");
		stockImageCaptions.add("Stock image test 2");
		stockImageCaptions.add("Stock image test 3");
		
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
		
		homePanel.add(homeRefreshButton, BorderLayout.SOUTH);
		scrollPane = new JScrollPane( imagePanel );//adds the imagePanel to the scrollPanel
		imagePanel.setLayout(new GridLayout(0, 1, 0, 0));//Forces 1 by 1 images
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		homePanel.add(scrollPane, BorderLayout.CENTER);
		
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
		JButton uploadMenuButton = new JButton("Upload");
		uploadMenuButton.setBorder(new EmptyBorder(0, 20, 0, 60));
		uploadMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p2");
			}
		});
		menuBar.add(uploadMenuButton);
		
		/**
		 * Navigates to the Home page.
		 */
		JButton homeMenuButton = new JButton("Home");
		homeMenuButton.setBorder(new EmptyBorder(0, 60, 0, 60));
		homeMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p1");
			}
		});
		menuBar.add(homeMenuButton);
		
		/**
		 * Navigates to the Profile page.
		 */
		JButton profileMenuButton = new JButton("Profile");
		profileMenuButton.setBorder(new EmptyBorder(0, 60, 0, 20));
		profileMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p3");
			}
		});
		menuBar.add(profileMenuButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
}