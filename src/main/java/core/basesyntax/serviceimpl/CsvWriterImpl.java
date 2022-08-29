package core.basesyntax.serviceimpl;

import core.basesyntax.service.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public class CsvWriterImpl implements Writer {
    @Override
    public void write(String content, String filePath) {
        File output = new File(filePath);
        try {
            output.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can`t create file " + output.getName(), e);
        }
        try {
            Files.write(output.toPath(), Collections.singleton(content));
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + output.getName(), e);
        }
    }
}
