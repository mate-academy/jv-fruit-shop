package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> read(String inputFilePass) {
        List<String> listOfStringsFromFile = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputFilePass));
            String line = fileReader.readLine();
            while (line != null) {
                listOfStringsFromFile.add(line);
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + inputFilePass, e);
        }
        return listOfStringsFromFile;
    }
}
