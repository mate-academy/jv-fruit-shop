package core.service.impl;

import core.service.ReaderFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFromFileImp implements ReaderFromFile {
    @Override
    public List<String> readFromFileData(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().skip(1).collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException("Can't read the file " + filePath);
        }
    }
}
