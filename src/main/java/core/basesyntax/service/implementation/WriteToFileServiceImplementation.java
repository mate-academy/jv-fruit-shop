package core.basesyntax.service.implementation;

import core.basesyntax.service.WriteToFileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileServiceImplementation implements WriteToFileService {
    @Override
    public void writeToFile(String reportString, String toFileName) {
        try {
            new File(toFileName).createNewFile();
            Files.write(new File(toFileName).toPath(), reportString.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file" + toFileName);
        }
    }
}
