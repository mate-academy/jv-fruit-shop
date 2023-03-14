package service.impl;

import dao.ReaderService;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ProcessData;
import strategy.ActivitiesStrategy;

public class ProcessDataImpl implements ProcessData {
    private static final int INDEX_OF_TITLE = 0;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String SEPARATOR = ",";
    private ReaderService readerService;
    private ActivitiesStrategy strategy;

    public ProcessDataImpl(ReaderService readerService, ActivitiesStrategy strategy) {
        this.readerService = readerService;
        this.strategy = strategy;
    }

    @Override
    public void processInputData() {
        List<String> inputData = readerService.get();
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        inputData.remove(INDEX_OF_TITLE);
        for (String line : inputData) {
            String[] data = line.split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction(data[OPERATION_POSITION],
                    data[FRUIT_POSITION],
                    Integer.valueOf(data[QUANTITY_POSITION]));
            fruitTransactions.add(fruitTransaction);
        }
        pushInfoToDatabase(fruitTransactions);
    }

    private void pushInfoToDatabase(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.get(fruitTransaction.getOperationCharacter().trim())
                    .operation(fruitTransaction);
        }
    }
}
