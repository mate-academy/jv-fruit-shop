package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvFileWriteServiceImpl implements CsvFileWriterService {
    @Override
    public void writeReportToFile(String report) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String fileToName = "src/main/resources/report"
                + localDate.format(formatter) + ".csv";
        try {
            Files.write(Path.of(fileToName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileToName, e);
        }
    }
}
