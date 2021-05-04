package main.service.interfaces;

import main.model.dto.FruitRecordDto;

public interface ParserService {
    FruitRecordDto parse(String line);
}
