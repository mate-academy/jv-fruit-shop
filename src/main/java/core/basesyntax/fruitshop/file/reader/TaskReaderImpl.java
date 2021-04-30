package core.basesyntax.fruitshop.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskReaderImpl implements TaskReader {

    @Override
    public List<String> readFile(String fromFile) {
        List<String> tempStorage = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFile))) {
            reader.readLine();
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
