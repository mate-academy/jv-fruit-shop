package service;

import java.util.List;
import model.dto.FruitRecordDto;

public interface ParserService {
    List<FruitRecordDto> parseToDto(List<String> strings);
}
