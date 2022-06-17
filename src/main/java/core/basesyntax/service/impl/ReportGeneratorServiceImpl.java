package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String REPORT_STRINGS = "fruits,quantity";

    @Override
    public boolean generate(String pathname) {
        Path pathToFile = Path.of(pathname);
        try {
            Files.write(pathToFile,
                    (REPORT_STRINGS + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't generate report");
        }
        return true;
    }
}
