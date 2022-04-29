package servise.convertobject;

import model.FruitTransaction;

import java.util.List;

public interface ConvertToObject {
    List<FruitTransaction> convertToObject(List<String> input);
}
