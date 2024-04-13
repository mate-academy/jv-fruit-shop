package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitsTransactionStrategy;
import java.util.ArrayList;
import java.util.List;

public class FruitTransaction implements FruitTransactionService {
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();
    private final FruitsTransactionStrategy fruitsTransactionStrategy;
    private final String fileToReadPath;
    private final String fileToWritePath;

    public FruitTransaction(
            FruitsTransactionStrategy fruitsTransactionStrategy,
            String fileToReadPath,
            String fileToWritePath
    ) {
        this.fruitsTransactionStrategy = fruitsTransactionStrategy;
        this.fileToReadPath = fileToReadPath;
        this.fileToWritePath = fileToWritePath;
    }

    public void handleTransactions() {
        List<String> transactionsData = readerService.readFromFile(fileToReadPath);
        List<String[]> transactionsOnly = transactionsData.subList(1, transactionsData.size())
                .stream()
                .map(s -> s.split(","))
                .toList();
        for (String[] transactionParts : transactionsOnly) {
            fruitsTransactionStrategy
                    .fruitHandler(transactionParts[0])
                    .transactionHandler(transactionParts);
        }
    }

    @Override
    public void writeReportToFile() {
        List<String> stringsToReport = new ArrayList<>();
        stringsToReport.add("fruit,quantity");
        for (Fruit fruit : Storage.getFruits().values()) {
            String string = fruit.getFruit() + "," + fruit.getQuantity();
            stringsToReport.add(string);
        }
        writerService.writeToFile(stringsToReport, fileToWritePath);
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
