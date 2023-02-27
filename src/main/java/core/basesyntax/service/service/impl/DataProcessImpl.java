package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.fileservice.FileReaderImpl;
import core.basesyntax.service.fileservice.FileWriterImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class DataProcessImpl implements DataProcess {
    private final FileReaderImpl reader;
    private final TransactionService readerService;
    private final OperationStrategy operationStrategy;
    private final FillStorageImpl fillStorage;
    private final CreateReportService createReportService;
    private final FileWriterImpl write;

    public DataProcessImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.operationStrategy = new OperationStrategyImpl(map);
        this.write = new FileWriterImpl();
        this.reader = new FileReaderImpl();
        this.readerService = new TransactionServiceImpl();
        this.fillStorage = new FillStorageImpl();
        this.createReportService = new CreateReportServiceImpl();
    }

    public void processReport(String fileFrom, String fileTo) {
        List<String> dataFromFile = reader.read(fileFrom);
        fillStorage.fill(dataFromFile);
        List<FruitTransaction> fruitTransactions = readerService.creatListTransaction(dataFromFile);
        processTransaction(fruitTransactions);
        write.write(fileTo, createReportService.createReport());
    }

    private void processTransaction(List<FruitTransaction> transactions) {
        transactions
                .forEach(trans -> operationStrategy.get(trans.getOperation()).update(trans));
    }
}
