package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.TransactionDto;
import service.Parser;
import service.Validator;

public class ParserImpl implements Parser<TransactionDto> {
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parseLine(List<String> list) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        list.remove(0);
        for (String line : list) {
            validator.validate(line);
            String[] information = line.split(",");
            transactionDtoList.add(new TransactionDto(information[0],
                    information[1],
                    Integer.parseInt(information[2])));
        }
        return transactionDtoList;
    }
}
