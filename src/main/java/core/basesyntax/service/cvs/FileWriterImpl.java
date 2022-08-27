package core.basesyntax.service.cvs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    private CsvReportService csvReportService;

    public FileWriterImpl(CsvReportService csvReportService) {
        this.csvReportService = csvReportService;
    }

    @Override
    public void writeToFile(String toFile) {
        try {
            Files.write(Path.of(toFile), csvReportService.getReport().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file: " + toFile, e);
        }
    }
}
