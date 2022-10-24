package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.*;

import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_file.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_file.txt";

    public static void main(String[] args) {
        FileLinesReaderService fileLinesReaderService = new FileLinesReaderServiceImpl();
        CsvParserService<FruitTransaction> csvParserService = new CsvParserServiceImpl();
        Map<FruitTransaction.Operation, FruitShopStrategy> fruitShopStrategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceStrategy(),
                FruitTransaction.Operation.SUPPLY, new SupplyStrategy(),
                FruitTransaction.Operation.PURCHASE, new PurchaseStrategy(),
                FruitTransaction.Operation.RETURN, new ReturnStrategy()
        );
        FruitServiceImpl fruitService = new FruitServiceImpl(fruitShopStrategyMap);
        ReportService reportService = new FruitReportService();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        List<String> fileLines = fileLinesReaderService.readFile(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = csvParserService.parse(fileLines, true);
        fruitService.process(transactions);
        String report = reportService.calculateReport(Storage.getInstance().getContent());
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
