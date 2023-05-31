package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvDataParserService;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.FruitTransactionStrategy;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.CsvDataParserServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.strategy.BalanceTransactionHandler;
import core.basesyntax.service.strategy.PurchaseTransactionHandler;
import core.basesyntax.service.strategy.ReturnTransactionHandler;
import core.basesyntax.service.strategy.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> lines = csvFileReaderService.readLinesFromFile(INPUT_FILE_PATH);
        CsvDataParserService csvDataParserService = new CsvDataParserServiceImpl();
        List<FruitTransaction> fruitTransactions = csvDataParserService.parseData(lines);
        Map<FruitTransaction.Operation, FruitTransactionHandler> handlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler(),
                FruitTransaction.Operation.RETURN, new ReturnTransactionHandler()

        );
        Map<String, Integer> storageMap = new HashMap<>();
        Storage storage = new Storage(storageMap);
        FruitTransactionStrategy fruitTransactionStrategy =
                new FruitTransactionStrategyImpl(handlerMap, storage);
        fruitTransactions.forEach(fruitTransactionStrategy::handle);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        String report = reportGeneratorService.generate(storage);
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.writeReport(report, OUTPUT_FILE_PATH);
    }
}

