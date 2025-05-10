package core.basesyntax.service.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readFromFile(String filePath) {
        File readFile = new File(filePath);
        List<String> lines;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(readFile))) {
            reader.readLine();

            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file: " + filePath, e);
        }
        return lines;
    }
}
