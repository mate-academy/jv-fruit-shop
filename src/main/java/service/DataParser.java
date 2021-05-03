package service;

import java.util.List;
import model.FruitDataDto;

public interface DataParser {

    List<FruitDataDto> parseData(List<String> data);
}
