package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.filereader.FileParser;
import core.basesyntax.service.filereader.FileReader;
import core.basesyntax.service.filewriter.FileWriter;
import core.basesyntax.service.interfaces.FruitShopService;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.BalanceTransactionHandler;
import core.basesyntax.service.transactions.PurchaseTransactionHandler;
import core.basesyntax.service.transactions.ReturnTransactionHandler;
import core.basesyntax.service.transactions.SupplyTransactionHandler;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final TransactionDao transactionDao;
    private final FileReader readFromFile;
    private final FileParser parseDataFromFile;
    private final FileWriter writeToFile;
    private final TransactionStrategy transaction;

    public FruitShopServiceImpl(TransactionDao transactionDao,
                                FileReader readFromFile, FileParser parseDataFromFile,
                                FileWriter writeToFile, TransactionStrategy transaction) {
        this.transactionDao = transactionDao;
        this.readFromFile = readFromFile;
        this.parseDataFromFile = parseDataFromFile;
        this.writeToFile = writeToFile;
        this.transaction = transaction;
    }

    @Override
    public void createReport(String fileName) {
        List<String> dataFromFile = readFromFile.dataFromFile(fileName);

        transaction.addToMap(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        transaction.addToMap(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
        transaction.addToMap(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        transaction.addToMap(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());

        List<FruitTransaction> parsedDataFromFile = parseDataFromFile
                .parsedFruitsTransactions(dataFromFile);
        transactionDao.addAll(parsedDataFromFile);
        writeToFile.writeToFile();
    }
}
