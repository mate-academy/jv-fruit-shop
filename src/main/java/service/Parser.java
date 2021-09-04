package service;

import dto.Transaction;

public interface Parser {
    Transaction parseData(String data);
}
