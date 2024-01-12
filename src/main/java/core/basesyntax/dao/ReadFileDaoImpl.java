package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFileDaoImpl implements ReadFileDao {
    private static final String PATH = "src/main/resources/file.txt";
    private List<String> data;

    @Override
    public List<String> data() {
        File file = new File(PATH);
        try {
            data = Files.readAllLines(file.toPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found file: " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + file.getName());
        }
        return data;
    }
}

