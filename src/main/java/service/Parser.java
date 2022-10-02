package service;

import dto.ShopOperation;

public interface Parser {
    ShopOperation parseLine(String line);
}
