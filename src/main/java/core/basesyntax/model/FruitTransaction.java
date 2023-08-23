package core.basesyntax.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import core.basesyntax.dto.OperationConverterStringToEnum;

public class FruitTransaction {
    @CsvCustomBindByName(column = "type", required = true,
            converter = OperationConverterStringToEnum.class)
    private Operation type;
    @CsvBindByName(column = "fruit", required = true)
    private String fruitName;
    @CsvBindByName(column = "quantity", required = true)
    private int quantity;

    public FruitTransaction(Operation type, String fruitName, int quantity) {
        this.type = type;
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public FruitTransaction(String code, String fruitName, int quantity) {
        this.type = Operation.codeOf(code);
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    public FruitTransaction() {
    }

    public Operation getType() {
        return type;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "type=" + type
                + ", fruitName='" + fruitName + '\''
                + ", quantity=" + quantity
                + '}' + '\n';
    }
}
