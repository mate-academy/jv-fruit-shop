package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FileValidator;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FileWriterServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Report;
import core.basesyntax.service.ReportImpl;
import core.basesyntax.service.Validator;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "input_file.csv";
    private static final String OUTPUT_FILE = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperationHandler());
        map.put("s", new AddOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new AddOperationHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> list = fileReaderService.readFromFile(INPUT_FILE);

        Validator validator = new FileValidator();
        validator.validate(list);

        List<Transaction> transactions = new ArrayList<>();
        Parser parser = new ParserImpl();
        for (int i = 1; i < list.size(); i++) {
            transactions.add(parser.parse(list.get(i)));
        }

        for (Transaction transaction : transactions) {
            OperationHandler handler = map.get(transaction.getOperation());
            handler.apply(transaction);
        }

        Report report = new ReportImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report.getReport(), OUTPUT_FILE);
    }
}
