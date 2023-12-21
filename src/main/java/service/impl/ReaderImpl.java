package service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find a file " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + fileName, e);
        }
    }
}
