package core.basesyntax.utils.filesWriter;

import java.nio.file.Path;

public interface IFileWriter {
    void writeToFile(Path path, byte[] content);
}
