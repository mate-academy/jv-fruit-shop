package core.basesyntax.parser;

import core.basesyntax.exception.InvalidDateException;
import core.basesyntax.exception.NegativeQuantityException;
import core.basesyntax.model.TransactionModel;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TransactionModelParser implements Parser<TransactionModel> {
    @Override
    public TransactionModel parse(List<String> parseData) {
        int quantity = Integer.parseInt(parseData.get(2));
        if (quantity < 0) {
            throw new NegativeQuantityException("Quantity of fruit's can't be negative");
        }
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setName(parseData.get(1));
        transactionModel.setOperation(parseData.get(0));
        transactionModel.setAmount(quantity);
        try {
            transactionModel.setDate(LocalDate.parse(parseData.get(3)));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException(String.format("Invalid Data %s", parseData.get(3)), e);
        }
        return transactionModel;
    }
}
