package shop.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import validators.ValidatorForFile;
import validators.ValidatorForFileImpl;

public class FileReaderImpl implements shop.service.FileReader {
    public static final String FILE_DIR = "src/main/resources/";
    private ValidatorForFile validator = new ValidatorForFileImpl();

    public String[] read(String filename) {
        String file = FILE_DIR + filename + ".vcs";
        if (validator.test(file)) {
            try {
                return Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)
                        .stream()
                        .toArray(String[]::new);
            } catch (IOException e) {
                throw new RuntimeException("Error!!! File not found.");
            }
        }
        return new String[]{};
    }
}
