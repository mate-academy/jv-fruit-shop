package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMA_SEPARATOR = ",";

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            writeFirstLine(bufferedWriter);
            for (Map.Entry<String, Integer> data : Storage.storage.entrySet()) {
                String stringBuilder = data.getKey() +
                        COMA_SEPARATOR +
                        data.getValue() +
                        System.lineSeparator();
                bufferedWriter.write(stringBuilder);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant find file on path: " + path, e);
        }
    }

    private void writeFirstLine(BufferedWriter bufferedWriter) throws IOException {
        String stringBuilder = FRUIT +
                COMA_SEPARATOR +
                QUANTITY +
                System.lineSeparator();
        bufferedWriter.write(stringBuilder);
    }
}
