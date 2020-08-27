package core.basesyntax.fileservice;

import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.fruitservice.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    private static FruitStorageService fruitStorage = new FruitStorageService();

    public void readFromFile(String filename) {
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            int forRemoveHeader = 0;
            while ((line = input.readLine()) != null) {
                if (forRemoveHeader == 0) {
                    forRemoveHeader++;
                    continue;
                }
                String[] strings = line.split(",");
                fruitStorage.addToStorage(Transaction.build(strings[0], strings[1],
                        strings[2], strings[3]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem with reading files", e);
        }
    }
}
