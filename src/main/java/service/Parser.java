package service;

import java.util.List;
import model.TransactionDto;
import service.impl.FruitServiceImpl;

public interface Parser {
    TransactionDto parseLine(String line);

    List<FruitServiceImpl.Transaction> parse(List<String> lines);
}
