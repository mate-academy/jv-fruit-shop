package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class WriterServiceImpl implements WriterService {
    @Override
    public File writeReport(String data) {
        String nameFile = "Report " + LocalDate.now();
        File reportFile = new File(nameFile);
        try {
            reportFile.createNewFile();
            Files.write(reportFile.toPath(), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reportFile;
    }
}
