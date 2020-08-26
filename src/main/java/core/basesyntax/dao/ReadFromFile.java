package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public void readFromFile(String filePath) {
        WriteToListStorage writer = new WriteToListStorage();
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                writer.writeToListStorage(myReader.nextLine().toLowerCase());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
