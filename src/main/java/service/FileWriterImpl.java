package service;

import db.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String fileName) {
        try {
            Files.write(Path.of(fileName), report().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }

    private String report() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (var value : Storage.storage.entrySet()) {
            report.append("\n")
                    .append(value.getKey().getName())
                    .append(",")
                    .append(value.getValue());
        }
        return report.toString();
    }
}
