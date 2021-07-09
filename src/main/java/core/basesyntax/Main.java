package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileValidator;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.Validator;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new AddOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new AddOperationHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> list = fileReaderService.readFromFile(INPUT_FILE);

        Validator validator = new FileValidator();
        Parser parser = new ParserImpl();

        for (int i = 1; i < list.size(); i++) {
            validator.validate(list.get(i));
            Transaction transaction = parser.parse(list.get(i));
            OperationHandler handler = map.get(transaction.getOperation());
            handler.apply(transaction);
        }

        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(reportService.getReport(), OUTPUT_FILE);
    }
}
