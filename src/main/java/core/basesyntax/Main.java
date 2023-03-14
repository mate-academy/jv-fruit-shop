package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopReportService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.implementation.CsvFileReaderServiceImpl;
import core.basesyntax.service.implementation.CsvFileWriterServiceImpl;
import core.basesyntax.service.implementation.FruitShopReportServiceImpl;
import core.basesyntax.service.implementation.FruitTransactionServiceImpl;
import core.basesyntax.service.implementation.OperationStrategyServiceImpl;
import java.util.List;

public class Main {

    private static final String INPUT_FILE_PATH = "src/main/resources/testInput.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/testOutput.csv";

    public static void main(String[] args) {
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> inputLines = readerService.readFrom(INPUT_FILE_PATH);
        OperationStrategyService operationStrategyService = new OperationStrategyServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        for (String inputLine : inputLines) {
            FruitTransaction fruitTransaction = fruitTransactionService
                    .createFruitTransaction(inputLine);
            operationStrategyService.applyOperationStrategy(fruitTransaction);
        }
        FruitShopReportService reportService = new FruitShopReportServiceImpl();
        String report = reportService.createReport();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.write(report, OUTPUT_FILE_PATH);
    }
}
