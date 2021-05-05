package datavalidation;

import java.util.List;

public interface DataValidator {
    boolean validateData(List<String> dataFromFile);
}
