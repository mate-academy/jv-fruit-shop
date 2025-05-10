package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterServiceImpl implements FileWriter {

    @Override
    public void write(String data, String newReportName) {
        if (Files.exists(Paths.get(newReportName))) {
            throw new RuntimeException("A file with this name already exists. Name: "
                    + newReportName);
        }
        try {
            Files.write(Paths.get(newReportName), data.getBytes());
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write data to the file: "
                    + newReportName, e);
        }
    }
}
