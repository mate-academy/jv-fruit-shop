package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitFileReader {

    public List<String> readFruitFile(String filename) {
        List<String> fileContent = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File was not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return fileContent;
    }
}
