package service;

import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public void isValidate(List<String> list) {
        list.remove(0);
        for (String s : list) {
            String[] strings = s.split(",");
            if (strings.length != 3 || Integer.parseInt(strings[2]) < 0) {
                throw new RuntimeException("Invalid data");
            }
        }
    }
}
