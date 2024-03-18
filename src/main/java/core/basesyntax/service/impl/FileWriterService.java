package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterService implements WriterService {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public void writeData(String filePath, List<String[]> data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] datum : data) {
                String convertedDatum = convertData(datum);
                br.write(convertedDatum);
                br.newLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Can`t write data to the file ", filePath), ex);
        }
    }

    private String convertData(String[] datum) {
        return String.join(COMMA_DELIMITER, datum);
    }
}
