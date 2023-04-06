package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterToCsvImpl implements Writer {
    @Override
    public void writeReport(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity\n");
        Storage.getFruitsStorage()
                .forEach((key,value) -> stringBuilder.append(key).append(",").append(value).append("\n"));
        try {
            Files.write(Path.of(path), stringBuilder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + path, e);
        }
    }
}
