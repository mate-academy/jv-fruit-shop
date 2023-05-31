package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String path) {
    File file = new File(path);
    List<String> data = new ArrayList<>();
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
        String lineFromFile = bufferedReader.readLine();
        while (lineFromFile != null) {
            data.add(lineFromFile);
            lineFromFile = bufferedReader.readLine();
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException ("Path to the file is wrong, can't find file. " + e);
    } catch (IOException e) {
        throw new RuntimeException("Can't read from this file. " + e);
    }
    return data;
    }
}
