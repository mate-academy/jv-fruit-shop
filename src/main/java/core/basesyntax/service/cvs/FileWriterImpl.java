package core.basesyntax.service.cvs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    private CsvReportService csvReportService;

    public FileWriterImpl(CsvReportService csvReportService) {
        this.csvReportService = csvReportService;
    }

    @Override
    public void writeToFile(String toFile) {
        File file = new File(toFile);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file: " + toFile, e);
        }
        try {
            Files.write(file.toPath(), csvReportService.getReport().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file: " + toFile, e);
        }
    }
}
