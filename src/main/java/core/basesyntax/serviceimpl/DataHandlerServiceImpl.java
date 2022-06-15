package core.basesyntax.serviceimpl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.strategy.OperationProcessingStrategy;
import java.util.List;
import java.util.function.Consumer;

public class DataHandlerServiceImpl implements core.basesyntax.service.DataHandlerService {
    private CsvFileReaderService fileReaderService;
    private OperationProcessingStrategy operationProcessingStrategy;
    private FruitsDao fruitsDao;

    public DataHandlerServiceImpl(CsvFileReaderService fileReaderService,
                                  OperationProcessingStrategy operationProcessingStrategy,
                                  FruitsDao fruitsDao) {
        this.fileReaderService = fileReaderService;
        this.operationProcessingStrategy = operationProcessingStrategy;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handleData() {
        List<FruitTransaction> transactions = fileReaderService.read();
        Consumer<FruitTransaction> consumer = transaction
                -> operationProcessingStrategy.get(transaction.getOperation())
                .doAction(transaction.getFruit(), transaction.getAmount());
        transactions.forEach(consumer);
    }
}
