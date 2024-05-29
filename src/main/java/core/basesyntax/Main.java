package core.basesyntax;

import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.reader.CsvFileReader;
import core.basesyntax.reader.CsvFileReaderImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operationhandlers.BalanceOperationHandler;
import core.basesyntax.service.operationhandlers.OperationHandler;
import core.basesyntax.service.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.service.operationhandlers.ReturnOperationHandler;
import core.basesyntax.service.operationhandlers.SupplyOperationHandler;
import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.operationstrategy.OperationStrategyImpl;
import core.basesyntax.writer.CsvWriter;
import core.basesyntax.writer.CsvWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReader fileReader = new CsvFileReaderImpl();
        List<String> inputReport = fileReader.readFromCsv("src/main/java/core"
                + "/basesyntax/reportToRead.csv");

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convert(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(shopService);
        String resultingReport = reportGenerator.getReport();

        CsvWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeToCsv(resultingReport, "finalReport.csv");
    }
}
