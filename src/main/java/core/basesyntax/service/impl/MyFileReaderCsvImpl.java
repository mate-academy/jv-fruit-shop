package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderCsvImpl implements MyFileReader {
    @Override
    public List<String> readFromFile(String filePathForRead) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new java.io.FileReader(filePathForRead))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                lines.add(value);
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + filePathForRead, e);
        } catch (IOException e) {
            throw new RuntimeException("Data couldn't read from file " + filePathForRead, e);
        }
        if (lines.size() > 0) {
            lines.remove(0);
        }
        return lines;
    }
}
