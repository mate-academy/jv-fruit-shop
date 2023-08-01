package core.service;

import core.readException.ReadException;
import core.service.impl.Readable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReaderFile implements Readable {

    @Override
    public String read(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines()
                    .skip(1)
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new ReadException("Can't read data from file " + path);
        }
    }
}
