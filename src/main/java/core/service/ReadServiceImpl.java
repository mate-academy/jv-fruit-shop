package core.service;

import core.exception.FileReadException;
import core.service.impl.ReadService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReadServiceImpl implements ReadService {

    @Override
    public String read(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines()
                    .skip(1)
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new FileReadException("Can't read data from file " + path);
        }
    }
}
