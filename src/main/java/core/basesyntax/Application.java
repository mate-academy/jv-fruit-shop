package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
import core.basesyntax.stategy.AddOperationHandlerImpl;
import core.basesyntax.stategy.OperationHandler;
import core.basesyntax.stategy.PurchaseOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_PATH = "src/main/resources/inputData.csv";
    private static final String OUTPUT_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new AddOperationHandlerImpl());
        operationHandlerMap.put("s", new AddOperationHandlerImpl());
        operationHandlerMap.put("r", new AddOperationHandlerImpl());
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl());
        ReaderFromFile reader = new ReaderFromFileImpl();
        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());
        List<String> lines = reader.getData(INPUT_PATH);
        for (int i = 1; i < lines.size(); i++) {
            TransactionDto transaction = parser.parseLine(lines.get(i));
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        WriterToFile file = new WriterToFileImpl();
        ReportService report = new ReportServiceImpl();
        file.writeData(OUTPUT_PATH, report.getReport());
    }
}
