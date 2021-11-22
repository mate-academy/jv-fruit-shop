package service;

import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void isValidate(List<String> list) {
        list.remove(0);
        for (String s : list) {
            String[] strings = s.split(",");
            try {
                int count = Integer.parseInt(strings[2]);
            } catch (RuntimeException e) {
                throw new RuntimeException("Error!! the third parameter must be a number");
            }
            if (strings.length != 3 || Integer.parseInt(strings[2]) < 0) {
                throw new RuntimeException("Invalid data");
            }
        }
    }
}
