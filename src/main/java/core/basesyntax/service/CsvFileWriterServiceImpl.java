package core.basesyntax.service;

import core.basesyntax.dp.Report;
import core.basesyntax.service.impl.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterServiceImpl implements FileWriterService {
    private static final String HEADERS = "fruit,quantity";

    @Override
    public void write(String fileName, Map<String, Integer> fruitsQuantity) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            writeHeaders(bufferedWriter);
            bufferedWriter.write(Report.getReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + fileName, e);
        }
    }

    private void writeHeaders(BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(HEADERS + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't write headers to file", e);
        }
    }
}
