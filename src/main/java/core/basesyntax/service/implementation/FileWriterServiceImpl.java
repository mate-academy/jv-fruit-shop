package core.basesyntax.service.implementation;

import core.basesyntax.exeption.FruitShopExceptions;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String toFile, String infoToWrite) {
        File file = new File(toFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(infoToWrite);
        } catch (IOException e) {
            throw new FruitShopExceptions("Can't write to file:" + file);
        }
    }
}
