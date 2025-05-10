package core.basesyntax;

import core.basesyntax.dao.FileReaderCsvImpl;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.dao.FruitFileReader;
import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operationhandler.BalanceOperation;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperation;
import core.basesyntax.service.operationhandler.ReturnOperation;
import core.basesyntax.service.operationhandler.SupplyOperation;
import core.basesyntax.service.parser.ParseFruitData;
import core.basesyntax.service.parser.ParseFruitDataImpl;
import core.basesyntax.service.reportgenerator.ReportGenerator;
import core.basesyntax.service.reportgenerator.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/FruitInput.csv";
    private static final String OUTPUT_FILE = "src/main/resources/OutputReport.csv";

    public static void main(String[] args) {
        FruitFileReader fileReader = new FileReaderCsvImpl();
        List<String> fileInput = fileReader.read(INPUT_FILE);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ParseFruitData parseFruitData = new ParseFruitDataImpl();
        List<FruitTransaction> parsedData = parseFruitData.parseData(fileInput);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(parsedData);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generateReport();

        FruitFileWriter fruitFileWriter = new FileWriterImpl();
        fruitFileWriter.write(report, OUTPUT_FILE);
    }
}
