package core.basesyntax.service.impl;

import core.basesyntax.errors.ErrorMessages;
import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int NUMBER_OF_HEADER_LINES = 1;

    @Override
    public List<String> read(String fromFileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFileName))) {
            return bufferedReader.lines()
                    .skip(NUMBER_OF_HEADER_LINES)
                    .map(String::trim)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(ErrorMessages.CAN_T_READ_FROM_FILE + fromFileName, e);
        }
    }
}
