package storage;

public class OperationalStorage {
    private static String fruit;
    private static Integer operationAmount;
    private static Integer storedAmount;

    public static String getFruit() {
        return fruit;
    }

    public static void setFruit(String fruit) {
        OperationalStorage.fruit = fruit;
    }

    public static Integer getOperationAmount() {
        return operationAmount;
    }

    public static void setOperationAmount(Integer operationAmount) {
        OperationalStorage.operationAmount = operationAmount;
    }

    public static Integer getStoredAmount() {
        return storedAmount;
    }

    public static void setStoredAmount(Integer storedAmount) {
        OperationalStorage.storedAmount = storedAmount;
    }
}
