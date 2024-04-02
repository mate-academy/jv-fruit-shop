package core.basesyntax.service;

import static core.basesyntax.service.TransactionParser.parseTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    private TransactionProcessor transactionProcessor;

    private InputReader(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    public void read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.readLine(); //reading first line because it contains fields names
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                transactionProcessor.processTransaction(parseTransaction(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }

    public static InputReader of(TransactionProcessor transactionProcessor) {
        return new InputReader(transactionProcessor);
    }
}
