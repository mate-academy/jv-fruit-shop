package core.basesyntax.service.impl;

import core.basesyntax.service.WriterFunction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterFunctionImpl implements WriterFunction {
    private static final String INCORRECT_PATH_EXCEPTION_MESSAGE = "File's path is incorrect: ";

    @Override
    public void writeFile(String filePath, String report) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException(INCORRECT_PATH_EXCEPTION_MESSAGE + filePath, e);
        }
    }
}
