package core.basesyntax;

import core.basesyntax.db.BalanceStorage;
import core.basesyntax.db.Dao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.*;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.Reader;
import core.basesyntax.strategy.SaveStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyBalance;
import core.basesyntax.strategy.impl.TransactionStrategyPurchase;
import core.basesyntax.strategy.impl.TransactionStrategyReturn;
import core.basesyntax.strategy.impl.TransactionStrategySupply;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_SOURCE = "src/main/resources/transaction/transaction.csv";
    private static final String FILE_TARGET = "src/main/resources/report/report.csv";
    private static final int OPERATION_CODE_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int AMOUNT_COLUMN = 2;
    private static final String CSV_STRING_SEPARATOR = ",";
    public static final String HEADER;
    private static final Map<FruitTransaction.Operation, SaveStrategy> STRATEGIES_FOR_OPERATIONS = new HashMap<>();

    static {
        STRATEGIES_FOR_OPERATIONS.put(FruitTransaction.Operation.SUPPLY, new TransactionStrategySupply());
        STRATEGIES_FOR_OPERATIONS.put(FruitTransaction.Operation.PURCHASE, new TransactionStrategyPurchase());
        STRATEGIES_FOR_OPERATIONS.put(FruitTransaction.Operation.BALANCE, new TransactionStrategyBalance());
        STRATEGIES_FOR_OPERATIONS.put(FruitTransaction.Operation.RETURN, new TransactionStrategyReturn());
        HEADER = "fruit" + CSV_STRING_SEPARATOR + "quantity";
    }
    public static void main(String[] args) {
        final Reader<File, String> reader = new CsvReader();
        final List<String> lines = reader.readLines(new File(FILE_SOURCE));
        lines.remove(0); //removing the header
        final Mapper<String, FruitTransaction> mapper = new CsvToFruitTransactionMapper(
                OPERATION_CODE_COLUMN,
                FRUIT_COLUMN,
                AMOUNT_COLUMN,
                CSV_STRING_SEPARATOR
        );
        final List<FruitTransaction> mappedTransactions = mapper.mapAll(lines);
        final Dao<String, Integer> storage = new BalanceStorage<>();
        final StrategySelector strategySelector = new StrategySelector(STRATEGIES_FOR_OPERATIONS);
        final StrategyApplier strategyApplier = new StrategyApplier(strategySelector);
        strategyApplier.applyAll(mappedTransactions, storage);
        final ReportGenerator reportGenerator = new CsvReportGenerator(HEADER, CSV_STRING_SEPARATOR);
        final Writer writer = new CsvWrighter();
        writer.writeLines(reportGenerator.generateReport(storage), new File(FILE_TARGET));
    }


}