package myFruitShop.ValidationProces;

import java.util.List;

public interface Validator {
    List<String> validator (List<String> uncheckedInfo) throws InvalidDataException;
}
