package records.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordsFileReader implements RecordsReader {
    @Override
    public List<String> getRecords(String fileName) {
        List<String> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong! Data wasn't read."
                    + System.lineSeparator() + e);
        }
        return records;
    }
}
