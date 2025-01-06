package core.basesyntax;

import converted.Converter;
import converted.ConverterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operation.handler.BalanceOperation;
import operation.handler.OperationHandler;
import operation.handler.PurchaseOperation;
import operation.handler.ReturnOperation;
import operation.handler.SupplyOperation;
import operation.strategy.OperationStrategy;
import operation.strategy.OperationStrategyImpl;
import reader.FileReader;
import reader.FileReaderImpl;
import report.Report;
import report.ReportImpl;
import service.ShopService;
import service.ShopServiceImpl;
import transaction.FruitTransaction;
import writer.Writer;
import writer.WriterImpl;

public class HelloWorld {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> input = fileReader.read("/Users/promaksua/Downloads/Book");

        Converter dataConverter = new ConverterImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        List<FruitTransaction> transactions = dataConverter.converterToTransaction(input);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        Report report = new ReportImpl();
        String result = report.getReport(shopService.getStorage());

        Writer writer = new WriterImpl();
        writer.writeDate(result, "/Users/promaksua/Downloads/Book2");
    }
}
