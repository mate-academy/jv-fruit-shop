package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.MyRider;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.MyRiderImpl;
import core.basesyntax.service.impl.MyWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        MyRider reader = new MyRiderImpl();
        List<String> lines = reader.readFromFile("./src/main/resources/input.csv");
        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (String line : lines) {
            transactionDtoList.add(parser.parseTo(line));
        }
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());

        for (TransactionDto transactionDto : transactionDtoList) {
            String operation = transactionDto.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.operate(transactionDto.getFruitName(),transactionDto.getQuantity());
        }

        String report = new ReportImpl().formReport();
        new MyWriterImpl().writeToFile("./src/main/resources/report.csv",report);
    }
}
