package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationStrategy;
import core.basesyntax.service.LineGenerator;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Splitter;
import core.basesyntax.service.Storage;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitOperationStrategyImpl;
import core.basesyntax.service.impl.LineGeneratorImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.SplitterImpl;
import core.basesyntax.service.impl.StorageImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.FruitsOperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fromPath = "src/main/resources/ActionPerDay.csv";
        Reader readTransactions = new ReaderImpl();
        Splitter splitInformation = new SplitterImpl();
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, FruitsOperationHandler> amountHandlerMap = new HashMap<>();
        amountHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
        List<FruitTransaction> allTransactions = splitInformation
                .createTransactionList(readTransactions.convertFromFileToList(fromPath));
        FruitOperationStrategy fruitsAmountStrategy =
                new FruitOperationStrategyImpl(amountHandlerMap);
        Storage fillStorage = new StorageImpl(fruitsAmountStrategy, storageDao);
        fillStorage.fillStorage(allTransactions);
        LineGenerator generateReportLines = new LineGeneratorImpl();
        String report = generateReportLines.createReport(storageDao.getAll());
        String toPath = "src/main/resources/TheRemainingFruit.csv";
        Writer writeReport = new WriterImpl();
        writeReport.fruitsReport(report, toPath);
    }
}
