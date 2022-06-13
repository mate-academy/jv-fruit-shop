package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.CsvParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.AdditionOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.SubtractionOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new AdditionOperationHandler());
        operationHandlerMap.put("s", new AdditionOperationHandler());
        operationHandlerMap.put("p", new SubtractionOperationHandler());
        operationHandlerMap.put("r", new AdditionOperationHandler());

        ReaderService reader = new ReaderServiceImpl();
        List<String> lines = reader.readFromFile(INPUT_FILE_PATH);

        CsvParserService<FruitTransaction> csvParserService = new CsvParserServiceImpl();

        for (int i = 1; i < lines.size(); i++) {
            FruitTransaction transaction = csvParserService.parse(lines.get(i));
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }

        String report = new ReportServiceImpl().createReport();
        new WriterServiceImpl().writeToFile(OUTPUT_FILE_PATH, report);

    }

}
