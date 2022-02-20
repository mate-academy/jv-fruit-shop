package service;

import model.FruitRecordDto;

public interface FruitRecordDtoParser {
    FruitRecordDto parse(String line);
}
