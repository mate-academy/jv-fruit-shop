package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReportWriterServiceFile implements ReportWriterService {
    private static final String CAN_T_WRITE_TO_FILE = "Can't write to file ";
    private String fileName;

    public ReportWriterServiceFile() {
    }

    @Override
    public void writeReport(final List<String> report) {
        Path filePath = Paths.get(fileName);
        try {
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
            StringBuilder stringBuilder = new StringBuilder();
            for (String line : report) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
            Files.writeString(filePath, stringBuilder.toString(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(CAN_T_WRITE_TO_FILE + fileName, e);
        }
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
}
