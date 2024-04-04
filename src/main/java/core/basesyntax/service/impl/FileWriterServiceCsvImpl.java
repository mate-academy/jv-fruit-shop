package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class FileWriterServiceCsvImpl implements FileWriterService {
    @Override
    public void write(String filePath) {
        String eol = System.lineSeparator();

        try (Writer writer = new FileWriter(filePath)) {
            writer.append("fruit,quantity" + eol);
            for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(Integer.toString(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
