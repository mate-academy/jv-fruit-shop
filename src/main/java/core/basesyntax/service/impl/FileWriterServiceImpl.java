package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class FileWriterServiceImpl implements WriterService {
    private static final String CANT_WRITE = "Can't write to file. ";
    private static final String COMMA = ",";
    private static final String PREDEFINED_LINE = "fruit,quantity";
    private final BufferedWriter bufferedWriter;

    public FileWriterServiceImpl(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(Map<String, Integer> fruitStorageMap) {
        Set<Map.Entry<String, Integer>> entries = fruitStorageMap.entrySet();
        try (bufferedWriter) {
            bufferedWriter.write(PREDEFINED_LINE);
            for (Map.Entry<String, Integer> entry : entries) {
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(entry.getKey() + COMMA + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_WRITE + e);
        }
    }
}
