package service.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/output.csv";

    @Override
    public File writeToFile(List<String> fruitDataToWrite) {
        File output = new File(PATH_TO_OUTPUT_FILE);
        try {
            Files.write(output.toPath(), fruitDataToWrite);
        } catch (Exception ex) {
            throw new RuntimeException(
                    String.format("Can't write to file %s", fruitDataToWrite), ex);
        }
        return output;
    }
}
