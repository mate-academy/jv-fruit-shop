package core.basesyntax.services.impl;

import core.basesyntax.services.FruitParse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Parse implements FruitParse {
    @Override
    public List<List<String>> readFile(String path) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //@ TODO: 26.08.2020  здесь нужно распарсить файл в лист листов
        return null;
    }


}
