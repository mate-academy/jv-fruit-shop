package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.service.CsvWriterService;
import java.io.FileWriter;
import java.io.IOException;

public class CsvRriterServiceImpl implements CsvWriterService {
    private ProcessWriteDataServiceImpl listToWrite = new ProcessWriteDataServiceImpl();

    @Override
    public void writeCsv(String pathFile) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(pathFile))) {
            for (String[] record : listToWrite.prepareDataToWrite()) {
                writer.writeNext(record, false);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file by this " + pathFile + " " + e);
        }
    }
}
