package core.basesyntax;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileWriter;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.impl.CvsFileWriter;
import core.basesyntax.services.impl.FruitDataParser;
import core.basesyntax.services.impl.FruitShopReportGenerator;
import core.basesyntax.services.impl.FruitTransactionProcessorImpl;
import core.basesyntax.services.impl.TextFileReader;
import core.basesyntax.services.operations.BalanceOperationHandler;
import core.basesyntax.services.operations.FruitOperationStrategy;
import core.basesyntax.services.operations.OperationHandler;
import core.basesyntax.services.operations.PurchaseOperationHandler;
import core.basesyntax.services.operations.ReturnOperationHandler;
import core.basesyntax.services.operations.SupplyOperationHandler;
import java.util.List;

public class Main {

    private static final String NEW_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        String path = "src/main/resources/input.csv";
        OperationHandler balance = new BalanceOperationHandler();
        OperationHandler purchase = new PurchaseOperationHandler();
        OperationHandler supply = new SupplyOperationHandler();
        OperationHandler returnHandler = new ReturnOperationHandler();
        List<OperationHandler> handlers = List.of(returnHandler, supply, balance, purchase);

        FileReader fileReader = new TextFileReader();
        List<String> data = fileReader.readFile(path);

        FruitDataParser parser = new FruitDataParser();
        List<FruitTransactionDto> fruitTransactions = parser.parse(data);

        FruitOperationStrategy strategy = new FruitOperationStrategy(handlers);
        FruitTransactionProcessorImpl service = new FruitTransactionProcessorImpl(strategy);

        service.process(fruitTransactions);

        ReportGenerator generator = new FruitShopReportGenerator();
        String report = generator.generateReport();

        FileWriter writer = new CvsFileWriter();
        writer.write(report, NEW_FILE_PATH);
    }
}
