package core.basesyntax.impl;

import core.basesyntax.service.FileValidation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CsvFileValidationImpl implements FileValidation {
    private static final String VALID_CSV_EXAMPLE =
            "type,fruit,quantity\n"
                    + "b,banana,20\n"
                    + "b,apple,100\n"
                    + "s,banana,100\n"
                    + "p,banana,13\n"
                    + "r,apple,10\n"
                    + "p,apple,20\n"
                    + "p,banana,5\n"
                    + "s,banana,50\n";

    @Override
    public void validateFile(String path) {
        File file = new File(path);
        fileExists(file);
        fileReadable(file);
        fileNotEmpty(file);
    }

    private void fileExists(File file) {
        if (!file.exists()) {
            throw new RuntimeException(new FileNotFoundException("File does not exist: "
                    + file.getAbsolutePath()));
        }
    }

    private void fileReadable(File file) {
        if (!file.canRead()) {
            throw new RuntimeException(new IOException("File is not readable: "
                    + file.getAbsolutePath()));
        }
    }

    private void fileNotEmpty(File file) {
        if (file.length() == 0) {
            throw new IllegalArgumentException("File is empty: " + file.getAbsolutePath()
                    + String.format("\nThe method expects a file with a similar data structure : "
                    + "\n\n%s\n", VALID_CSV_EXAMPLE));
        }
    }
}
