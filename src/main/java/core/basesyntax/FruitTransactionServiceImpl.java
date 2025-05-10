package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitsTransactionStrategy;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    public static final int TRANSACTION_TYPE_INDEX = 0;
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private final FruitsTransactionStrategy fruitsTransactionStrategy;

    public FruitTransactionServiceImpl(
            FruitsTransactionStrategy fruitsTransactionStrategy
    ) {
        this.fruitsTransactionStrategy = fruitsTransactionStrategy;
    }

    @Override
    public List<String[]> getTransactions(String fileToReadPath) {
        List<String> transactionsData = new ReaderServiceImpl().readFromFile(fileToReadPath);
        return transactionsData.subList(1, transactionsData.size())
                .stream()
                .map(s -> s.split(","))
                .toList();
    }

    @Override
    public Fruit makeFruit(String[] transactionValues) {
        return new Fruit(
                transactionValues[FRUIT_NAME_INDEX],
                Integer.parseInt(transactionValues[FRUIT_QUANTITY_INDEX])
        );
    }

    public void handleTransaction(Fruit fruit, String transactionType) {
        Map<String, Fruit> fruitsData = Storage.getFruits();
        fruitsTransactionStrategy
                .fruitHandler(transactionType)
                .transactionHandler(fruitsData, fruit);
    }

    @Override
    public String getReport(Map<String, Fruit> fruits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER).append(System.lineSeparator());
        for (Fruit fruit : fruits.values()) {
            String string = fruit.getFruit() + "," + fruit.getQuantity();
            stringBuilder.append(string).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public void writeReportToFile(String fileToWritePath, String report) {
        new WriterServiceImpl().writeToFile(report, fileToWritePath);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
