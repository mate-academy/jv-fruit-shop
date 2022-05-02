package service;

import model.Transaction;

public interface ParserService {
    Transaction parse(String line);
}
