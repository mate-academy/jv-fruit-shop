package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.filereader.ParseDataFromFile;
import core.basesyntax.service.filereader.ParseDataFromFileImpl;
import core.basesyntax.service.filereader.ReadFromFile;
import core.basesyntax.service.filereader.ReadFromFileImpl;
import core.basesyntax.service.filewriter.WriteToFile;
import core.basesyntax.service.filewriter.WriteToFileImpl;
import core.basesyntax.service.interfaces.FruitShopService;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.BalanceTransactionHandler;
import core.basesyntax.service.transactions.PurchaseTransactionHandler;
import core.basesyntax.service.transactions.ReturnTransactionHandler;
import core.basesyntax.service.transactions.SupplyTransactionHandler;
import core.basesyntax.service.transactions.TransactionStrategyImpl;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private static final TransactionDao transactionDao = new TransactionDaoImpl();
    private static final ReadFromFile readFromFile = new ReadFromFileImpl();
    private static final ParseDataFromFile parseDataFromFile = new ParseDataFromFileImpl();
    private static final WriteToFile writeToFile = new WriteToFileImpl();
    private static final TransactionStrategy transaction = new TransactionStrategyImpl();

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
