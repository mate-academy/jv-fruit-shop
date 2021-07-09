package service;

import dto.Transaction;

public interface Parser {
    Transaction parseLine(String dataline);
}
