package core.basesyntax.service.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceICsvImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String inputFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String value = reader.readLine();
            while (value != null) {
                lines.add(value);
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file: " + inputFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + inputFile, e);
        }
        return lines;
    }
}
