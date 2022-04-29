package servise.converter;

import model.FruitTransaction;

import java.util.List;

public interface Converter {
    List<FruitTransaction> convert(List<String> input);
}
