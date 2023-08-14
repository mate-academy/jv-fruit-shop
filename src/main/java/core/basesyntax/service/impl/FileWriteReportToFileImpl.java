package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteReportToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteReportToFileImpl implements FileWriteReportToFile {
    @Override
    public void writeReportToFile(String inputData, String filePath) {
        try {
            byte[] dataBytes = inputData.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, dataBytes);
        } catch (IOException e) {
            System.out.println("Error write to file" + e);
        }

    }
}
