package core.basesyntax.service.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("your read path is not correct..."
                    + "please check again..." + e);
        }
    }

    @Override
    public void write(String path, String report) {
        try {
            Files.write(Path.of(path), String.valueOf(report).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("your writing path is not correct ... "
                    + "please check again ..." + e);
        }

    }

}
