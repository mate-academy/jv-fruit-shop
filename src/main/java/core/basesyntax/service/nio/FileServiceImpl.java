package core.basesyntax.service.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> read(String pathFromRepository) {
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(pathFromRepository)));
        } catch (IOException e) {
            throw new RuntimeException("is not correct file " + e);
        }
    }

    @Override
    public void write(String path, Map<String, Integer> map) {
        StringBuilder stringBuilder;
        for (Map.Entry<String, Integer> writeResult : map.entrySet()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(writeResult.getKey()).append(",")
                    .append(writeResult.getValue()).append("\n");
            try {
                Files.write(Path.of(path), String.valueOf(stringBuilder).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("is not correct url... " + e);
            }

        }
    }
}
