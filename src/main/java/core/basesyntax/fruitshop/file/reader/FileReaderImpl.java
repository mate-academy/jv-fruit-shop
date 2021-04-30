package core.basesyntax.fruitshop.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fromFile) {
        List<String> tempStorage = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFile))) {
            String line = reader.readLine();
            while (line != null) {
                tempStorage.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
        return tempStorage;
    }
}
