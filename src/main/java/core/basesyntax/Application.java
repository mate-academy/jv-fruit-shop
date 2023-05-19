package core.basesyntax;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.QuantityCalculatorService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.QuantityCalculatorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import java.util.List;

public class Application {
    private static final String VALID_READ_FROM_FILE =
            "src/main/resources/ValidReadFromFile.csv";
    private static final String WRITE_TO_FILE =
            "src/main/resources/WriteToFile.csv";

    public static void main(String[] args) {
        QuantityCalculatorService quantityCalculator = new QuantityCalculatorServiceImpl(
                new OperationHandlerStrategyImpl());
        FruitDao fruitDao = new FruitDaoImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        List<FruitTransaction> fruitTransactions =
                new TransactionParserServiceImpl()
                        .getTransactions(new CsvFileReaderServiceImpl()
                                .readFormFile(VALID_READ_FROM_FILE));
        fruitDao.addDataToStorage(quantityCalculator.calculate(fruitTransactions));
        csvFileWriterService.writeToFile(WRITE_TO_FILE);
    }
}
