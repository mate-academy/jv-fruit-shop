package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import service.Reader;

public class ReaderImpl implements Reader {
    @Override
    public String read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            return builder.toString();
        } catch (Exception e) {
            throw new RuntimeException("Can't find a file " + fileName, e);
        }
    }
}
