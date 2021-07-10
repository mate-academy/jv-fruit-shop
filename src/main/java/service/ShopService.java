package service;

import java.util.List;
import model.FruitDataDto;

public interface ShopService {
    public void fillStorage(List<FruitDataDto> data);
}
