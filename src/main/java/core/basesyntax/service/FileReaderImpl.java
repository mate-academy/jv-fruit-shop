package core.basesyntax.service;

import java.io.BufferedReader;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String fileName) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader())
    }
}
