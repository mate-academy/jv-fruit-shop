package core.basesyntax.dataservises;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteToFile implements Writer {
    private String toFileName;

    public WriteToFile(String toFileName) {
        this.toFileName = toFileName;
    }

    public String getToFileName() {
        return toFileName;
    }

    @Override
    public void write(List<String> list) {
        try {
            Files.write(Path.of(toFileName),list,
                        Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
