package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileProcessing;
import core.basesyntax.service.FileProcessingImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.impl.BalanceTransactionRecord;
import core.basesyntax.service.impl.PurchaseTransactionRecord;
import core.basesyntax.service.impl.ReturnTransactionRecord;
import core.basesyntax.service.impl.SupplyTransactionRecord;
import core.basesyntax.service.impl.TransactionRecord;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionRecord> transactionRecordsMap = new HashMap<>();
        transactionRecordsMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionRecord());
        transactionRecordsMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionRecord());
        transactionRecordsMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionRecord());
        transactionRecordsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionRecord());
        TransactionHandler transactionHandler = new TransactionHandlerImpl(transactionRecordsMap);
        FileProcessing fileProcessing = new FileProcessingImpl();
        StorageService storageService = new StorageServiceImpl(
                fileProcessing.getListOfTransaction(), transactionHandler);
        storageService.transfer();
        fileProcessing.add(Storage.fruits);
        storageService.showReport();
    }
}
