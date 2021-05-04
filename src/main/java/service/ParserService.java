package service;

import model.dto.FruitRecordDto;

import java.util.List;

public interface ParserService {
    List<FruitRecordDto> parseToDto(List<String> strings);
}
