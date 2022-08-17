package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.io.Reader;
import core.basesyntax.io.ReaderImpl;
import core.basesyntax.io.ReportWriter;
import core.basesyntax.io.ReportWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.service.operation.AddingOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.OperationStratategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String pathToInputFile = "src/main/resources/InputFile.csv";
        Reader reader = new ReaderImpl();
        List<String> stringList = reader.readFromFile(pathToInputFile);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.getTransactions(stringList);

        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new AddingOperationHandler(new FruitDaoImpl()));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new AddingOperationHandler(new FruitDaoImpl()));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new AddingOperationHandler(new FruitDaoImpl()));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(new FruitDaoImpl()));

        OperationStratategy strategy = new OperationStrategyImpl(handlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(strategy);
        fruitShopService.process(transactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(new FruitDaoImpl().getAll());

        String pathToReport = "src/main/resources/report.csv";
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeToFile(report, pathToReport);
    }
}
