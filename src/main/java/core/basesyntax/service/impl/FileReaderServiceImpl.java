package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String[] HEADERS = {"type", "fruit", "quantity", "date"};

    @Override
    public List<List<String>> read(String filePath) {
        List<List<String>> data = new ArrayList<>();
        try {
            Reader reader = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(HEADERS)
                    .withFirstRecordAsHeader()
                    .parse(reader);
            for (CSVRecord record : records) {
                List<String> row = new ArrayList<>();
                row.add(record.get(HEADERS[0]));
                row.add(record.get(HEADERS[1]));
                row.add(record.get(HEADERS[2]));
                row.add(record.get(HEADERS[3]));
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to read file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        return data;
    }
}
