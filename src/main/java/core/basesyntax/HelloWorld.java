package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.reader.FileReaderImpl;
import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.file.writer.FileWriterImpl;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceOperationHandler;
import core.basesyntax.handler.impl.PurchaseOperationHandler;
import core.basesyntax.handler.impl.ReturnOperationHandler;
import core.basesyntax.handler.impl.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputData = fileReader.read("src/main/resources/reportToRead.csv");

        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "src/main/resources/finalReport.csv");
    }
}


