package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeAll(Path pathToFile) {
        String report = createReport();
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File(pathToFile.toUri())))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while writing to file" + pathToFile, e);
        }
    }

    private String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
