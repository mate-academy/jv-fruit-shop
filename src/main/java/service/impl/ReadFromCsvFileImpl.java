package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadFromFile;

/*
This class reads all data from the file and returns it in one String value.
- receive String filePath
- return String textBox
 */
public class ReadFromCsvFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromCsvFile(String fromFilePath) {
        /*
        File file = new File(fromFilePath);
        StringBuilder textBox = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFilePath))) {
            if (file.length() == 0) {
                System.out.println("File: " + fromFilePath + "is empty.");
            }
            System.out.println(Files.readAllLines(Path.of(fromFilePath)));
            int symbol = 0;
            while ((symbol = reader.read()) != -1) {
                textBox.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fromFilePath, e);
        }
        return textBox.toString();
    }
         */
        try {
            return Files.readAllLines(Path.of(fromFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from your amazing file "
                    + fromFilePath + " !", e);
        }
    }
}
