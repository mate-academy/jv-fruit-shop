package core.basesyntax.service.impl;

import core.basesyntax.exception.FruitShopReadfromfileException;
import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readData(String fromFile) {
        if (fromFile == null || fromFile.equals("")) {
            throw new FruitShopReadfromfileException("Wrong path of the file: " + fromFile);
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))) {
            StringBuilder data = new StringBuilder();
            String line = bufferedReader.readLine();
            if (line.isEmpty()) {
                throw new FruitShopReadfromfileException("File can't be empty: " + fromFile);
            }
            while (line != null && !line.isEmpty()) {
                data.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            return data.toString().trim();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fromFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from this file: " + fromFile, e);
        }
    }
}
