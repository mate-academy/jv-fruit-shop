package core.basesyntax.service;

import com.opencsv.CSVWriter;
import java.util.List;

public interface FileCsvService {

    List<String> readAllLines(String fileName);

    void createReport(String fileName);

    CSVWriter createCsvFile(String fileName);
}
