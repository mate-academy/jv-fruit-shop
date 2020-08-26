package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public void readFromFile(String filePath) {
        WriteToHashMapStorage writer = new WriteToHashMapStorage();
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                writer.writeToHashMapStorage(myReader.nextLine().toLowerCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
