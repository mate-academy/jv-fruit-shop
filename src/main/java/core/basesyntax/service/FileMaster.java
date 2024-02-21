package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileMaster {
    private static final DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd_HH-mm-ss");

    public File addFile(File fromFile) {
        File reportFolder = new File("src" + File.separator
                + "main" + File.separator
                + "resources" + File.separator
                + "report_" + LocalDateTime.now().format(FORMATTED));

        File serviceInput = new File(reportFolder.toPath()
                + File.separator
                + "input_" + LocalDateTime.now().format(FORMATTED) + ".csv");

        File serviceOutput = new File(serviceInput.toPath().toString().replace("input", "output"));
        try {
            reportFolder.mkdir();
            serviceInput.createNewFile();
            Files.write(serviceInput.toPath(), Files.readAllLines(fromFile.toPath()));
            serviceOutput.createNewFile();
            return serviceOutput;
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
    }

    public File writeReport(String outputPath, String contentToWrite) {
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
