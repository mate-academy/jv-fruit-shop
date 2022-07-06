package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReport;
import core.basesyntax.service.WriterService;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    private String writFromFile = "src"
            + File.separator + "main"
            + File.separator + "resources"
            + File.separator + "inputFile.csv";

    public String getWritFromFile() {
        return writFromFile;
    }

    public void setWritFromFile(String writFromFile) {
        this.writFromFile = writFromFile;
    }

    @Override
    public void writeToFile(CreateReport createReport) {
        try {
            Files.write(Path.of(writFromFile), createReport.create());
        } catch (Exception e) {
            throw new RuntimeException("Can't write file" + e);
        }
    }
}
