package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("b", new BalanceOperationHandler());

        ReaderService reader = new ReaderServiceImpl();
        List<String> lines = reader.readFromFile("");

        ParserService<TransactionDto> parserService =
                new ParserServiceImpl(new ValidatorServiceImpl());

        lines.stream()
                .map(parserService::parseLine)
                .forEach(t -> operationHandlerMap.get(t.getOperation()).apply(t));

        String report = new ReportServiceImpl().formReport();
        new WriterServiceImpl().writeToFile("", report);
    }
}
