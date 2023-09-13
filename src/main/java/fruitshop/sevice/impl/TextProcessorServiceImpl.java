package fruitshop.sevice.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.sevice.TextProcessorService;
import java.util.ArrayList;
import java.util.List;

public class TextProcessorServiceImpl implements TextProcessorService {
    @Override
    public List<FruitTransaction> format(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] splittedLine = line.split(",");
            fruitTransactions.add(
                    new FruitTransaction(
                            FruitTransaction.Operation.getOperationByCode(splittedLine[0]),
                            splittedLine[1],
                            Integer.parseInt(splittedLine[2])));
        }

        return fruitTransactions;
    }
}
