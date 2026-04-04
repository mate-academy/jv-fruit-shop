package core.parser;

import core.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataConverterCsvImpl implements DataConverter {
    @Override
    public List<Transaction> convertToTransaction(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        
        for (int i = 1; i < data.size(); i++) {
            Transaction transaction = new Transaction();
            String[] parts = data.get(i).split(",");
            
            if (parts.length > 3) {
                throw new RuntimeException("Can't convert given line: " + data.get(i));
            }
            
            String type = parts[0].trim();
            String product = parts[1].trim();
            String quantity = parts[2].trim();
            
            switch (type) {
                case "b": 
                    transaction.setOperation(Transaction.Operation.BALANCE);
                    break;
                case "s":
                    transaction.setOperation(Transaction.Operation.SUPPLY);
                    break;
                case "p":
                    transaction.setOperation(Transaction.Operation.PURCHASE);
                    break;
                case "r":
                    transaction.setOperation(Transaction.Operation.RETURN);
                    break;
                default:
                    throw new RuntimeException("Unknown operation: " + parts[0]);
            }
            transaction.setProduct(product);
            transaction.setQuantity(Integer.parseInt(quantity));
            transactions.add(transaction);
        }
        return transactions;
    }
}
