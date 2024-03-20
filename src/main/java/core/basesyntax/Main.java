package core.basesyntax;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FruitShopFileWriter;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.impl.CvsFileReader;
import core.basesyntax.services.impl.CvsFruitShopFileWriter;
import core.basesyntax.services.impl.FruitDataParser;
import core.basesyntax.services.impl.FruitInventoryService;
import core.basesyntax.services.impl.FruitShopReportGenerator;
import core.basesyntax.services.operations.BalanceOperationHandler;
import core.basesyntax.services.operations.FruitOperationStrategy;
import core.basesyntax.services.operations.OperationHandler;
import core.basesyntax.services.operations.PurchaseOperationHandler;
import core.basesyntax.services.operations.ReturnOperationHandler;
import core.basesyntax.services.operations.SupplyOperationHandler;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/TestCSV.csv";
        FileReader fileReader = new CvsFileReader();
        List<String> data = fileReader.readFile(path);
        FruitDataParser parser = new FruitDataParser();
        List<FruitTransactionDto> dtos = parser.parse(data);
        OperationHandler balance = new BalanceOperationHandler();
        OperationHandler purchase = new PurchaseOperationHandler();
        OperationHandler supply = new SupplyOperationHandler();
        OperationHandler returnHandler = new ReturnOperationHandler();
        List<OperationHandler> handlers = List.of(returnHandler, supply, balance, purchase);
        FruitOperationStrategy strategy = new FruitOperationStrategy(handlers);
        FruitInventoryService service = new FruitInventoryService(strategy);
        service.conductActivities(dtos);
        ReportGenerator generator = new FruitShopReportGenerator();
        String report = generator.generateReport();
        String newFilePath = "src/main/resources/NewCSV.csv";
        FruitShopFileWriter writer = new CvsFruitShopFileWriter();
        writer.write(report, newFilePath);
    }
}
