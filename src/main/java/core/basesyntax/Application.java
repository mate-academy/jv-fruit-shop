package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitQuantityCalculatorImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import java.util.List;

public class Application {
    private static final String VALID_DATA_FILE_PATH = "src/main/resources/ValidData";
    private static final String RESULT_FILE_PATH = "src/main/resources/WriteToFile";

    public static void main(String[] args) {
        List<String> dataFromFile = new FileReaderServiceImpl().readFromFile(VALID_DATA_FILE_PATH);

        List<FruitTransaction> fruitsTransaction = new FruitTransactionParserServiceImpl()
                .parseToFruitTransaction(dataFromFile);

        new FruitQuantityCalculatorImpl(new OperationHandlerStrategyImpl())
                .calculateQuantity(fruitsTransaction);

        FileWriterServiceImpl fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(RESULT_FILE_PATH);
    }
}
