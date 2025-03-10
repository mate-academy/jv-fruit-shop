package core.basesyntax.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        Path reportFile = Paths.get(fileName);
        try {
            if (fileName.isEmpty()) {
                throw new FileNotFoundException("The file path is empty,"
                        + " please provide a file name");
            }
            if (!reportFile.getParent().toFile().exists()) {
                throw new FileNotFoundException("The directory of input file not found: "
                        + fileName);
            }
            if (Files.exists(reportFile)) {
                throw new FileNotFoundException("The report file already exists: " + fileName
                + " please move the file to another location to save data or"
                        + "provide a different file name.");
            }
            Files.write(reportFile, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Something is wrong with writing report file, "
                    + "see description below.",e);
        }
    }
}
