package core.basesyntax.filework;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.WriteToFileException;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class CsvFileWriterImpl implements FileWriter {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private static final String COMA = ",";

    @Override
    public void write(String path) {
        try (Writer writer = new java.io.FileWriter(path)) {
            writer.append(makeContent(FruitStorage.storage));
        } catch (IOException e) {
            throw new WriteToFileException("Can't write to file");
        }
    }

    public String makeContent(Map<String, Integer> storage) {
        StringBuilder content = new StringBuilder();
        content.append("fruit").append(COMA).append("quantity").append(SEPARATOR);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            content.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(SEPARATOR);
        }
        return content.toString();
    }
}
