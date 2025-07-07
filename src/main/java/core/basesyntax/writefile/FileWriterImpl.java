package core.basesyntax.writefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String date, String nameFile) {
        try {
            Files.writeString(Path.of(nameFile),date);
        } catch (IOException e) {
            throw new RuntimeException("Can't write dates on the output file",e);
        }
    }
}
