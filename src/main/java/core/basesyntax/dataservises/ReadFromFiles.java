package core.basesyntax.dataservises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFromFiles implements Reader {
    private String fromFileName;

    public ReadFromFiles(String fromFileName) {
        this.fromFileName = fromFileName;
    }

    public String getFromFileName() {
        return fromFileName;
    }

    @Override
    public List<String> read() {
        try {
            return Files.lines(Path.of(fromFileName))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFileName, e);
        }
    }
}
