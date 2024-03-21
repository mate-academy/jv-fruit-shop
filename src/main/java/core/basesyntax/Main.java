package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.PurchaseOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.parser.DataParserImpl;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStategy;
import core.basesyntax.strategy.TransationProcessor;
import core.basesyntax.strategy.TransationProcessorImpl;
import core.basesyntax.strategy.impl.OperationStategyImpl;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/fileData.csv";

    public static void main(String[] args) {
        Storage storage = new Storage();
        FruitService fruitService = new FruitServiceImpl(storage);
        BalanceOperationHandler balanceOperationHandler =
                new BalanceOperationHandler(fruitService);
        PurchaseOperationHandler purchaseOperationHandler =
                new PurchaseOperationHandler(storage,fruitService);
        ReturnOperationHandler returnOperationHandler =
                new ReturnOperationHandler(storage,fruitService);
        SupplyOperationHandler supplyOperationHandler =
                new SupplyOperationHandler(storage,fruitService);
        Map<Operation, OperationHandler> operationStrategyMap =
                Map.of(Operation.BALANCE, balanceOperationHandler,
                Operation.PURCHASE, purchaseOperationHandler,
                Operation.SUPPLY, supplyOperationHandler,
                Operation.RETURN, returnOperationHandler);
        OperationStategy operationStategy = new OperationStategyImpl(operationStrategyMap);

        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> rawData = fileReader.readFile(FILE_PATH);
        DataParser dataParser = new DataParserImpl();
        List<FruitTransactionDto> dtos = dataParser.parse(rawData);
        TransationProcessor processor = new TransationProcessorImpl(operationStategy);
        processor.process(dtos);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        List<String> report = reportGenerator.generate();
        File outputFile = Paths.get("src/main/resources/report.csv").toFile();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report,outputFile);
    }
}
