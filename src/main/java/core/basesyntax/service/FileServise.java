package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileServise {

    public File writeReport(String outputPath, String contentToWrite) {
        Path filePath = Paths.get(outputPath);
        File serviceOutput = new File(outputPath);

        try {
            serviceOutput.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }

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
