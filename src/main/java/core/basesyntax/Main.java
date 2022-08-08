package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.separator.CreateTransactionsImpl;
import core.basesyntax.service.fileoperation.CreateReport;
import core.basesyntax.service.fileoperation.CsvFileWriter;
import core.basesyntax.service.fileoperation.TransactionProcessing;
import core.basesyntax.service.fileoperation.impl.CreateReportImpl;
import core.basesyntax.service.fileoperation.impl.CsvFileReaderImpl;
import core.basesyntax.service.fileoperation.impl.CsvFileWriterImpl;
import core.basesyntax.service.fileoperation.impl.TransactionProcessingImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceHandler;
import core.basesyntax.service.operation.impl.PurchaseHandler;
import core.basesyntax.service.operation.impl.ReturnHandler;
import core.basesyntax.service.operation.impl.SupplyHandler;
import core.basesyntax.strategy.StrategyOperationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Transaction.Type, OperationHandler> typeOperationMap = new HashMap<>();
        typeOperationMap.put(Transaction.Type.BALANCE, new BalanceHandler(storageDao));
        typeOperationMap.put(Transaction.Type.SUPPLY, new SupplyHandler(storageDao));
        typeOperationMap.put(Transaction.Type.PURCHASE, new PurchaseHandler(storageDao));
        typeOperationMap.put(Transaction.Type.RETURN,
                new ReturnHandler(storageDao));
        List<String> readInputFile = new CsvFileReaderImpl()
                .inputFile("src/main/resources/input.csv");
        TransactionProcessing processor =
                new TransactionProcessingImpl(new StrategyOperationImpl(typeOperationMap));
        processor.transactionProcessing(new CreateTransactionsImpl()
                .getAllTransactions(readInputFile));
        CreateReport report = new CreateReportImpl();
        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeFile("src/main/resources/output.csv");
        System.out.println(report.getReport());
    }
}
