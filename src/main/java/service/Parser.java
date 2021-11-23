package service;

import java.util.List;
import model.Transaction;

public interface Parser {
    List<Transaction> parse(List<String> fruits);
}
