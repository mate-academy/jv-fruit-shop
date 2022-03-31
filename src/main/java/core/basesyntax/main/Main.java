package core.basesyntax.main;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/resources/input.csv";
    private static final String TO_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> data = csvFileReaderService.readFromFile(FROM_FILE_PATH);
        Parser<FruitTransaction> parser = new ParserImpl(new ValidatorImpl());
        List<FruitTransaction> fruitTransactions = parser.parse(data);
        Strategy strategy = new StrategyImpl();

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            String operation = fruitTransaction.getOperation();
            OperationHandler operationHandler = strategy.get(operation);
            operationHandler.apply(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
        StringBuilder report = new ReportServiceImpl().makeReport();
        new CsvFileWriterServiceImpl().writeToFile(TO_FILE_PATH, report);
    }
}
