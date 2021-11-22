package service;

import model.Transaction;

public interface Parser {
    Transaction parseLine(String line);
}
