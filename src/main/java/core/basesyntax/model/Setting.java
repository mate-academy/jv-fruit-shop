package core.basesyntax.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Setting {
    public static final Path DIRECTORY_PROJECT = Path.of("").toAbsolutePath();
    public static final Path DIRECTORY_RESOURCES =
            Paths.get(DIRECTORY_PROJECT.toString(), "src", "main", "resources");
    public static final Path FILE_NAME_INPUT = DIRECTORY_RESOURCES.resolve("fruit-log.csv");
    public static final Path FILE_NAME_OUTPUT = DIRECTORY_RESOURCES.resolve("fruit-stat.csv");
    public static final String HEADER_FILE_INPUT = "type,fruit,quantity";
    public static final String HEADER_FILE_OUTPUT = "fruit,quantity";
    public static final String FIELDS_DELIMITER_IN_FILE = ",";
    public static final int INDEX_FOR_OPERATION = 0;
    public static final int INDEX_FOR_PRODUCT = 1;
    public static final int INDEX_FOR_QUANTITY = 2;
}
