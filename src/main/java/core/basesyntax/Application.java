package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.impl.CsvParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.AddOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        ValidatorService validator = new ValidatorServiceImpl();
        ParserService<TransactionDto> parser = new CsvParserServiceImpl(validator);

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("b", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());

        List<TransactionDto> transactionDtos = parser.parseLines(dataFromFile);
        for (TransactionDto transaction : transactionDtos) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }

        List<String> report = new ReportServiceImpl().createReport();
        new WriterServiceImpl().writeToFile(OUTPUT_FILE_PATH, report);

    }
}
