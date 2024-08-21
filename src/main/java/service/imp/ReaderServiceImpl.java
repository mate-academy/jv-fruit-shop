package service.imp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private List<String> dataFromFile = new ArrayList<>();

    @Override
    public List<String> read(String fileName) {
        try {
            dataFromFile = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find data with this path:  " + fileName);
        }
        return dataFromFile;
    }
}
