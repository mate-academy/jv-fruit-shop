package core.basesyntax.service.implementation;

import core.basesyntax.service.ReadFromFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileServiceImplementation implements ReadFromFileService {
    @Override
    public String readFromFile(String fromFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader
                    bufferedReader = new BufferedReader(new FileReader(fromFileName));
            int value = bufferedReader.read();

            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + fromFileName);
        }
    }
}
