package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.InFileStructure;
import service.FileParser;

/*
The main idea of this class is to parse the data from the file
and to create new instances of FruitTransaction class.

- receive String textBox from ReadFromCsvFileImpl
- return List<FruitTransaction>
 */
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
            //try to separate first line with columns names
            if (lineNumber < 1) {
                inFileStructure = new InFileStructure(splitString[TYPE],
                        splitString[FRUIT], splitString[QUANTITY]);
                lineNumber++;
            } else {
                fruitTransactionList.add(new FruitTransaction(splitString[TYPE],
                        splitString[FRUIT], Integer.parseInt(splitString[QUANTITY])));
            }
        }
        return fruitTransactionList;
    }
}
