package fruitshop.sevice.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.sevice.TextProcessorService;
import java.util.ArrayList;
import java.util.List;

public class TextProcessorServiceImpl implements TextProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> format(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] splittedLine = line.split(SEPARATOR);
            fruitTransactions.add(
                    new FruitTransaction(
                            FruitTransaction.Operation.getOperationByCode(
                                    splittedLine[OPERATION_INDEX]),
                            splittedLine[FRUIT_INDEX],
                            Integer.parseInt(splittedLine[AMOUNT_INDEX])));
        }
        return fruitTransactions;
    }
}
