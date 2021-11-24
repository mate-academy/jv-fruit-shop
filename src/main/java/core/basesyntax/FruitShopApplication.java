package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    public void generateReport(String filePath) {
        FileReader fileReader = new FileReaderImpl();
        List<String> lines = fileReader.read(filePath);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl(validator);
        for (int i = 1; i < lines.size(); i++) {
            transactionDtos.add(parser.parse(lines.get(i)));
        }
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        for (TransactionDto transaction : transactionDtos) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.formReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, "src/main/core/basesyntax/reports/report.csv");
    }
}
