package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {
    public List<String> getDryInfo(File file) {
        List<String> info;
        try {
            info = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
        if (info.size() < 2) {
            throw new RuntimeException("Not enough data");
        }
        if (!info.get(0).equals("type,fruit,quantity")) {
            throw new RuntimeException("Inappropriate format(1 line)");
        }
        info.remove(0);
        return info;
    }
}
