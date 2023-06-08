package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class WriteDataToFileImpl implements WriteDataToFile {

    @Override
    public void writeReportToFile(String toFileName, String stringReport) {
        try {
            Files.write(Path.of(toFileName), Collections.singleton(stringReport));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
