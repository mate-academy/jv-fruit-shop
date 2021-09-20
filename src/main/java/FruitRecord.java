import java.util.ArrayList;
import java.util.List;
import validator.Validator;
import validator.ValidatorImpl;

public class FruitRecord {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int FRUIT_QUANTITY = 2;
    private String operationType;
    private String fruit;
    private int amount;
    private Validator validatorImpl = new ValidatorImpl();

    public FruitRecord(String operationType, String fruit, int amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public FruitRecord() {
    }

    public String getOperationType() {
        return operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public int getAmount() {
        return amount;
    }

    public List<FruitRecord> recordingData(List<String[]> splitedInformationList) {
        validatorImpl.validate(splitedInformationList);
        List<FruitRecord> operationList = new ArrayList<>();
        String[] splitLine;
        int amount;
        for (int i = 1; i < splitedInformationList.size(); i++) {
            splitLine = splitedInformationList.get(i);
            amount = Integer.parseInt(splitLine[FRUIT_QUANTITY]);
            operationList.add(new FruitRecord(splitLine[OPERATION_TYPE],
                    splitLine[FRUIT_TYPE], amount));
        }
        return operationList;
    }
}
