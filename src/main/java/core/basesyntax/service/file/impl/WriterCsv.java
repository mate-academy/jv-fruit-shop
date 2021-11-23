package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterCsv implements WriterService {
    private static final String DIRECTORY_NAME_FOR_REPORTS = "reports";
    private static final String FILE_NAME_FOR_REPORTS = "report.csv";

    @Override
    public void writeResultInFile(String filePath, String resultData) {
        String spr = File.separator;
        String pathToResources = filePath.substring(0, filePath.lastIndexOf(spr) + 1);
        String pathToReportDir = pathToResources + DIRECTORY_NAME_FOR_REPORTS;
        String pathToReportFile = pathToReportDir + spr + FILE_NAME_FOR_REPORTS;

        try {
            Files.createDirectories(Path.of(pathToReportDir));
            Files.write(Path.of(pathToReportFile),
                    resultData.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
