package core.basesyntax.serviceimpl;

import core.basesyntax.service.CsvWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public class CsvWriterImpl implements CsvWriter {
    @Override
    public File write(String content, String filePath) {
        File output = new File(filePath);
        try {
            Files.write(output.toPath(), Collections.singleton(content));
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + output.getName(), e);
        }
        return output;
    }
}
