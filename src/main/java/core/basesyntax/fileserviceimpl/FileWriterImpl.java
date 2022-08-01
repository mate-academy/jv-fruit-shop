package core.basesyntax.fileserviceimpl;

import core.basesyntax.fileservice.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String filePath, List<String> lines) {
        try {
            Files.write(Path.of(filePath), lines, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to this file: " + filePath);
        }
    }

}
