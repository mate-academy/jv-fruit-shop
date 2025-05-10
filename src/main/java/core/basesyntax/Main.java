package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.FileReaderServiceCsvImpl;
import core.basesyntax.service.impl.FileWriterServiceCsvImpl;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationStrategies = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao)
        );
        FileReaderService fileReader = new FileReaderServiceCsvImpl();
        List<String> readDataList = fileReader.readData(INPUT_FILE_PATH);
        ParserServiceImpl parserService = new ParserServiceImpl();
        List<FruitTransaction> transactions = parserService.parse(readDataList);
        OperationProcessor operationProcessor = new OperationProcessorImpl(operationStrategies);
        operationProcessor.process(transactions);
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String reportString = reportCreatorService.create();
        FileWriterService fileWriterService = new FileWriterServiceCsvImpl();
        fileWriterService.writeData(OUTPUT_FILE_PATH, reportString);
    }
}
