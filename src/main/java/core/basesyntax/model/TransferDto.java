package core.basesyntax.model;

import core.basesyntax.servises.OperationType;
import java.util.Objects;

public class TransferDto {
    private OperationType type;
    private String productName;
    private int amount;

    public TransferDto(OperationType type, String productName, int amount) {
        this.type = type;
        this.productName = productName;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransferDto)) {
            return false;
        }
        TransferDto that = (TransferDto) o;
        return getAmount() == that.getAmount()
                    && getType() == that.getType()
                    && Objects.equals(getProductName(), that.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getProductName(), getAmount());
    }
}
