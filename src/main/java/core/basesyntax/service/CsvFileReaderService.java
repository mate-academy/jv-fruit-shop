package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements FileReaderService {

    @Override
    public List<String[]> getTransactions(String filePath) {
        List<String[]> lines = new ArrayList<>();
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] fruitTransaction = line.split(",");
                lines.add(fruitTransaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file cannot be found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file.", e);
        }
        return lines;
    }
}
