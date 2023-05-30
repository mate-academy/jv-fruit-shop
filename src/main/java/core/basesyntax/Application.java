package core.basesyntax;

import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.QuantityCalculatorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public class Application {
    private static final String VALID_READ_FROM_FILE =
            "src/main/resources/DatabaseOfShop.csv";
    private static final String WRITE_TO_FILE =
            "src/main/resources/ResultDB.csv";

    public static void main(String[] args) {
        List<String> linesFormFile = new CsvFileReaderServiceImpl()
                .readFormFile(VALID_READ_FROM_FILE);

        List<FruitTransaction> fruitTransactions = new TransactionParserServiceImpl()
                .getTransactions(linesFormFile);

        new QuantityCalculatorServiceImpl(new OperationHandlerStrategyImpl())
                .calculate(fruitTransactions);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeToFile(WRITE_TO_FILE);
    }
}
