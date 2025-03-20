package core.basesyntax.service.impl;

import static core.basesyntax.Main.FILE_PATH_INPUT_FILE;

import core.basesyntax.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements CustomFileReader {

    @Override
    public List<String> read() {
        File file = new File(FILE_PATH_INPUT_FILE);

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_INPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file "
                    + file.getName() + ": " + e.getMessage(), e);
        }
        return lines;
    }
}
