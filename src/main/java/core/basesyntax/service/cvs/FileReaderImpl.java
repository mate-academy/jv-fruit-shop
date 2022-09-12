package core.basesyntax.service.cvs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read date from file! " + filePath, e);
        }
        return list;
    }
}
