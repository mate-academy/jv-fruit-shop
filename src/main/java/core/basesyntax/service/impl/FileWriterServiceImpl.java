package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.storage.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String COMA_SEPARATOR = ",";

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(FIRST_LINE);
            for (Map.Entry<String, Integer> entry : Storage.dataStorage.entrySet()) {
                StringBuilder builder = new StringBuilder();
                builder.append(entry.getKey())
                        .append(COMA_SEPARATOR)
                        .append(entry.getValue())
                        .append(System.lineSeparator());
                bufferedWriter.write(builder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to " + path, e);
        }
    }
}
