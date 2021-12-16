import java.io.File;

import javax.swing.JOptionPane;

public class Character {

	String characterName;
	String playerName;

	String characterClass;
	String characterBackground;
	String characterRace;
	String characterAlignment;

	int characterExp;
	int characterLevel;

	int strLvl;
	int dexLvl;
	int conLvl;
	int intLvl;
	int wisLvl;
	int chaLvl;

	//Set up an empty character sheet
	Character() {
		this.characterName = "";
		this.playerName = "";
		this.characterClass = "";
		this.characterBackground = "";
		this.characterRace = "";
		this.characterAlignment = "";
		this.characterExp = 0;
		this.characterLevel = 1;
		this.strLvl = 0;
		this.dexLvl = 0;
		this.conLvl = 0;
		this.intLvl = 0;
		this.wisLvl = 0;
		this.chaLvl = 0;
	}

	//Load an existing character sheet
	Character(String fileName) {
		initCharacter(fileName);
	}
	
	//Accept file input, return string
	Character(File file){
		String fileName = file.getPath();
		String characterName;
		
		//Trimming string for character name: ~/DnDCharacterCreator/./xoxoyomama.character
		characterName = fileName.substring( (fileName.indexOf("./") + 2), fileName.lastIndexOf(".character"));
		initCharacter(characterName);
	}

	private void initCharacter(String fileName) {
		String[] characterInfo = new String[14];
		FileDriver characterFile = new FileDriver();		
		characterInfo = characterFile.readFromFile(fileName);
		
		this.characterName = characterInfo[0];
		this.playerName = characterInfo[1];
		this.characterClass = characterInfo[2];
		this.characterBackground = characterInfo[3];
		this.characterRace = characterInfo[4];
		this.characterAlignment = characterInfo[5];
		
		//Values converted back to int
		this.characterExp = Integer.parseInt(characterInfo[6]);
		this.characterLevel = Integer.parseInt(characterInfo[7]);
		this.strLvl = Integer.parseInt(characterInfo[8]);
		this.dexLvl = Integer.parseInt(characterInfo[9]);
		this.conLvl = Integer.parseInt(characterInfo[10]);
		this.intLvl = Integer.parseInt(characterInfo[11]);
		this.wisLvl = Integer.parseInt(characterInfo[12]);
		this.chaLvl = Integer.parseInt(characterInfo[13]);
	}
	

	public boolean saveCharacter(boolean enableDialog) {
		String[] characterInfo = new String[14];
		
		characterInfo[0] = this.characterName;
		characterInfo[1] = this.playerName;
		characterInfo[2] = this.characterClass;
		characterInfo[3] = this.characterBackground;
		characterInfo[4] = this.characterRace;
		characterInfo[5] = this.characterAlignment;
		characterInfo[6] = this.getCharacterExp();
		characterInfo[7] = this.getCharacterLevel();
		characterInfo[8] = this.getStrLvl();
		characterInfo[9] = this.getDexLvl();
		characterInfo[10] = this.getConLvl();
		characterInfo[11] = this.getIntLvl();
		characterInfo[12] = this.getWisLvl();
		characterInfo[13] = this.getChaLvl();
		
		boolean saveSuccess;
		if (this.characterName.equals("") && enableDialog) {
			JOptionPane.showMessageDialog(null, "A Character Name Must Be Set To Save");
			saveSuccess = false;
		} 
		else {
			FileDriver file = new FileDriver();
			file.writeToFile(this.characterName, characterInfo);
			saveSuccess = true;
		}
		return saveSuccess;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public String getCharacterBackground() {
		return characterBackground;
	}

	public void setCharacterBackground(String characterBackground) {
		this.characterBackground = characterBackground;
	}

	public String getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(String characterRace) {
		this.characterRace = characterRace;
	}

	public String getCharacterAlignment() {
		return characterAlignment;
	}

	public void setCharacterAlignment(String characterAlignment) {
		this.characterAlignment = characterAlignment;
	}

	public String getCharacterExp() {
		return String.valueOf(characterExp);
	}

	public void setCharacterExp(int characterExp) {
		this.characterExp = characterExp;
	}

	public String getCharacterLevel() {
		return String.valueOf(characterLevel);
	}

	public void setCharacterLevel(int characterLevel) {
		this.characterLevel = characterLevel;
	}

	public void setStrLvl(int strLvl) {
		this.strLvl = strLvl;
	}

	public void setDexLvl(int dexLvl) {
		this.dexLvl = dexLvl;
	}

	public void setConLvl(int conLvl) {
		this.conLvl = conLvl;
	}

	public void setIntLvl(int intLvl) {
		this.intLvl = intLvl;
	}

	public void setWisLvl(int wisLvl) {
		this.wisLvl = wisLvl;
	}

	public void setChaLvl(int chaLvl) {
		this.chaLvl = chaLvl;
	}

	public String getStrLvl() {
		return String.valueOf(strLvl);
	}

	public String getDexLvl() {
		return String.valueOf(dexLvl);
	}

	public String getConLvl() {
		return String.valueOf(conLvl);
	}

	public String getIntLvl() {
		return String.valueOf(intLvl);
	}

	public String getWisLvl() {
		return String.valueOf(wisLvl);
	}

	public String getChaLvl() {
		return String.valueOf(chaLvl);
	}

}
