package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReaderImpl implements DataReader {
    private static final String NEW_LINE = "\n";

    @Override
    public String readDataFromFile(String filePath) {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data = bufferedReader.readLine();
            while (data != null) {
                builder.append(data)
                        .append(NEW_LINE);
                data = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path " + filePath, e);
        }
        return builder.toString().trim();
    }
}
