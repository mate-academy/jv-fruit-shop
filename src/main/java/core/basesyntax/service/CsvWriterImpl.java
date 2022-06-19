package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.handlers.OperationHandler;
import core.basesyntax.service.handlers.OperationStrategyImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements  CsvWriter {
    public void generateCsvReport(String pathname, String report) {
        File file = new File(pathname);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file \"" + file + "\"", e);
        }
    }

    public static class TransactionProcessor {
        public void fileToMap(String csvString) {
            for (String csvLine: csvString.split("\n")) {
                if (csvLine.equals("null")) {
                    continue;
                }
                TransactionParserImpl parserService = new TransactionParserImpl();
                Transaction transaction = new Transaction(parserService.getOperation(csvLine),
                                                            parserService.getFruit(csvLine),
                                                            parserService.getQuantity(csvLine));
                Transaction.Operation operation = transaction.getOperation();
                Fruit fruit = transaction.getFruit();
                Integer quantity = transaction.getQuantity();

                OperationStrategyImpl operationStrategy = new OperationStrategyImpl();
                OperationHandler operationHandler = operationStrategy.get(operation);
                operationHandler.processOperation(operation, fruit, quantity);
                }
            }
        }
}
