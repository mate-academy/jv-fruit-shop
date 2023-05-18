package core.basesyntax.service.impl;

import core.basesyntax.service.ShopFileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public String read(String path) {
        StringBuilder builder = new StringBuilder();
        String line = "";
        try (java.io.FileReader fr = new java.io.FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
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
