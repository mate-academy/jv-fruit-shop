package core.basesyntax.service.readandwrite;

import core.basesyntax.service.parser.CreateReport;
import core.basesyntax.service.parser.Report;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportWriterImpl implements ReportWriter {
    private static final String EXCEPTION_MESSAGE = "Can't write report in file ";
    private Report report = new CreateReport();

    @Override
    public boolean writeReport(String pathToFile) {
        try {
            Files.writeString(Path.of(pathToFile), report.report());
            return true;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + e);
        }
    }
}
