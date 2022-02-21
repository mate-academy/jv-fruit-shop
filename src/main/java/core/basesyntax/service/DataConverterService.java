package core.basesyntax.service;

import core.basesyntax.model.dto.FruitDto;
import java.util.List;

public interface DataConverterService {
    List<FruitDto> convertToDto(List<String> linesFromFile);
}
