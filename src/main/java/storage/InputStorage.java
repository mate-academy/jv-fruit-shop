package storage;

import java.util.List;

public class InputStorage {
    private final List<String> inputData;

    public InputStorage(List<String> inputData) {
        this.inputData = inputData;
    }

    public List<String> getInputData() {
        return inputData;
    }
}
