package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String CAN_T_FIND_FILE_BY_PATH = "Can't find file by path ";
    private static final int NUMBER_OF_HEADER_LINES = 1;

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.lines()
                    .skip(NUMBER_OF_HEADER_LINES)
                    .map(String::trim)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(CAN_T_FIND_FILE_BY_PATH + filePath, e);
        }
    }
}
