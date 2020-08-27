package core.basesyntax.fileservice;

import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.fruitservice.Transaction;
import java.util.List;

public class ReadFileService {
    private static FruitStorageService fruitStorage = new FruitStorageService();

    public void parseInput(String filename) {
        ReadFile reader = new ReadFile();
        List<String[]> input = reader.read(filename);
        for (String[] strings : input) {
            fruitStorage.addToStorage(Transaction.build(strings[0], strings[1],
                    strings[2], strings[3]));
        }
    }
}
