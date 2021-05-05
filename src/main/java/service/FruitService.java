package service;

import java.util.List;
import model.dto.FruitRecordDto;

public interface FruitService {
    void saveDto(List<FruitRecordDto> dtos);
}
