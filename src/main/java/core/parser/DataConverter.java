package core.parser;

import core.model.Transaction;

import java.util.List;

public interface DataConverter {
    List<Transaction> convertToTransaction(List<String> data);
}
