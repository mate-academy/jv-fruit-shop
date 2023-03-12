package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.DataTransactionParserImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.operation.impl.WarehouseOperationStrategyImpl;
import java.util.List;

public class Main {
    private static String fromFile = "src/main/resources/input.csv";
    private static String toFile = "src/main/resources/output.csv";

    public static void main(String[] args) {
        DataTransactionParser dataTransactionParser =
                new DataTransactionParserImpl();
        ReportGeneratorServiceImpl reportGeneratorService = new ReportGeneratorServiceImpl();
        FruitService fruitService = new FruitServiceImpl(new WarehouseOperationStrategyImpl());
        FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
        String data = fileReaderService.read(fromFile);
        List<FruitTransaction> fruitTransactions = dataTransactionParser.parseDataTransaction(data);
        fruitService.applyFruitTransactions(fruitTransactions);
        String report = reportGeneratorService.generateReport(Storage.FRUIT_STORAGE);
        fruitService.createResultFile(report, toFile);
    }
}

