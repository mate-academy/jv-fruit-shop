package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserFromFile;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.ParserFromFileImpl;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
import core.basesyntax.stategy.AddOperationHandlerImpl;
import core.basesyntax.stategy.OperationHandler;
import core.basesyntax.stategy.PurchaseOperationHandlerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ReaderFromFile reader = new ReaderFromFileImpl();
        ParserFromFile<TransactionDto> parserFromFile = new ParserFromFileImpl(new ValidatorImpl());
        List<String> lines = reader.getData("test.CSV");
        List<TransactionDto> transactionDto = new ArrayList<>();
        for (String line : lines) {
            transactionDto.add(parserFromFile.parseLine(line));
        }
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new AddOperationHandlerImpl());
        operationHandlerMap.put("s", new AddOperationHandlerImpl());
        operationHandlerMap.put("r", new AddOperationHandlerImpl());
        operationHandlerMap.put("p", new PurchaseOperationHandlerImpl());
        for (TransactionDto transaction : transactionDto) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        WriterToFile file = new WriterToFileImpl();
        file.writeDataToFile("result.CSV");

    }
}
