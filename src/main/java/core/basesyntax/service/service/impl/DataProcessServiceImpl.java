package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.fileservice.FileReaderImpl;
import core.basesyntax.service.fileservice.FileWriterImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class DataProcessServiceImpl implements DataProcessService {
    private final FileReaderImpl reader;
    private final TransactionService readerService;
    private final OperationStrategy operationStrategy;
    private final FillStorageServiceImpl fillStorage;
    private final CreateReportService createReportService;
    private final FileWriterImpl writer;

    public DataProcessServiceImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.operationStrategy = new OperationStrategyImpl(map);
        this.writer = new FileWriterImpl();
        this.reader = new FileReaderImpl();
        this.readerService = new TransactionServiceImpl();
        this.fillStorage = new FillStorageServiceImpl();
        this.createReportService = new CreateReportServiceImpl();
    }

    public void processReport(String fileFrom, String fileTo) {
        List<String> dataFromFile = reader.read(fileFrom);
        fillStorage.fill(dataFromFile);
        List<FruitTransaction> fruitTransactions =
                readerService.createListTransaction(dataFromFile);
        processTransaction(fruitTransactions);
        writer.write(fileTo, createReportService.createReport());
    }

    private void processTransaction(List<FruitTransaction> transactions) {
        transactions
                .forEach(transaction ->
                        operationStrategy.get(transaction.getOperation()).update(transaction));
    }
}
