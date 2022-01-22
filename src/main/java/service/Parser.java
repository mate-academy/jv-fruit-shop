package service;

import model.TransactionDto;

public interface Parser {
    TransactionDto parseLine(String line);
}
