package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsvService implements Reader {
    private static final String TITLE = "type";
    private static final int INDEX_OF_TITLE = 0;
    private static final String CANT_READ_EXCEPTION_MESSAGE = "can't read file";

    @Override
    public List<String> read(String path) {
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_EXCEPTION_MESSAGE + path,e);
        }
        if (data.get(INDEX_OF_TITLE).contains(TITLE)) {
            data.remove(INDEX_OF_TITLE);
        }
        return data;
    }
}
