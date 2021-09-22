package core.basesyntax.dataservices;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(List<String> list, String toFileName) {
        try {
            Files.write(Path.of(toFileName), list,
                        Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
