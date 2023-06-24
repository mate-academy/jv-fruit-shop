package core.basesyntax.service;

import core.basesyntax.exeption.FruitShopExeption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService {

    public void writeFile(String fileName, String message) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            throw new FruitShopExeption("Can't write in file " + file);
        }
    }
}
