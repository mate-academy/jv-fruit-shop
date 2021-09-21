package core.basesyntax.fileservice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static final int LINE_WITH_TITLES = 1;

    @Override
    public List<String> readFromFile(Path fileFrom) {
        try {
            return Files.lines(fileFrom)
                    .skip(LINE_WITH_TITLES)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file: " + fileFrom.getFileName(), e);
        }
    }

    @Override
    public boolean writeToFile(List<String> dataList, Path fileTo) {
        try {
            Files.write(fileTo, dataList, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to the file: " + fileTo.getFileName(), e);
        }
    }
}
