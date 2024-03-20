package core.basesyntax.service.filewriter;

import core.basesyntax.service.exeptions.FileWriterExeption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(List<String> report, String filePath) throws IOException {
        try {
            Files.write(Path.of(filePath), report);
        } catch (IOException e) {
            throw new FileWriterExeption("Can't write to file " + filePath);
        }
    }
}
