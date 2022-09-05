package service;

import java.util.List;
import model.Transaction;

public interface ParserService {
    List<Transaction> parse(List<String> inputList);
}
