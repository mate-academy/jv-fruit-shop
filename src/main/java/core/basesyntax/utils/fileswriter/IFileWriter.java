package core.basesyntax.utils.fileswriter;

import java.nio.file.Path;

public interface IFileWriter {
    void writeToFile(Path path, byte[] content);
}
