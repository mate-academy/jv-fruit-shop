package core.basesyntax.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public List<List<String>> read(String filePath) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(List.of(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
