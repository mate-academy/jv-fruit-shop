package app.service;

import app.dto.Transaction;
import app.strategy.OperationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransferDataFromFileToTransactionImpl implements TransferDataFromFileToTransaction {
    @Override
    public void transfer(String fileName) {
        Map<String, OperationHandler> handlers = new MapInitializationImpl().createMap();
        List<String> linesFromFile = new FileReaderImpl().readFromFile(fileName);

        List<Transaction> transactions = new ArrayList<>();
        LineValidator lineValidator = new LineValidatorImpl();
        Parser parser = new ParserImpl();

        linesFromFile.stream()
                .filter(lineValidator::isValid)
                .forEach(l -> transactions.add(parser.parseLine(l)));

        transactions.forEach(t -> handlers.get(t.getOperation()).apply(t));
    }
}
