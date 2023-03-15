package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.CommandHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler> operationStrategies
            = new CommandHandler().initHandlers();

    public static void main(String[] args) {

        ReaderService readerService = new ReaderServiceImpl();
        ParserService fruitTransactionParser = new ParserServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> records = readerService.read(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(records);

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler handler = operationStrategies
                    .get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }

        String report = reportService.createReport();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
