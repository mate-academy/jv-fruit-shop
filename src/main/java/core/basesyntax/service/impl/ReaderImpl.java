package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderImpl implements Reader {
    private static final int FIRST_LINE_OF_INPUT_FILE = 1;
    private static final String LINES_SEPARATOR = " ";

    @Override
    public String readDataFromFile(String outputFilePath) {
        try (Stream<String> fileLines = Files.lines(Paths.get(outputFilePath))) {
            return fileLines.skip(FIRST_LINE_OF_INPUT_FILE)
                    .collect(Collectors.joining(LINES_SEPARATOR));
        } catch (IOException e) {
            throw new FruitShopException("Can't read data from file by path " + outputFilePath);
        }
    }
}
