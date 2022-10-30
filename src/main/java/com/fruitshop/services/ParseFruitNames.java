package com.fruitshop.services;

import com.fruitshop.fruitsmodels.Fruit;
import java.util.List;
import java.util.Map;

public interface ParseFruitNames {

    Map<String, Fruit> getFruitNamesMap(List<String> listOfAllFruits);
}
