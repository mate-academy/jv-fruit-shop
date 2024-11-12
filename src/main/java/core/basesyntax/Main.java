package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operationHandler.*;
import core.basesyntax.services.reportGenerator.IReportGenerator;
import core.basesyntax.services.reportGenerator.ReportGenerator;
import core.basesyntax.services.shopService.IShopService;
import core.basesyntax.services.shopService.ShopService;
import core.basesyntax.strategies.IOperationStrategy;
import core.basesyntax.strategies.OperationStrategy;
import core.basesyntax.utils.dataConverter.DataConverter;
import core.basesyntax.utils.dataConverter.IDataConverter;
import core.basesyntax.utils.fileReader.FileReader;
import core.basesyntax.utils.fileReader.IFileReader;
import core.basesyntax.utils.filesWriter.FileWriter;
import core.basesyntax.utils.filesWriter.IFileWriter;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IFileReader fileReader = new FileReader();
        IDataConverter dataConverter = new DataConverter();

        List<String> transactionsStrings = fileReader.readCSVFile(Paths.get("inputFile.csv"));
        List<FruitTransaction> fruitTransactions = dataConverter.toFruitTransactions(transactionsStrings);

        Map<FruitTransaction.Operation, IOperationHandler> operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        IOperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);

        IShopService shopService = new ShopService(operationStrategy);
        shopService.process(fruitTransactions);

        IReportGenerator reportGenerator = new ReportGenerator();
        String report = reportGenerator.getReport();

        IFileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(Paths.get("outputFile.csv"), report.getBytes());
    }
}
