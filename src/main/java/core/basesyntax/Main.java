package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.CalculatorImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import java.util.List;

public class Main {
    private static final String VALID_READ_FROM_FILE =
            "src/main/resources/ValidInputTestData1.csv";
    private static final String WRITE_TO_FILE =
            "src/main/resources/ValidOutputTestResult1.csv";

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions = new TransactionParserImpl()
                .getTransactions(new FileReaderImpl()
                        .readDataFormFile(VALID_READ_FROM_FILE));

        new CalculatorImpl(new OperationHandlerStrategyImpl())
                .calculate(fruitTransactions);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeDataToFile(WRITE_TO_FILE);
    }
}
