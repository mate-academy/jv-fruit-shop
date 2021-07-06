package app.service;

import app.dto.Transaction;

public interface Parser {
    Transaction parseLine(String line);
}
