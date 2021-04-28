package core.basesyntax.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            List<String> fruitList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                fruitList.add(line);
            }
            return fruitList;
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + filePath, e);
        }
    }
}
