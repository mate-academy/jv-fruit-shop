package core.basesyntax;

import core.basesyntax.model.TransactionLine;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReaderFile;
import core.basesyntax.service.WriteFile;
import core.basesyntax.service.impl.OperationHandlerStrategyImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderFileImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.WriteFileImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalansOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.SubtractOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILENAME = "src/main/resources/input.csv";
    public static final String REPORT_FILENAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderFile readerService = new ReaderFileImpl();
        // читаємо файл в колекцію
        List<String> listFromFile = readerService.readFromFile(INPUT_FILENAME);
        //  парсимо прочитані дані
        //  в класі ParseImpl відкидаємо перший титульний рядок, валідуємо, парсимо і отримуємо
        //  ArrayList обєктів TransactionLine (String, String, int)
        Parser parserImpl = new ParserImpl();
        // паттерн стратегія
        // на виході маємо заповнену мапу де ключ це Fruit а value - порахована кількість фруктів
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalansOperationHandler());
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new SubtractOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(operationHandlerMap);
        List<TransactionLine> transactionLines = parserImpl.parser(listFromFile);
        for (TransactionLine transactionLine : transactionLines) {
            OperationHandler operationHandler = operationHandlerStrategy.get(transactionLine);
            operationHandler.operation(transactionLine);
        }
        // формуємо лист рядків де рядки це звіт в необхідному до умови форматі
        List<String> reportList = new ReportImpl().createReport();
        // записуємо звіт у файл
        WriteFile writeService = new WriteFileImpl();
        writeService.writeToFile(reportList, REPORT_FILENAME);
    }
}
