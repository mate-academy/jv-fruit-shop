package core.basesyntax.service.readandwrite;

import core.basesyntax.service.parser.ReportServiceImpl;
import core.basesyntax.service.parser.ReportService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportWriterImpl implements ReportWriter {
    private static final String EXCEPTION_MESSAGE = "Can't write report in file ";
    private ReportService reportService = new ReportServiceImpl();

    @Override
    public boolean writeReport(String pathToFile, String content) {
        try {
            Files.writeString(Path.of(pathToFile), reportService.generateReport());
            return true;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + e);
        }
    }
}
