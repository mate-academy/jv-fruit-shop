package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeReportToFile(List<String> fruitInfo, String filePlace) {
        try {
            Files.write(Path.of(filePlace), fruitInfo);
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file" + filePlace, e);
        }
    }
}
