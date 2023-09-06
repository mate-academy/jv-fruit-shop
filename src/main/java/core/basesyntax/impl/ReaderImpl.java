package core.basesyntax.impl;

import core.basesyntax.service.util.Reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final int TITLE_INDEX = 0;

    @Override
    public List<String> readFromFileToList(String fileName) {
        File file = new File(fileName);
        List<String> report;
        try {
            report = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file :" + file, e);
        }
        report.remove(TITLE_INDEX);
        return report;
    }
}

