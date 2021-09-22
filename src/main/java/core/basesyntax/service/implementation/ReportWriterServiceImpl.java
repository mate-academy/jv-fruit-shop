package core.basesyntax.service.implementation;

import core.basesyntax.service.ReportWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String TABLE_HEADING = "fruit,quantity";

    public void write(List<String> report, String toFileName) {
        String heading = TABLE_HEADING + System.lineSeparator();
        try {
            Files.write(Path.of(toFileName), heading.getBytes());
            for (String string : report) {
                Files.write(Path.of(toFileName), string.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
