package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransactionModel;
import model.InFileStructure;
import service.FileParser;

/*
The main idea of this class is to parse the data from the file
and to create new instances of FruitTransactionModel class.

- receive String textBox from ReadFromCsvFileImpl
- return List<FruitTransactionModel>
 */
public class FileParserImpl implements FileParser {
    @Override
    public List<FruitTransactionModel> getFruitTransaction(String data) {
        InFileStructure inFileStructure;
        List<FruitTransactionModel> fruitTransactionModelList = new ArrayList<>();

        String[] splitData = data.split(System.lineSeparator());

        for (var s : splitData) {
            String[] splitString = s.split("\\W+");
            //try to separate first line with columns names
            if (splitString[0].length() > 1) {
                inFileStructure = new InFileStructure(splitString[0],
                        splitString[1], splitString[2]);
            } else {
                fruitTransactionModelList.add(new FruitTransactionModel(splitString[0],
                        splitString[1], Integer.parseInt(splitString[2])));
            }
        }
        return fruitTransactionModelList;
    }
}
