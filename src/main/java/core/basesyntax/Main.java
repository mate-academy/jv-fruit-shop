package core.basesyntax;

import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.FruitTransactionGenerator;
import core.basesyntax.service.impl.FruitTransactionGeneratorImpl;
import core.basesyntax.service.impl.ReportCreator;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE = "src/main/resources/Transactions.csv";
    private static final String PATH_FOR_RESULT = "src/main/resources/Result.csv";

    public static void main(String[] args) {

        FileReaderImpl fileReaderImpl = new FileReaderImpl();
        FruitTransactionGenerator generator = new FruitTransactionGeneratorImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FileWriterImpl fileWriterImpl = new FileWriterImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String[]> dataFromFile = fileReaderImpl.readFromFile(PATH_TO_FILE);
        List<FruitTransaction> fruitTransactionList = generator
                .createFruitTransaction(dataFromFile);
        fruitTransactionList.forEach(ft -> operationStrategy.get(ft.getOperation()).handle(ft));
        String report = reportCreator.createReport();
        fileWriterImpl.writeToFile(PATH_FOR_RESULT, report);
    }
}


