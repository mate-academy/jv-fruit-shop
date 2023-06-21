package core.basesyntax.service.fileservice.impl;

import core.basesyntax.service.fileservice.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl extends FileWriterService {

    @Override
    public void setData(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path);
        }
    }
}
