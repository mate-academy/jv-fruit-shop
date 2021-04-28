package core.basesyntax.filework;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.WriteToFileException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class WriteToCSVFileImpl implements WriteToFile {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private static final String COMA = ",";

    @Override
    public void writeToFile(String pathToFile) {
        try (Writer writer = new FileWriter(pathToFile)) {
            writer.append("fruit").append(COMA).append("quantity").append(SEPARATOR);

            for (Map.Entry<String, Integer> entry : FruitStorage.storage.entrySet()) {
                writer.append(entry.getKey())
                        .append(COMA)
                        .append(String.valueOf(entry.getValue()))
                        .append(SEPARATOR);
            }
        } catch (IOException e) {
            throw new WriteToFileException("Can't write to file");
        }
    }
}
