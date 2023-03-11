package service;

import model.TransactionDto;

public interface Parser {
    TransactionDto parsLine(String line);
}
