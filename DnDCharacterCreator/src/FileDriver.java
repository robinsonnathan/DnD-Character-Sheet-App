import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDriver {


	public void writeToFile(String fileName, String[] characterData) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".character"));

			String output = "";
			for (int i = 0; i < characterData.length; i++) {
				output += characterData[i] + ",";
			}
			// Trim extra "," at the end
			output = output.substring(0, (output.length() - 1));
			writer.write(output);
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public String[] readFromFile(String fileName) {
		String [] characterData = null;

		try {
			String readerResult;
			BufferedReader reader = new BufferedReader(new FileReader(fileName + ".character"));
			readerResult = reader.readLine();
			characterData = readerResult.split(",");

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return characterData;
	}

}
