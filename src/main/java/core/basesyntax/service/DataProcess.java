package core.basesyntax.service;

import core.basesyntax.service.fileservice.ReaderImp;
import core.basesyntax.service.fileservice.WriterImp;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImp;
import java.util.List;
import java.util.Map;

public class DataProcess {
    private final ReaderImp reader;
    private final TransactionService readerService;
    private final OperationStrategy operationStrategy;
    private final FillStorage fillStorage;
    private final CreatReportService creatReportService;
    private final WriterImp write;

    public DataProcess(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.operationStrategy = new OperationStrategyImp(map);
        this.write = new WriterImp();
        this.reader = new ReaderImp();
        this.readerService = new TransactionServiceImp();
        this.fillStorage = new FillStorage();
        this.creatReportService = new CreateReportServiceImp();
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
