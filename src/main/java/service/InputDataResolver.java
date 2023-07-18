package service;

import java.util.ArrayList;
import java.util.List;
import model.InputDataType;

public interface InputDataResolver {
    ArrayList<InputDataType> resolveData(List<String> lines);
}
