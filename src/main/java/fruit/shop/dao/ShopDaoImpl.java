package fruit.shop.dao;

import fruit.shop.service.FruitTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShopDaoImpl implements ShopDao{
    private static final String FILE_NAME = "fruitshop.csv";
    private FruitTransaction fruitTransaction;

//    public ShopDaoImpl(FruitTransaction fruitTransaction) {
//        this.fruitTransaction = fruitTransaction;
//    }

    @Override
    public List<String> read() {
        List<String> strings;
        try {
            strings = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("File not found " + FILE_NAME,e);
        }
        return strings;
    }

    @Override
    public boolean write(String lines) {
        return false;
    }
}
