package service;

import java.util.List;

public interface StringValidatorService {
    boolean isStringValid(String string);

    boolean isStringValid(List<String> data, String title);
}
