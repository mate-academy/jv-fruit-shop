package main;

import java.util.HashMap;
import java.util.Map;
import operation.OperationHandler;
import operation.impl.Balance;
import operation.impl.OperationStrategyImpl;
import operation.impl.Purchase;
import operation.impl.Return;
import operation.impl.Supply;
import service.ReportCreator;
import service.TransactionParser;
import service.TransactionProcessor;
import service.impl.CsvTransactionParser;
import service.impl.FileReader;
import service.impl.FileWriter;
import service.impl.TransactionProcessorImpl;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlers);

        operationHandlers.put("b", new Balance());
        operationHandlers.put("s", new Supply());
        operationHandlers.put("p", new Purchase());
        operationHandlers.put("r", new Return());

        FileReader reader = new FileReader();
        TransactionParser csvTransactionParser = new CsvTransactionParser(operationStrategy);
        TransactionProcessor transactionProcessorImpl = new TransactionProcessorImpl();
        csvTransactionParser.parse(reader.read("data.csv"))
                .forEach(transactionProcessorImpl::process);

        FileWriter writer = new FileWriter();
        writer.write(new ReportCreator().create(), "newData.csv");
    }
}
