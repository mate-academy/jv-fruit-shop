package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.service.CsvWriteService;
import core.basesyntax.service.CsvWriterCreateService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterCreateServiceImpl implements CsvWriterCreateService {
    private CsvWriteService csvWriteService;

    public CsvWriterCreateServiceImpl(CsvWriteService csvWriteService) {
        this.csvWriteService = csvWriteService;
    }

    @Override
    public void createWriteCsv(String pathFile, List<String[]> listArrays) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(pathFile))) {
            csvWriteService.writeCsv(writer, listArrays);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file by this " + pathFile + " " + e);
        }
    }
}
