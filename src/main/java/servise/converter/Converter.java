package servise.converter;

import java.util.List;
import model.FruitTransaction;

public interface Converter {
    List<FruitTransaction> convert(List<String> input);
}
