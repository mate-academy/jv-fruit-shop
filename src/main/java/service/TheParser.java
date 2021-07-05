package service;

import dto.Transaction;

public interface TheParser {
    Transaction parseLine(String dataline);
}
