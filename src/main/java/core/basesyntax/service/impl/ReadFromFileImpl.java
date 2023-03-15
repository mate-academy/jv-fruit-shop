package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {

    @Override
    public List<String> getListOfDataFromFile(String nameOfFile) {
        List<String> strings = new ArrayList<>();
        File from = new File(nameOfFile);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from))) {
            String note = bufferedReader.readLine();
            while (note != null) {
                strings.add(note);
                note = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file", e);
        }
        return strings;
    }
}
