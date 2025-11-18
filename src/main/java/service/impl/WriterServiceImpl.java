package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, String report) {
        if (report == null) {
            throw new NullPointerException("The report is null. Unable to write.");
        }
        if (path == null) {
            throw new NullPointerException("The path is null. Unable to write.");
        }
        if (!report.isEmpty()) {
            try {
                Files.write(Path.of(path), report.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to write to a file at path: " + path, e);
            }
        } else {
            throw new RuntimeException("The report is empty. "
                    + "Unable to write to a file at path: " + path);
        }
    }
}
