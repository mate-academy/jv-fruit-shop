package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.imps.FruitServiceImp;
import core.basesyntax.services.imps.ParserServiceImp;
import core.basesyntax.services.imps.ReaderServiceImp;
import core.basesyntax.services.imps.ReportServiceImp;
import core.basesyntax.services.imps.WriterServiceImp;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH = "src\\main\\resources\\source_file.csv";
    private static final String REPORT_FILE_PATH = "src\\main\\resources\\report_file.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        new OperationStrategy(operationHandlerMap);
        List<FruitTransaction> transactions = new ParserServiceImp()
                .parse(new ReaderServiceImp().readFromFile(SOURCE_FILE_PATH));
        new FruitServiceImp()
                .store(transactions, operationHandlerMap);
        new WriterServiceImp()
                .writeToFile(REPORT_FILE_PATH, new ReportServiceImp().createReportString());
    }
}
