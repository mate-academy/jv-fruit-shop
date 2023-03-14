package service;

import model.TransactionDto;

public interface ParserOperation {
    TransactionDto parserOperation(String line);
}
