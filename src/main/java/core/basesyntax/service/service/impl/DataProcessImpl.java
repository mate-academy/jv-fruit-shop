package core.basesyntax.service.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreatReportService;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.fileservice.ReaderImpl;
import core.basesyntax.service.fileservice.WriterImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class DataProcessImpl implements DataProcess {
    private final ReaderImpl reader;
    private final TransactionService readerService;
    private final OperationStrategy operationStrategy;
    private final FillStorageImpl fillStorage;
    private final CreatReportService creatReportService;
    private final WriterImpl write;

    public DataProcessImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.operationStrategy = new OperationStrategyImpl(map);
        this.write = new WriterImpl();
        this.reader = new ReaderImpl();
        this.readerService = new TransactionServiceImpl();
        this.fillStorage = new FillStorageImpl();
        this.creatReportService = new CreateReportServiceImpl();
    }

    public void processReport(String fileFrom, String fileTo) {
        List<String> dataFromFile = reader.readFromInput(fileFrom);
        fillStorage.fill(dataFromFile);
        List<FruitTransaction> fruitTransactions = readerService.creatListTransaction(dataFromFile);
        processTransaction(fruitTransactions);
        write.write(fileTo, creatReportService.createReport());
    }

    private void processTransaction(List<FruitTransaction> transactions) {
        transactions
                .forEach(t -> operationStrategy.get(t.getOperation()).updateBalance(t));
    }
}
