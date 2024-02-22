package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    public File writeReportToFile(String outputPath, String contentToWrite) {
        Path filePath = Paths.get(outputPath);
        String timeStamp = outputPath.substring(outputPath.indexOf('_') + 1,
                outputPath.indexOf('.'));
        try {
            Files.writeString(filePath,
                    "fruit,quantity\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing header to file for the timestamp " + timeStamp, e);
        }

        try {
            Files.writeString(filePath, contentToWrite, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing body to file for the timestamp " + timeStamp, e);
        }

        return filePath.toFile();
    }
}
