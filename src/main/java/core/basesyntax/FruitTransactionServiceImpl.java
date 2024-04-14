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
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final int TRANSACTION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private final FruitsTransactionStrategy fruitsTransactionStrategy;

    public FruitTransactionServiceImpl(
            FruitsTransactionStrategy fruitsTransactionStrategy
    ) {
        this.fruitsTransactionStrategy = fruitsTransactionStrategy;
    }

    public void handleTransactions(String fileToReadPath) {
        List<String> transactionsData = new ReaderServiceImpl().readFromFile(fileToReadPath);
        List<String[]> transactionsOnly = transactionsData.subList(1, transactionsData.size())
                .stream()
                .map(s -> s.split(","))
                .toList();
        Map<String, Fruit> fruitsData = Storage.getFruits();
        for (String[] transactionParts : transactionsOnly) {
            String fruitName = transactionParts[FRUIT_NAME_INDEX];
            int fruitQuantity = Integer.parseInt(transactionParts[FRUIT_QUANTITY_INDEX]);
            fruitsTransactionStrategy
                    .fruitHandler(transactionParts[TRANSACTION_TYPE_INDEX])
                    .transactionHandler(fruitsData, fruitName, fruitQuantity);
        }
    }

    @Override
    public void writeReportToFile(String fileToWritePath) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER).append(System.lineSeparator());
        for (Fruit fruit : Storage.getFruits().values()) {
            String string = fruit.getFruit() + "," + fruit.getQuantity();
            stringBuilder.append(string).append(System.lineSeparator());
        }
        new WriterServiceImpl().writeToFile(stringBuilder.toString(), fileToWritePath);
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
