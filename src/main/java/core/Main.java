/*package core;

import core.model.FruitTransaction;
import core.service.FileReaderService;
import core.service.FileWriterService;
import core.service.FruitShopService;
import core.service.ReportService;
import core.service.TransactionParser;
import core.service.impl.FileReaderServiceImp;
import core.service.impl.FileWriterServiceImpl;
import core.service.impl.FruitShopServiceImpl;
import core.service.impl.ReportServiceImpl;
import core.service.impl.TransactionParserImpl;
import core.service.operation.BalanceOperationHandlerImpl;
import core.service.operation.OperationHandler;
import core.service.operation.PurchaseOperationHandlerImpl;
import core.service.operation.ReturnOperationHandlerImpl;
import core.service.operation.SupplyOperationHandlerImpl;
import core.strategy.OperationStrategy;
import core.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        *//*String, String[], List<String> fileContent = fileReaderImpl.read(filePath);
        List<FruitTransaction> transactionList = transactionParser.parse(fileContent);
        fruitTransactionService.applyTransaction(transactionList);
        String report = reportServiceImpl.generate();
        writer.write(report, filePath);*//*
        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap =
        new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
        new BalanceOperationHandlerImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
        new PurchaseOperationHandlerImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
        new SupplyOperationHandlerImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
         new ReturnOperationHandlerImpl());

        FileReaderService readerService = new FileReaderServiceImp();
        List<String> data = readerService.read("src/main/resources/data.csv");
        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parseData(data);
        OperationStrategy operationStrategy =
        new OperationStrategyImpl(operationOperationHandlerMap);
        FruitShopService service = new FruitShopServiceImpl(operationStrategy);
        service.processTransactions(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, "report.csv");
    }
}*/
