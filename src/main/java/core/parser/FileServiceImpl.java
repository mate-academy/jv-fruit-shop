package core.parser;

import core.exceptions.FileEmptyException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    public List<String> readFile(String fullPath) {
        List<String> lines = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            while ((line = br.readLine()) != null) {
                lines.add(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines.isEmpty()) {
            throw new FileEmptyException("File is empty", new RuntimeException());
        }
        lines.remove(0);
        return lines;
    }

    @Override
    public boolean writeFile(List<String> text, String fullPath) {
        Path path = Paths.get(fullPath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(fullPath)) {
             for (String line : text) {
                if (!line.isEmpty()) {
                    fw.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
