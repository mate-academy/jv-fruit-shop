package service;

import dto.TransferObject;

public interface Parser {
    TransferObject parse(String line);
}
