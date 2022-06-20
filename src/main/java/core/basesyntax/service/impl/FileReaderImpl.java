package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String readLine;
            bufferedReader.readLine();
            while ((readLine = bufferedReader.readLine()) != null) {
                list.add(readLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read line", e);
        }
        return list;
    }
}
