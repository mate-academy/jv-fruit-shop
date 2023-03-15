package core.basesyntax;

import core.basesyntax.db.BalanceStorage;
import core.basesyntax.db.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.CsvToFruitTransactionMapper;
import core.basesyntax.service.impl.CsvWrighter;
import core.basesyntax.service.impl.StrategyApplier;
import core.basesyntax.service.impl.StrategySelector;
import core.basesyntax.strategy.SaveStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyBalance;
import core.basesyntax.strategy.impl.TransactionStrategyPurchase;
import core.basesyntax.strategy.impl.TransactionStrategyReturn;
import core.basesyntax.strategy.impl.TransactionStrategySupply;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_SOURCE =
            "src/main/resources/transaction/transaction.csv";
    private static final String FILE_TARGET =
            "src/main/resources/report/report.csv";
    private static final int OPERATION_CODE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int AMOUNT_COLUMN = 2;
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER;
    private static final Map<Operation, SaveStrategy> STRATEGY_FOR_OPERATION =
            new HashMap<>();

    static {
        STRATEGY_FOR_OPERATION.put(Operation.SUPPLY, new TransactionStrategySupply());
        STRATEGY_FOR_OPERATION.put(Operation.PURCHASE, new TransactionStrategyPurchase());
        STRATEGY_FOR_OPERATION.put(Operation.BALANCE, new TransactionStrategyBalance());
        STRATEGY_FOR_OPERATION.put(Operation.RETURN, new TransactionStrategyReturn());
        HEADER = "fruit" + CSV_SEPARATOR + "quantity";
    }

    public static void main(String[] args) {
        final Reader<File, String> reader = new CsvReader();
        final List<String> lines = reader.readLines(new File(FILE_SOURCE));
        lines.remove(0); //removing the header
        final Mapper<String, FruitTransaction> mapper = new CsvToFruitTransactionMapper(
                OPERATION_CODE_COLUMN,
                FRUIT_COLUMN,
                AMOUNT_COLUMN,
                CSV_SEPARATOR
        );
        final List<FruitTransaction> mappedTransactions = mapper.mapAll(lines);
        final Dao<String, Integer> storage = new BalanceStorage<>();
        final StrategySelector strategySelector = new StrategySelector(STRATEGY_FOR_OPERATION);
        final StrategyApplier strategyApplier = new StrategyApplier(strategySelector);
        strategyApplier.applyAll(mappedTransactions, storage);
        final ReportGenerator reportGenerator = new CsvReportGenerator(HEADER, CSV_SEPARATOR);
        final Writer writer = new CsvWrighter();
        writer.writeLines(reportGenerator.generateReport(storage), new File(FILE_TARGET));
    }
}
