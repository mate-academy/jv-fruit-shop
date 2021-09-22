package fruitshop.service;

import fruitshop.model.RecordDto;
import java.util.List;

public interface FruitShopService {
    void fruitStorageModifier(List<RecordDto> dataInDto);
}
