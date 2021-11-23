package service.impl;

import model.TransactionDto;
import service.Parser;
import service.Validator;

public class ParserImpl implements Parser {
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public TransactionDto parsLine(String line) {
        int quantity;
        if (validator.validate(line)) {
            String[] sp = line.split(",");
            String operation = sp[0];
            String fruitName = sp[1];
            quantity = Integer.parseInt(sp[2]);
            return new TransactionDto(operation, fruitName, quantity);
        }
        throw new RuntimeException("Incorrect input data");
    }
}
