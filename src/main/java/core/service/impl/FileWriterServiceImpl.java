package core.service.impl;

import core.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public boolean write(File file, String data) {
        try {
            Files.writeString(file.toPath(), data, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file " + file.getPath(), e);
        }
        return true;
    }
}
