package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.service.CsvWriteService;
import java.util.List;

public class CsvWriteServiceImpl implements CsvWriteService {
    public void writeCsv(CSVWriter writer, List<String[]> listArrays) {
        for (String[] record : listArrays) {
            writer.writeNext(record, false);
        }
    }
}
