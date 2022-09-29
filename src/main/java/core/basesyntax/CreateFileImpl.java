package core.basesyntax;

import core.basesyntax.service.CreateFile;
import java.io.File;
import java.io.IOException;

public class CreateFileImpl implements CreateFile {
    @Override
    public String createFile(String fileName) {
        try {
            new File(fileName).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cant create file.");
        }
        return fileName;
    }
}
