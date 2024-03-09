package core.basesyntax.service;

import com.opencsv.CSVWriter;
import java.util.List;

public interface CsvWriteService {
    void writeCsv(CSVWriter writer, List<String[]> listArrays);
}
