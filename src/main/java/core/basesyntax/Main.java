package core.basesyntax;

import core.basesyntax.dao.InventoryDao;
import core.basesyntax.dao.InventoryDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.OperationType;
import core.basesyntax.service.ReadDataParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvDataReader;
import core.basesyntax.service.impl.CsvDataWriter;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.ReadDataParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryDao inventoryDao = new InventoryDaoImpl();
        final HandlerStrategy handlerStrategy = new HandlerStrategy(new HashMap<>());
        HandlerStrategy.getStrategyMap().put(OperationType.BALANCE,
            new BalanceHandler(inventoryDao));
        HandlerStrategy.getStrategyMap().put(OperationType.PURCHASE,
            new PurchaseHandler(inventoryDao));
        HandlerStrategy.getStrategyMap().put(OperationType.RETURN,
            new ReturnHandler(inventoryDao));
        HandlerStrategy.getStrategyMap().put(OperationType.SUPPLY,
            new SupplyHandler(inventoryDao));
        CsvDataReader csvDataReader = new CsvDataReader();
        List<String> readData = csvDataReader.readFileLines("src/main/resources/Input.txt");
        System.out.println(readData);
        ReadDataParser readDataParser = new ReadDataParserImpl();
        List<FruitTransaction> transactionList = readDataParser.convertToFruitTransactionList(
                readData);
        System.out.println(transactionList);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(handlerStrategy);
        for (FruitTransaction transaction : transactionList) {
            transactionProcessor.processTransaction(transaction, handlerStrategy);
        }
        System.out.println(inventoryDao.getCurrentInventoryState());
        CsvReportGenerator csvReportGenerator = new CsvReportGenerator();
        String reportString = csvReportGenerator.generateReport();
        System.out.println(reportString);
        CsvDataWriter csvDataWriter = new CsvDataWriter();
        csvDataWriter.writeToFile("src/main/resources/Output.txt",reportString);
    }
}
