package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> fileToStringList(File file) {
        List<String> list;
        try {
            list = Files.readAllLines(file.toPath());

        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + file,e);
        }
        list.remove(0);
        return list;
    }
}
