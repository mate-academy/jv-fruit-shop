package main;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import operation.OperationHandler;
import operation.impl.BalanceOperationHandlerImpl;
import operation.impl.OperationStrategyImpl;
import operation.impl.PurchaseOperationHandlerImpl;
import operation.impl.ReturnOperationHandlerImpl;
import operation.impl.SupplyOperationHandlerImpl;
import service.Parser;
import service.TransactionProcessor;
import service.impl.CsvParser;
import service.impl.ReaderServiceImpl;
import service.impl.ReportImpl;
import service.impl.TransactionProcessorImpl;
import service.impl.WriterServiceImpl;

public class Main {
    private static final String READ_FILE_NAME = "data.csv";
    private static final String WRITE_FILE_NAME = "newData.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);

        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandlerImpl());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandlerImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandlerImpl());

        ReaderServiceImpl reader = new ReaderServiceImpl();
        Parser csvParser = new CsvParser();
        TransactionProcessor transactionProcessorImpl =
                new TransactionProcessorImpl(operationStrategy);
        csvParser.parse(reader.readFromFile(READ_FILE_NAME))
                .forEach(transactionProcessorImpl::process);
        WriterServiceImpl writer = new WriterServiceImpl();
        writer.writeToFile(new ReportImpl().create(), WRITE_FILE_NAME);
    }
}
