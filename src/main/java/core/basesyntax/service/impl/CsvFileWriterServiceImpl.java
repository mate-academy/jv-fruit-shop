package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMA_SEPARATOR = ",";
    private StringBuilder stringBuilder;

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            writeFirstLine(bufferedWriter);
            for (int i = 0; i < Storage.dataStorage.size(); i += 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Storage.dataStorage.get(i))
                             .append(COMA_SEPARATOR)
                             .append(Storage.dataStorage.get(i + 1))
                             .append(System.lineSeparator());
                bufferedWriter.write(stringBuilder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant find file on path: " + path, e);
        }
    }

    private void writeFirstLine(BufferedWriter bufferedWriter) throws IOException {
        stringBuilder = new StringBuilder();
        stringBuilder.append(FRUIT)
                     .append(COMA_SEPARATOR)
                     .append(QUANTITY)
                     .append(System.lineSeparator());
        bufferedWriter.write(stringBuilder.toString());
    }
}
