package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReaderImpl implements DataReader {
    @Override
    public String readData(String fromFile) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            String data = reader.readLine();
            while (data != null) {
                builder.append(data).append(System.lineSeparator());
                data = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + e);
        }
        return builder.toString();
    }
}
