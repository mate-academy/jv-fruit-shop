package core.basesyntax;

import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE = "src/main/resources/Transactions.csv";
    private static final String PATH_FOR_RESULT = "src/main/resources/Result.csv";

    public static void main(String[] args) {

        FileReaderImpl fileReaderImpl = new FileReaderImpl();
        List<FruitTransaction> fruitTransactionList = fileReaderImpl.readFromFile(PATH_TO_FILE);
        fruitTransactionList.forEach(t -> new OperationStrategyImpl()
                .get(t.getOperation()).handle(t));
        FileWriterImpl fileWriterImpl = new FileWriterImpl(PATH_FOR_RESULT);
        fileWriterImpl.writeToFile();

    }
}


