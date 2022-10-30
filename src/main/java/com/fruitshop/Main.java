package com.fruitshop;

import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.servicesimpl.FileCsvReaderImpl;
import com.fruitshop.servicesimpl.FileCsvWriterImpl;
import com.fruitshop.servicesimpl.FruitShopSupplierImpl;
import com.fruitshop.servicesimpl.ParseFruitNamesImpl;
import com.fruitshop.servicesimpl.ResultMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static final File FILE_TO_WRITE_IN = new File("src/main/resources/fileInWriting.csv");
    private static final File FILE_TO_READ = new File("src/main/resources/fileFromReading.csv");

    public static void main(String[] args) throws IOException {

        List<String> list = new FileCsvReaderImpl().readFromCsv(FILE_TO_READ.getPath());
        Map<String, Fruit> fruitMap = new ParseFruitNamesImpl().getFruitNamesMap(list);
        fruitMap = new FruitShopSupplierImpl().fillTheMap(list);
        String message = new ResultMessage().makeMessage();
        new FileCsvWriterImpl().writeInFile(message, FILE_TO_WRITE_IN.getPath());
    }
}
