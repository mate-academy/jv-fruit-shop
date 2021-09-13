package shop.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import validators.ValidatorForFileImpl;

public class FileReaderImpl implements shop.service.FileReader {
    public static final String FILE_DIR = "src/main/resources/";

    public String[] read(String filename) {
        String file = FILE_DIR + filename + ".vcs";
        if (new ValidatorForFileImpl().test(file)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.readLine();
                return reader.lines().toArray(String[]::new);
            } catch (IOException e) {
                throw new RuntimeException("Error!!! File not found.");
            }
        }
        return new String[]{};
    }
}
