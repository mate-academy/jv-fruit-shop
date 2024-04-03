package core.basesyntax.service;

import static core.basesyntax.service.TransactionParser.parseTransaction;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    private TransactionProcessor transactionProcessor;

    private FileReader(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    public void read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            bufferedReader.readLine(); //reading first line because it contains fields names
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                transactionProcessor.processTransaction(parseTransaction(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }

    public static FileReader of(TransactionProcessor transactionProcessor) {
        return new FileReader(transactionProcessor);
    }
}
