package core.basesyntax.util.validator;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathValidator {
    public static void validatePath(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("Provided path is null");
        }
        if (Files.notExists(path)) {
            throw new IllegalArgumentException("Provided path is not exist: " + path);
        }
        if (Files.isDirectory(path)) {
            throw new IllegalArgumentException("Provided path is not a file: " + path);
        }
    }
}
