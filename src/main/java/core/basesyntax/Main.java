package core.basesyntax;

import converter.DataConverter;
import converter.DataConverterImpl;
import handler.BalanceOperationHandler;
import handler.OperationHandler;
import handler.PurchaseOperationHandler;
import handler.ReturnOperationHandler;
import handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;
import manager.FruitShopManager;
import model.FruitTransaction;
import read.write.file.FileReader;
import read.write.file.FileReaderImpl;
import read.write.file.FileWriter;
import read.write.file.FileWriterImpl;
import report.ReportGenerator;
import report.ReportGeneratorImpl;
import service.ShopService;
import service.impl.ShopServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "src/finalReport.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        Map<String, Integer> storage = new HashMap<>();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storage),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storage),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storage),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storage)
        );
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        FileWriter fileWriter = new FileWriterImpl();
        FruitShopManager manager = new FruitShopManager(fileReader,
                dataConverter, shopService,
                reportGenerator, fileWriter,
                INPUT_FILE_PATH, OUTPUT_FILE_PATH);
        manager.manageShop();
    }
}
