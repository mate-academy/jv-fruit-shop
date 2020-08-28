package core.basesyntax.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    private String[] header;

    @Override
    public List<List<String>> readFile(String csvFilePath) {
        String[] line;
        List<List<String>> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            header = reader.readNext();
            while ((line = reader.readNext()) != null) {
                data.add(Arrays.stream(line)
                        .collect(Collectors.toList()));
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        if (data.isEmpty()) {
            throw new NoSuchElementException("The file is empty.");
        }
        return data;
    }
}
