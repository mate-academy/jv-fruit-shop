package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FileReaderService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String[] HEADERS = {"type", "fruit", "quantity", "date"};

    @Override
    public List<FruitDto> read(String filePath) {
        List<FruitDto> data = new ArrayList<>();
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(HEADERS)
                    .withFirstRecordAsHeader()
                    .parse(reader);
            for (CSVRecord record : records) {
                String command = record.get(HEADERS[0]);
                String name = record.get(HEADERS[1]);
                int quantity = Integer.parseInt(record.get(HEADERS[2]));
                LocalDate shelfLife = LocalDate.parse(record.get(HEADERS[3]));
                data.add(new FruitDto(command, name, quantity, shelfLife));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to read file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.toString());
        }
        if (data.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        return data;
    }
}
