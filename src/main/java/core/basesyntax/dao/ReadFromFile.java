package core.basesyntax.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public List<String[]> readFromFile(String filePath) {
        FileReader reader;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        List<String[]> listFruitsFromFile;
        try {
            listFruitsFromFile = csvReader.readAll();
            reader.close();
            csvReader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Error reading file.");
        }
        return listFruitsFromFile;
    }
}
