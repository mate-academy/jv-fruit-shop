package core.basesyntax;

import core.basesyntax.db.DaoService;
import core.basesyntax.db.DaoServiceHashMap;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.MapperService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.MapperServiceTransaction;
import core.basesyntax.service.impl.ReaderServiceCsv;
import core.basesyntax.service.impl.ReportServiceCsv;
import core.basesyntax.service.impl.StrategyApplier;
import core.basesyntax.service.impl.StrategySelector;
import core.basesyntax.service.impl.WriterServiceCsv;
import core.basesyntax.strategy.SaveStrategy;
import core.basesyntax.strategy.impl.SaveStrategyBalance;
import core.basesyntax.strategy.impl.SaveStrategyPurchase;
import core.basesyntax.strategy.impl.SaveStrategyReturn;
import core.basesyntax.strategy.impl.SaveStrategySupply;
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
    private static final DaoService<String, Integer> STORAGE;
    private static final Map<Operation, SaveStrategy> STRATEGY_FOR_OPERATION =
            new HashMap<>();

    static {
        STORAGE = new DaoServiceHashMap<>();
        STRATEGY_FOR_OPERATION.put(Operation.SUPPLY, new SaveStrategySupply(STORAGE));
        STRATEGY_FOR_OPERATION.put(Operation.PURCHASE, new SaveStrategyPurchase(STORAGE));
        STRATEGY_FOR_OPERATION.put(Operation.BALANCE, new SaveStrategyBalance(STORAGE));
        STRATEGY_FOR_OPERATION.put(Operation.RETURN, new SaveStrategyReturn(STORAGE));
        HEADER = "fruit" + CSV_SEPARATOR + "quantity";
    }

    public static void main(String[] args) {
        final ReaderService<File, String> readerService = new ReaderServiceCsv();
        final List<String> lines = readerService.readLines(new File(FILE_SOURCE));
        lines.remove(0); //removing the header
        final MapperService<String, FruitTransaction> mapperService = new MapperServiceTransaction(
                OPERATION_CODE_COLUMN,
                FRUIT_COLUMN,
                AMOUNT_COLUMN,
                CSV_SEPARATOR
        );
        final List<FruitTransaction> mappedTransactions = mapperService.mapAll(lines);
        final StrategySelector strategySelector = new StrategySelector(STRATEGY_FOR_OPERATION);
        final StrategyApplier strategyApplier = new StrategyApplier(strategySelector);
        strategyApplier.applyAll(mappedTransactions);
        final ReportService reportService = new ReportServiceCsv(HEADER, CSV_SEPARATOR);
        final WriterService writerService = new WriterServiceCsv();
        writerService.writeLines(reportService.generateReport(STORAGE), new File(FILE_TARGET));
    }
}
