package service.validator;

import exception.ValidationException;
import java.util.List;

public class ValidatorProcess extends ValidationDataImpl {
    public boolean checkAllList(List<String> doneFileReading) {
        for (String temp : doneFileReading) {
            try {
                validate(temp);
            } catch (ValidationException e) {
                throw new RuntimeException("Data is not valid" + temp, e);
            }
        }
        return true;
    }
}
