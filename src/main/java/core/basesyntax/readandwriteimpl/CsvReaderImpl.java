package core.basesyntax.readandwriteimpl;

import core.basesyntax.readandwritefile.CsvReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    private static final String csvFile = "filename.csv";

    @Override
    public List<String> readDataFromDataBase() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}
