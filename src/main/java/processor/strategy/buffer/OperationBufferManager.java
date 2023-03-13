package processor.strategy.buffer;

public class OperationBufferManager {
    public static void setFruit(String fruit) {
        OperationBuffer.fruit = fruit;
    }

    public static void setOperationAmount(Integer amount) {
        OperationBuffer.operationAmount = amount;
    }

    public static void setStoredAmount(Integer amount) {
        OperationBuffer.storedAmount = amount;
    }

    public static String getFruit() {
        return OperationBuffer.fruit;
    }

    public static Integer getOperationAmount() {
        return OperationBuffer.operationAmount;
    }

    public static Integer getStoredAmount() {
        return OperationBuffer.storedAmount;
    }
}
