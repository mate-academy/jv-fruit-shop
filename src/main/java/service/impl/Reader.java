package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    String read(String fromFileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))){
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file " + fromFileName, e);
        }
        return builder.toString();
    }
}
