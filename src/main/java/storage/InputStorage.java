package storage;

import java.util.List;

public class InputStorage {
    private static List<String> inputData;

    public static List<String> getInputData() {
        return inputData;
    }

    public static void setInputData(List<String> inputData) {
        InputStorage.inputData = inputData;
    }
}
