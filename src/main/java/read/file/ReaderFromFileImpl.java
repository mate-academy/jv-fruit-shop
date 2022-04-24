package read.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFileImpl implements ReaderFromFile {
    @Override
    public List<String[]> readFromFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(",");
                data.add(keyValuePair);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + filePath);
        }
        return data;
    }
}
