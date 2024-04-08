package core.basesyntax.serviceImp;

import core.basesyntax.service.CSVWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVWriterImp implements CSVWriter {
    @Override
    public void write(String text, String fileName) {
        try {
            Files.write(Paths.get("src/main/resources/" + fileName + ".csv"), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to write report",e);
        }
    }
}
