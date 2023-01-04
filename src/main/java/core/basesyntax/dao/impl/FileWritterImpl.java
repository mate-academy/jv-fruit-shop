package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileWritter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWritterImpl implements FileWritter {
    @Override
    public void writeData(String data, String code) {
        File file = new File(code);
        try {
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file:" + code, e);
        }
    }
}
