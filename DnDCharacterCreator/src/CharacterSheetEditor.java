import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CharacterSheetEditor extends JFrame implements ActionListener {

	private JTextField txtCharacterName;
	private JTextField txtClass;
	private JTextField txtPlayerName;
	private JTextField txtRace;
	private JTextField txtAlignment;
	private JTextField txtExp;
	private JTextField txtLevel;
	private JTextField txtBackground;
	private JTextField txtNextLevel;
	private JTextField txtStr;
	private JTextField txtDex;
	private JTextField txtCon;
	private JTextField txtInt;
	private JTextField txtWis;
	private JTextField txtCha;

	private JButton saveButton;
	private JButton loadButton;
	private JButton rollStatsButton;
	private JButton fullEditButton;

	public int nextExpLevel;
	public Character myCharacter = null;

	/**
	 * Create the frame CharacterSheetEditor takes a boolean to determine if we
	 * should load a file chooser
	 */

	public CharacterSheetEditor(boolean createNewCharacter) {

		if (createNewCharacter) {
			this.myCharacter = new Character();
		} else {
			fileBrowser();
		}

		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1200, 800);
		getContentPane().setLayout(new BorderLayout(10, 10));
		setVisible(true);
		/*
		 * Controls the header of the editor
		 */

		JPanel header = new JPanel();
		getContentPane().add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		JPanel characterInfo = new JPanel();
		characterInfo.setBackground(Color.LIGHT_GRAY);
		header.add(characterInfo, BorderLayout.CENTER);
		characterInfo.setLayout(new GridLayout(4, 4, 10, 10));

		JLabel lblClass = new JLabel("Class:");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblClass);

		txtClass = new JTextField();
		txtClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setLabelFor(txtClass);
		characterInfo.add(txtClass);
		txtClass.setColumns(10);

		JLabel lblBackground = new JLabel("Background:");
		lblBackground.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblBackground);

		txtBackground = new JTextField();
		txtBackground.setHorizontalAlignment(SwingConstants.CENTER);
		characterInfo.add(txtBackground);
		txtBackground.setColumns(10);

		JLabel lblRace = new JLabel("Race:");
		lblRace.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblRace);

		txtRace = new JTextField();
		txtRace.setHorizontalAlignment(SwingConstants.CENTER);
		txtRace.setColumns(10);
		characterInfo.add(txtRace);

		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblPlayerName);

		txtPlayerName = new JTextField();
		txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName.setColumns(10);
		characterInfo.add(txtPlayerName);

		JLabel lblAlignment = new JLabel("Alignment:");
		lblAlignment.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblAlignment);

		txtAlignment = new JTextField();
		txtAlignment.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlignment.setColumns(10);
		characterInfo.add(txtAlignment);

		JLabel lblExp = new JLabel("Experience:");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblExp);

		txtExp = new JTextField();
		txtExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblExp.setLabelFor(txtExp);
		txtExp.setColumns(10);
		characterInfo.add(txtExp);

		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblLevel);

		txtLevel = new JTextField();
		txtLevel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLevel.setColumns(10);
		txtLevel.setEditable(false);
		characterInfo.add(txtLevel);

		JLabel lblNextLevel = new JLabel("Next Level:");
		lblNextLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		characterInfo.add(lblNextLevel);

		txtNextLevel = new JTextField();
		txtNextLevel.setHorizontalAlignment(SwingConstants.CENTER);
		txtNextLevel.setColumns(10);
		characterInfo.add(txtNextLevel);
		txtNextLevel.setEditable(false);

		JPanel logoAndCharacterName = new JPanel();
		logoAndCharacterName.setPreferredSize(new Dimension(400, 200));
		header.add(logoAndCharacterName, BorderLayout.WEST);
		logoAndCharacterName.setLayout(new BorderLayout(0, 0));

		JLabel lblCharacterName = new JLabel("Character Name:");
		lblCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		logoAndCharacterName.add(lblCharacterName, BorderLayout.CENTER);

		JLabel lblLogoImg = new JLabel("");
		logoAndCharacterName.add(lblLogoImg, BorderLayout.NORTH);

		// Rescaled & Resize the image
		BufferedImage img = null;
		try {
			img = ImageIO.read(CharacterSheetEditor.class.getResource("/resources/dndLogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image resizedImg = img.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
		lblLogoImg.setIcon(new ImageIcon(resizedImg));

		txtCharacterName = new JTextField();
		txtCharacterName.setHorizontalAlignment(SwingConstants.CENTER);
		logoAndCharacterName.add(txtCharacterName, BorderLayout.SOUTH);
		txtCharacterName.setColumns(10);

		/*
		 * Stats
		 */
		JPanel stats = new JPanel();
		stats.setForeground(Color.WHITE);
		stats.setBackground(Color.DARK_GRAY);
		stats.setPreferredSize(new Dimension(150, 0));
		getContentPane().add(stats, BorderLayout.WEST);
		stats.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblStr = new JLabel("Strength:");
		lblStr.setForeground(Color.WHITE);
		lblStr.setPreferredSize(new Dimension(10, 10));
		lblStr.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblStr);

		txtStr = new JTextField();
		txtStr.setHorizontalAlignment(SwingConstants.CENTER);
		txtStr.setForeground(Color.BLACK);
		txtStr.setBackground(Color.WHITE);
		lblStr.setLabelFor(txtStr);
		stats.add(txtStr);
		txtStr.setColumns(10);

		JLabel lblDex = new JLabel("Dexterity:");
		lblDex.setForeground(Color.WHITE);
		lblDex.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblDex);

		txtDex = new JTextField();
		txtDex.setHorizontalAlignment(SwingConstants.CENTER);
		txtDex.setForeground(Color.BLACK);
		txtDex.setBackground(Color.WHITE);
		txtDex.setColumns(10);
		stats.add(txtDex);

		JLabel lblCon = new JLabel("Constitution:");
		lblCon.setForeground(Color.WHITE);
		lblCon.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblCon);

		txtCon = new JTextField();
		txtCon.setHorizontalAlignment(SwingConstants.CENTER);
		txtCon.setForeground(Color.BLACK);
		txtCon.setBackground(Color.WHITE);
		txtCon.setColumns(10);
		stats.add(txtCon);

		JLabel lblInt = new JLabel("Intelligence:");
		lblInt.setForeground(Color.WHITE);
		lblInt.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblInt);

		txtInt = new JTextField();
		txtInt.setHorizontalAlignment(SwingConstants.CENTER);
		txtInt.setForeground(Color.BLACK);
		txtInt.setBackground(Color.WHITE);
		txtInt.setColumns(10);
		stats.add(txtInt);

		JLabel lblWis = new JLabel("Wisdom:");
		lblWis.setForeground(Color.WHITE);
		lblWis.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblWis);

		txtWis = new JTextField();
		txtWis.setHorizontalAlignment(SwingConstants.CENTER);
		txtWis.setForeground(Color.BLACK);
		txtWis.setBackground(Color.WHITE);
		txtWis.setColumns(10);
		stats.add(txtWis);

		JLabel lblCha = new JLabel("Charisma:");
		lblCha.setForeground(Color.WHITE);
		lblCha.setHorizontalAlignment(SwingConstants.RIGHT);
		stats.add(lblCha);

		txtCha = new JTextField();
		txtCha.setHorizontalAlignment(SwingConstants.CENTER);
		txtCha.setForeground(Color.BLACK);
		txtCha.setBackground(Color.WHITE);
		txtCha.setColumns(10);
		stats.add(txtCha);

		JPanel mainPanelEast = new JPanel();
		mainPanelEast.setBackground(Color.DARK_GRAY);
		getContentPane().add(mainPanelEast, BorderLayout.EAST);

		JPanel mainPanelSouth = new JPanel();
		getContentPane().add(mainPanelSouth, BorderLayout.SOUTH);

		saveButton = new JButton("Save Character");
		mainPanelSouth.add(saveButton);

		loadButton = new JButton("Load Character");
		mainPanelSouth.add(loadButton);

		rollStatsButton = new JButton("Roll For Stats");
		mainPanelSouth.add(rollStatsButton);

		fullEditButton = new JButton("Unlock All Fields");
		mainPanelSouth.add(fullEditButton);

		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		rollStatsButton.addActionListener(this);
		fullEditButton.addActionListener(this);

		// Setup
		checkLevel();
		updateFields();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) {
			save(true);
			updateFields();
		}

		if (e.getSource() == loadButton) {
			fileBrowser();
			updateFields();
		}

		if (e.getSource() == rollStatsButton) {
			rollStats();
			updateFields();
		}

		if (e.getSource() == fullEditButton) {
			JOptionPane.showMessageDialog(null, "All Fields Now Editable");
			txtLevel.setEditable(true);
			txtNextLevel.setEditable(true);
		}
	}

	/*
	 * save() attempts to save editor fields to Character() class
	 * It will also try to save to a [characterName].character file
	 */
	public void save(boolean enableSavedDialog) {
		Character c = myCharacter;

		// Grab text from editor fields and save them to Character() fields
		c.setCharacterName(txtCharacterName.getText());
		c.setCharacterClass(txtClass.getText());
		c.setPlayerName(txtPlayerName.getText());
		c.setCharacterRace(txtRace.getText());
		c.setCharacterAlignment(txtAlignment.getText());
		c.setCharacterBackground(txtBackground.getText());

		try {
			c.setStrLvl(Integer.valueOf(txtStr.getText()));
			c.setDexLvl(Integer.valueOf(txtDex.getText()));
			c.setConLvl(Integer.valueOf(txtCon.getText()));
			c.setIntLvl(Integer.valueOf(txtInt.getText()));
			c.setWisLvl(Integer.valueOf(txtWis.getText()));
			c.setChaLvl(Integer.valueOf(txtCha.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Stats can only be numbers");
			updateFields();
			throw e;
		}
		/*
		 * Automated Leveling System
		 */
		try {
			/*
			 * Accept 3 cases for exp text field: 
			 * 1: Exp entered as an int 
			 * 2: Exp formatted as "000 / 000"
			 * 3: Exp formatted as "000/000" check
			 *
			 */
			String characterExpString = txtExp.getText();
			int endIndex = -1;
			int characterExp;

			try {
				characterExp = Integer.parseInt(characterExpString);
			}
			
			//If exp doesnt parse, try string parse
			catch (NumberFormatException e) {
				//Case 2:
				endIndex = characterExpString.indexOf(" /");
				
				//Case 3:
				if (endIndex == -1) {
					endIndex = characterExpString.indexOf("/");
				}
				
				characterExpString = characterExpString.substring(0, endIndex);
				characterExp = Integer.valueOf(characterExpString);
			}

			// Character exp must be between [0-355000] to save
			if (characterExp >= 0 && characterExp < 355000) {
				c.setCharacterExp(characterExp);
			} else {
				JOptionPane.showMessageDialog(null, "Exp is outside allowed range");
				return;
			}
		}
		
		//Exp couldn't be parsed from text field
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exp is invalid");
			throw e;
		}

		finally {
			updateFields();
		}

		checkLevel();
		boolean saved = myCharacter.saveCharacter(enableSavedDialog);
		if (enableSavedDialog && saved) {
			JOptionPane.showMessageDialog(null, "Character Saved as: " + c.getCharacterName() + ".character");
		}

	}

	public void checkLevel() {
		int[] levelTable = {
				// Up to lvl 20
				0, 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000, 140000, 165000,
				195000, 225000, 265000, 305000, 355000 };

		int currentExp = myCharacter.characterExp;
		int levelByExp = -1;
		int currentLevel = myCharacter.characterLevel;

		for (int i = 0; i < levelTable.length; i++) {
			if (currentExp >= levelTable[i] && currentExp < levelTable[i + 1]) {
				levelByExp = i + 1;
				break;
			}
		}

		this.nextExpLevel = levelTable[levelByExp];
		myCharacter.setCharacterLevel(levelByExp);
		updateFields();

		// Level Up Alert
		if (currentLevel < levelByExp && levelByExp != -1) {
			JOptionPane.showMessageDialog(null, "You Leveled Up!");
		}

	}

	public void rollStats() {
		Random rand = new Random();
		/*
		 * dice sets the upper limit of rand. Since this value is exclusive but also
		 * returns 0 we will add +1 to our rolls to exclude 0s but get 6s
		 */
		int dice = 6;
		int[] stats = new int[6];

		// Roll D6 x 4 times. Discard lowest value. Return the sum of 3 highest values.
		for (int i = 0; i < 6; i++) {
			int diceTotal = 0;
			int min = 6;

			for (int j = 0; j < 4; j++) {
				int roll = rand.nextInt(dice) + 1;
				// Check if lowest roll
				if (roll <= min) {
					min = roll;
				}
				diceTotal += roll;
			}
			// Drop lowest roll
			diceTotal = diceTotal - min;
			stats[i] = diceTotal;
		}

		// Save text fields before setting up Character c
		// and suppress saved dialog
		save(false);

		Character c = myCharacter;

		c.setStrLvl(stats[0]);
		c.setDexLvl(stats[1]);
		c.setConLvl(stats[2]);
		c.setIntLvl(stats[3]);
		c.setWisLvl(stats[4]);
		c.setChaLvl(stats[5]);

		updateFields();
	}

	private void fileBrowser() {
		JFileChooser filePicker = new JFileChooser();
		filePicker.setCurrentDirectory(new File("."));

		int response = filePicker.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			File characterFile = new File(filePicker.getSelectedFile(), "");
			this.myCharacter = new Character(characterFile);
		}
		// If a character is loaded and file picker is canceled, do nothing
		else {
			if (this.myCharacter == null) {
				this.dispose();
				JOptionPane.showMessageDialog(null, "Please select a character file to continue");
				System.exit(1);
			}
		}
	}

	/*
	 * updateFields populates the editor with data from Character() class 
	 * 
	 */
	public void updateFields() {
		Character c = myCharacter;
		int nextLevel = (c.characterLevel + 1);

		txtCharacterName.setText(c.getCharacterName());
		txtClass.setText(c.getCharacterClass());
		txtPlayerName.setText(c.getPlayerName());
		txtRace.setText(c.getCharacterRace());
		txtAlignment.setText(c.getCharacterAlignment());
		txtExp.setText(c.getCharacterExp() + " / " + String.valueOf(this.nextExpLevel));
		txtLevel.setText(c.getCharacterLevel());
		txtBackground.setText(c.getCharacterBackground());
		txtNextLevel.setText(String.valueOf(nextLevel));
		txtStr.setText(c.getStrLvl());
		txtDex.setText(c.getDexLvl());
		txtCon.setText(c.getConLvl());
		txtInt.setText(c.getIntLvl());
		txtWis.setText(c.getWisLvl());
		txtCha.setText(c.getChaLvl());

	}

}
