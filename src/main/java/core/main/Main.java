package core.main;

import core.io.Reader;
import core.io.ReaderCsvImpl;
import core.io.Writer;
import core.io.WriterCsvImpl;
import core.model.Transaction;
import core.parser.DataConverter;
import core.parser.DataConverterCsvImpl;
import core.service.ShopService;
import core.service.ShopServiceImpl;
import core.service.handler.*;
import core.strategy.OperationStrategy;
import core.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ReaderCsvImpl();
        List<String> lines = reader.readData("inputFile.csv");

        DataConverter converter = new DataConverterCsvImpl();
        List<Transaction> transactions = converter.convertToTransaction(lines);

        Map<Transaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Transaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(Transaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(Transaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(Transaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        
        shopService.process(transactions);
        
        Writer writer = new WriterCsvImpl();
        writer.writeData("output.csv",shopService.getStorage());
        
    }
}
