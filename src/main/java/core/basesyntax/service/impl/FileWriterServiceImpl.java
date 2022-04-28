package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(Path path, List<String> report) {
        try {
            for (String line : report) {
                Files.writeString(path, convertListToString(report));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file");
        }

    }

    String convertListToString(List<String> inputList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : inputList) {
            stringBuilder.append(s).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
