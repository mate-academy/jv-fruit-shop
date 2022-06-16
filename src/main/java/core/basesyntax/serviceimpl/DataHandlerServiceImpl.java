package core.basesyntax.serviceimpl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.strategy.OperationProcessingStrategy;
import core.basesyntax.strategy.TransactionsStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DataHandlerServiceImpl implements core.basesyntax.service.DataHandlerService {
    private static final int TYPE_OF_OPERATION_INDEX = 0;
    private static final int FRUIT_TITLE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private CsvFileReaderService fileReaderService;
    private OperationProcessingStrategy operationProcessingStrategy;
    private FruitsDao fruitsDao;
    private TransactionsStrategy transactionsStrategy;

    public DataHandlerServiceImpl(CsvFileReaderService fileReaderService,
                                  OperationProcessingStrategy operationProcessingStrategy,
                                  FruitsDao fruitsDao, TransactionsStrategy transactionsStrategy) {
        this.fileReaderService = fileReaderService;
        this.operationProcessingStrategy = operationProcessingStrategy;
        this.fruitsDao = fruitsDao;
        this.transactionsStrategy = transactionsStrategy;
    }

    @Override
    public void handleData() {
        List<String> dataFromFile = fileReaderService.read();
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        Consumer<String[]> consumerForHandlingData = stringArray ->
                fruitTransactions.add(
                        new FruitTransaction(transactionsStrategy
                                .get(stringArray[TYPE_OF_OPERATION_INDEX]),
                                stringArray[FRUIT_TITLE_INDEX],
                                Integer.parseInt(stringArray[AMOUNT_INDEX])));
        Consumer<FruitTransaction> consumer = transaction
                -> operationProcessingStrategy.get(transaction.getOperation())
                .doAction(transaction.getFruit(), transaction.getAmount());
        dataFromFile.stream()
                .map(string -> string.split(","))
                .skip(1)
                .forEach(consumerForHandlingData);
        fruitTransactions.forEach(consumer);
    }
}
