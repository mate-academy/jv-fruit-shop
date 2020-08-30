package core.basesyntax.parsers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFromFile {

    public List<String[]> parseFromFile(String filePath) {
        List<String[]> dataFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                dataFromFile.add(value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesn't exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return dataFromFile;
    }
}
