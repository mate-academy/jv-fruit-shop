package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.service.CsvReadParseService;
import core.basesyntax.service.CsvReaderService;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderServiceImpl implements CsvReaderService {
    private CsvReadParseService parseService = new CsvReadParseServiceImpl();

    @Override
    public String readCsv(String pathFile) {
        try (CSVReader reader =
                     new CSVReaderBuilder(new FileReader(pathFile)).withSkipLines(1).build()) {
            StringBuilder builder = new StringBuilder();
            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length != 3) {
                    throw new RuntimeException("Incorrect data!");
                }
                builder.append(parseService.parseCsv(record))
                        .append(System.lineSeparator());
            }
            return builder.toString().strip();
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file by this " + pathFile + " " + e);
        }
    }
}
