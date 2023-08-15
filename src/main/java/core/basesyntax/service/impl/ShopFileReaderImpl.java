package core.basesyntax.service.impl;

import core.basesyntax.service.ShopFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public String read(String path) {
        StringBuilder builder = new StringBuilder();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            line = br.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read from the file ", e);
        }
        return builder.toString();
    }
}
