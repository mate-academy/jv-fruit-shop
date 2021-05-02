package fruitshop.service;

import fruitshop.model.dto.FruitOperationDto;
import java.util.List;

public interface FruitDtoParser {
    List<FruitOperationDto> parse(List<String> fruitInfoLines);
}
