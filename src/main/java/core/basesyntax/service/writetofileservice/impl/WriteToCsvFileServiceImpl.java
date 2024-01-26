package core.basesyntax.service.writetofileservice.impl;

import core.basesyntax.service.writetofileservice.WriteToFileService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class WriteToCsvFileServiceImpl implements WriteToFileService {
    @Override
    public void writeDataToFile(String report) {
        String filePath = "src/main/resources/report_file.csv";
        File reportFile = new File(filePath);
        try {
            reportFile.createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException("Can't create file", exception);
        }
        try {
            Files.write(reportFile.toPath(), report.getBytes(StandardCharsets.UTF_8));

        } catch (IOException exception) {
            throw new RuntimeException("Cant write data to file", exception);
        }
    }
}
