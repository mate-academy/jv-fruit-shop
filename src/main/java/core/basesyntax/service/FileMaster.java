package core.basesyntax.service;

import core.basesyntax.db.Storage;
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

    public String addFile(String sourceFilePath) {
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
            Files.write(serviceInput.toPath(), Files.readAllLines(Path.of(sourceFilePath)));
            serviceOutput.createNewFile();
            return serviceOutput.toPath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
    }

    public File writeReport(String destinationPath) {
        Path filePath = Paths.get(destinationPath);

        String timeStamp = destinationPath.substring(destinationPath.indexOf('_') + 1,
                destinationPath.indexOf('.'));
        try {
            Files.writeString(filePath,
                    "fruit,quantity\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing header to file for the timestamp " + timeStamp, e);
        }

        Storage.foodStorage.entrySet().stream().forEach(e -> {
            try {
                String entry = e.getKey() + "," + e.getValue() + System.lineSeparator();
                Files.writeString(filePath, entry, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException(
                        "Can't write data to file for the timestamp " + timeStamp, ex);
            }
        });

        return filePath.toFile();
    }
}

