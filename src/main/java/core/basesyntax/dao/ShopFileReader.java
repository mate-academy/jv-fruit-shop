package core.basesyntax.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ShopFileReader {
    public List<String[]> readFromFile(String filePath) {
        List<String[]> listFruitsFromFile;
        try (FileReader reader = new FileReader(filePath)) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withIgnoreQuotations(true)
                    .build();
            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build()) {
                listFruitsFromFile = csvReader.readAll();
            } catch (IOException | CsvException e) {
                throw new RuntimeException("Error reading file.", e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listFruitsFromFile;
    }
}
