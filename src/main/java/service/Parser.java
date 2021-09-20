package service;

import model.FruitRecordDto;

public interface Parser {
    FruitRecordDto pars(String line);
}
