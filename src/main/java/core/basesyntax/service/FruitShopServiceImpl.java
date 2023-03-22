package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.fileReader.ParseDataFromFileImpl;
import core.basesyntax.service.fileReader.ReadFromFileImpl;
import core.basesyntax.service.interfaces.FruitShopService;
import core.basesyntax.service.interfaces.ParseDataFromFile;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.transactions.*;

import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private static final TransactionDao transactionDao = new TransactionDaoImpl();

    @Override
    public void createReport(String fileName) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> dataFromFile = readFromFile.dataFromFile(fileName);
        System.out.println(dataFromFile);

        ParseDataFromFile parseDataFromFile = new ParseDataFromFileImpl();
        List<FruitTransaction> parsedDataFromFile = parseDataFromFile.parsedFruitsTransactions(dataFromFile);
        System.out.println(parsedDataFromFile);

        TransactionStrategyImpl.handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler());
        TransactionStrategyImpl.handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionHandler());
        TransactionStrategyImpl.handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler());
        TransactionStrategyImpl.handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler());

        transactionDao.addAll(parsedDataFromFile);

    }
}
