package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operationhandler.IOperationHandler;
import core.basesyntax.services.operationhandler.BalanceOperationHandler;
import core.basesyntax.services.operationhandler.SupplyOperationHandler;
import core.basesyntax.services.operationhandler.PurchaseOperationHandler;
import core.basesyntax.services.operationhandler.ReturnOperationHandler;
import core.basesyntax.services.reportgenerator.IReportGenerator;
import core.basesyntax.services.reportgenerator.ReportGenerator;
import core.basesyntax.services.shopservice.IShopService;
import core.basesyntax.services.shopservice.ShopService;
import core.basesyntax.strategies.IOperationStrategy;
import core.basesyntax.strategies.OperationStrategy;
import core.basesyntax.utils.dataconverter.DataConverter;
import core.basesyntax.utils.dataconverter.IDataConverter;
import core.basesyntax.utils.filereader.FileReader;
import core.basesyntax.utils.filereader.IFileReader;
import core.basesyntax.utils.fileswriter.FileWriter;
import core.basesyntax.utils.fileswriter.IFileWriter;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IFileReader fileReader = new FileReader();
        IDataConverter dataConverter = new DataConverter();

        Map<FruitTransaction.Operation, IOperationHandler> operationHandlerMap = new HashMap<>();

        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        IOperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);

        List<String> transactionsStrings = fileReader.readCSVFile(Paths.get("inputFile.csv"));
        List<FruitTransaction> fruitTransactions = dataConverter
                .toFruitTransactions(transactionsStrings);

        IShopService shopService = new ShopService(operationStrategy);
        shopService.process(fruitTransactions);

        IReportGenerator reportGenerator = new ReportGenerator();
        String report = reportGenerator.getReport();

        IFileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(Paths.get("outputFile.csv"), report.getBytes());
    }
}
