package service;

import model.TransactionDto;
import service.impl.FruitServiceImpl;

import java.util.List;

public interface Parser {
    TransactionDto parseLine(String line);

    List<FruitServiceImpl.Transaction> parse(List<String> lines);
}
