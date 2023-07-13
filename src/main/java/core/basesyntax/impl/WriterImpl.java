package core.basesyntax.impl;

import core.basesyntax.service.Writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public class WriterImpl implements Writer {
    @Override
    public File write(String content, String filePath) {
        if (content == null) {
            throw new RuntimeException("Content cannot be null, you should write something");
        }
        File output = new File(filePath);
        try {
            Files.write(output.toPath(), Collections.singleton(content));
        } catch (IOException e) {
            throw new RuntimeException("Can't data to file " + output.getName(), e);
        }
        return output;
    }
}
