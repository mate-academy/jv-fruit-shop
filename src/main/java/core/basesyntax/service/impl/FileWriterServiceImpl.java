package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterServiceImpl implements DataWriterService {
    private String fileName;

    public FileWriterServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(List<String> dataList) {
        try {
            Files.write(Path.of(fileName), dataList, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
