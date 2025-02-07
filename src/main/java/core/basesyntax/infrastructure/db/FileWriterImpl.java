package core.basesyntax.infrastructure.db;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private static final String FILE_NAME = "src/main/java/database.csv";

    @Override
    public void write(List<String> resultingReport) throws IOException {
        BufferedWriter br = new BufferedWriter(new java.io.FileWriter(FILE_NAME));
        resultingReport.stream()
                .forEach(str -> {
                    try {
                        br.write(str + System.lineSeparator());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        br.close();
    }
}
