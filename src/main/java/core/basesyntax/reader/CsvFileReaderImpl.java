package core.basesyntax.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readFromCsv(String fileName) {
        List<String> listOfLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file: " + e);
        }
        return listOfLines;
    }
}
