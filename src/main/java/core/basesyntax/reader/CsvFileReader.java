package core.basesyntax.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.exceptions.FileWasNotReadException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    private static final int OFFSET = 1;
    private static final char COMMA = ',';
    private final String filePath;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<List<String>> readTransactions() {
        List<List<String>> rawData = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(COMMA)
                .withIgnoreQuotations(true)
                .build();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withSkipLines(OFFSET)
                .withCSVParser(csvParser)
                .build()) {

            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                rawData.add(new ArrayList<>(List.of(nextLine)));
            }
        } catch (IOException | CsvValidationException e) {
            throw new FileWasNotReadException(e.getMessage());
        }

        return rawData;
    }
}
