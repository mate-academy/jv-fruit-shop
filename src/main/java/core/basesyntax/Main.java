package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.DataHandlerServiceImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.processing.BalanceProcessing;
import core.basesyntax.service.processing.OperationProcessing;
import core.basesyntax.service.processing.PurchaseProcessing;
import core.basesyntax.service.processing.ReturnProcessing;
import core.basesyntax.service.processing.SupplyProcessing;
import core.basesyntax.strategy.OperationProcessingStrategy;
import core.basesyntax.strategy.TransactionsStrategy;
import core.basesyntax.strategy.impl.OperationProcessingStrategyImpl;
import core.basesyntax.strategy.impl.TransactionsStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, FruitTransaction.Operation> stringTransactionHandlerMap = new HashMap<>();
        stringTransactionHandlerMap.put("b", FruitTransaction.Operation.BALANCE);
        stringTransactionHandlerMap.put("p", FruitTransaction.Operation.PURCHASE);
        stringTransactionHandlerMap.put("r", FruitTransaction.Operation.RETURN);
        stringTransactionHandlerMap.put("s", FruitTransaction.Operation.SUPPLY);
        FruitsDao fruitsDao = new FruitsDaoImpl();

        Map<FruitTransaction.Operation, OperationProcessing> operationProcessingMap =
                new HashMap<>();
        operationProcessingMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.RETURN,
                new ReturnProcessing(fruitsDao));
        operationProcessingMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyProcessing(fruitsDao));

        TransactionsStrategy transactionsStrategy =
                new TransactionsStrategyImpl(stringTransactionHandlerMap);
        CsvFileReaderService fileReaderService =
                new CsvFileReaderServiceImpl();
        DataParserService parserService =
                new DataParserServiceImpl(transactionsStrategy);
        OperationProcessingStrategy operationProcessingStrategy =
                new OperationProcessingStrategyImpl(operationProcessingMap);
        DataHandlerService dataHandlerService =
                new DataHandlerServiceImpl(operationProcessingStrategy);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        reportGeneratorService.generate("src/main/resources/report.csv");

        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        dataHandlerService.handleData(parserService
                .parse(fileReaderService.read("src/main/resources/operations.csv")));
        System.out.println(fruitsDao.getFruitsAndQuantityAsMap());
        fileWriter.write(fruitsDao.getFruitsAndQuantityAsMap(), "src/main/resources/report.csv");
    }
}
