package core.basesyntax.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    private String fromFileName = "load.csv";

    @Override
    public List<String> readFromFile() {
        try {
            File fromFile = new File(fromFileName);
            return new ArrayList<>(Files.readAllLines(fromFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fromFileName, e);
        }
    }
}
