package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader implements Reader<File, String> {
    @Override
    public List<String> readLines(File source) {
        try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File to read from not found " + source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
