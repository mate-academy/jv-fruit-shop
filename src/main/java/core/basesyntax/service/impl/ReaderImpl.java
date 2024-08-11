package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {

    @Override
    public List<String> read(String filePath) {
        List<String> linesArray = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                linesArray.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath + e);
        }
        return linesArray;
    }
}
