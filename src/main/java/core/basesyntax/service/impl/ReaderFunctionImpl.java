package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFunction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFunctionImpl implements ReaderFunction {
    private static final String INCORRECT_PATH_EXCEPTION_MESSAGE = "File's path is incorrect: ";

    @Override
    public List<String> readFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(INCORRECT_PATH_EXCEPTION_MESSAGE + filePath, e);
        }
    }
}
