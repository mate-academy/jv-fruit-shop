package core.basesyntax;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGeneration;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGenerationImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.HandlerOperation;
import core.basesyntax.strategy.impl.HandlerOperationImplBalance;
import core.basesyntax.strategy.impl.HandlerOperationImplPurchase;
import core.basesyntax.strategy.impl.HandlerOperationImplReturn;
import core.basesyntax.strategy.impl.HandlerOperationImplStrategy;
import core.basesyntax.strategy.impl.HandlerOperationImplSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String WRITE_FROM = "src/main/resources/input.csv";
    private static final String WRITE_TO = "src/main/resources/result.csv";

    public static void main(String[] args) {

        Map<String, HandlerOperation> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE.chooseOperation(), new HandlerOperationImplBalance());
        operationHandlerMap.put(PURCHASE.chooseOperation(), new HandlerOperationImplPurchase());
        operationHandlerMap.put(RETURN.chooseOperation(), new HandlerOperationImplReturn());
        operationHandlerMap.put(SUPPLY.chooseOperation(), new HandlerOperationImplSupply());

        FileReader getDataBase = new FileReaderImpl();
        List<String> list = getDataBase.readFromFile(WRITE_FROM);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.transactionParser(list);

        TransactionService insertDataToBase =
                new TransactionServiceImpl(new HandlerOperationImplStrategy(operationHandlerMap));
        insertDataToBase.addTransferToStorage(transactions);

        ReportGeneration reportGeneration = new ReportGenerationImpl();
        String report = reportGeneration.generateReport(FruitStorage.fruitStorage);

        FileWriter writeDataToFile = new FileWriterImpl();
        writeDataToFile.writeDataToFile(report, WRITE_TO);
    }
}
