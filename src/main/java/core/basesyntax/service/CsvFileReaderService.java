package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService implements ReaderService {
    @Override
    public List<String> readFromFile(final String filePath) {
        File file = new File(filePath);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            List<String> lines = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("File " + e + " not found.");
        }
    }
}
