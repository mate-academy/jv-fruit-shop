package core.basesyntax.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteToFileImpl implements WriteToFile {
    private String toFileName = "output.csv";

    @Override
    public void writeToFile(List<String> outputData) {
        try {
            Path path = Paths.get(toFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            for (String output : outputData) {
                Files.writeString(path, output + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + toFileName, e);
        }
    }
}
