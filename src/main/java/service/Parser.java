package service;

import dto.Transaction;

public interface Parser {
    Transaction parse(String line);
}
