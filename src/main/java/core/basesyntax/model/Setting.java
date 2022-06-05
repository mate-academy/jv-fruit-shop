package core.basesyntax.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Setting {
    public static final String PROJECT_DIRECTORY = Path.of("").toAbsolutePath().toString();
    public static final Path RESOURCES_PATH =
            Paths.get(PROJECT_DIRECTORY, "src", "main", "resources");
    public static final Path INPUT_FILE_NAME = RESOURCES_PATH.resolve("fruit-log.csv");
    public static final Path OUTPUT_FILE_NAME = RESOURCES_PATH.resolve("fruit-stat.csv");
    public static final String FILE_HEADER_INPUT = "type,fruit,quantity";
    public static final String FILE_HEADER_OUTPUT = "fruit,quantity";
    public static final String FILE_LINE_SEPARATOR = ",";
    public static final int INDEX_OPERATION = 0;
    public static final int INDEX_PRODUCT = 1;
    public static final int INDEX_QUANTITY = 2;
}
