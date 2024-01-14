package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> readFromFile(String path) {
        List<String> data;
        File file = new File(path);
        try {
            data = Files.readAllLines(file.toPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found file: " + file.getName(), e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + file.getName(), e);
        }
        return data;
    }
}
