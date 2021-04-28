package fruitshop.service;

import fruitshop.model.dto.FruitDto;
import java.util.List;

public interface FruitDtoParser {
    List<FruitDto> parse(List<String> fruitInfoLines);
}
