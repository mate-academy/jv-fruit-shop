package core.basesyntax.service.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    private static final String FILE_FORMAT = "csv";
    private static final int SEPARATOR_INDEX = 1;

    public void write(String fileName, String inputData) {
        checkInputData(fileName, inputData);
        try {
            Files.write(new File(fileName).toPath(), inputData.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + fileName, e);
        }
    }

    private void checkInputData(String fileName, String inputData) {
        if (inputData == null) {
            throw new RuntimeException("Can`t write null to " + fileName);
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("Wrong file name " + fileName);
        }
        if (!fileName.split("\\.")[SEPARATOR_INDEX].equals(FILE_FORMAT)) {
            throw new RuntimeException("Wrong file format. Expected CSV file");
        }
    }
}
