package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.InFileStructure;
import model.OperationType;
import service.FileParser;

public class FileParserImpl implements FileParser {
    private static final String ONLY_LETTERS_SEPARATOR = "\\W+";
    private static final byte TYPE = 0;
    private static final byte FRUIT = 1;
    private static final byte QUANTITY = 2;

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> data) {
        InFileStructure inFileStructure;
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        byte lineNumber = 0;

        for (var line : data) {
            String[] splitString = line.split(ONLY_LETTERS_SEPARATOR);
            if (lineNumber < 1) {
                inFileStructure = new InFileStructure(splitString[TYPE],
                        splitString[FRUIT], splitString[QUANTITY]);
                lineNumber++;
            } else {
                fruitTransactionList
                        .add(new FruitTransaction(OperationType.getByCode(splitString[TYPE]),
                        splitString[FRUIT], Integer.parseInt(splitString[QUANTITY])));
            }
        }
        return fruitTransactionList;
    }
}
