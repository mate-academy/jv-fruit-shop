package core.basesyntax.service.writetofileservice.impl;

import core.basesyntax.service.writetofileservice.WriteToFileService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriteToCsvFileServiceImpl implements WriteToFileService {
    @Override
    public void writeDataToFile(Map<String, Integer> map) {
        String filePath = "src/main/resources/report_file.csv";
        String title = "fruit,quantity" + System.lineSeparator();
        File reportFile = new File(filePath);
        try {
            reportFile.createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException("Can't create file", exception);
        }
        try {
            Files.write(reportFile.toPath(), title.getBytes(StandardCharsets.UTF_8));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String lineToWrite = entry.getKey() + "," + String.valueOf(entry.getValue())
                        + System.lineSeparator();
                Files.write(reportFile.toPath(), lineToWrite.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException exception) {
            throw new RuntimeException("Cant write data to file", exception);
        }
    }
}
