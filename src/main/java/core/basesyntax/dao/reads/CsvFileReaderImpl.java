package core.basesyntax.dao.reads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String EXCEPTION_TEXT = "Error while reading a file";

    @Override
    public List<String> read(String filePath) {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim().replaceAll("\\s+", "");
                transactions.add(trimmedLine);
            }
        } catch (IOException exception) {
            throw new RuntimeException(EXCEPTION_TEXT, exception);
        }
        return transactions;
    }
}
