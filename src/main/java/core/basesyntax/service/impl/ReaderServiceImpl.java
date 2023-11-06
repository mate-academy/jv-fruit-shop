package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String EXCEPTION_MESSAGE = "Can not read file from: ";
    private static final String NULL_MESSAGE = "File path cannot be null.";
    private static final String DO_NOT_EXIST_MESSAGE = "File does not exist: ";

    @Override
    public List<String> read(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException(DO_NOT_EXIST_MESSAGE + filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(DO_NOT_EXIST_MESSAGE + filePath, e);
            }
        }
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean skipFirstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + filePath, e);
        }
        return data;
    }
}
