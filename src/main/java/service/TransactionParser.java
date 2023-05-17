package service;

import java.util.List;
import model.FruitActivitiesModel;

public interface TransactionParser {
    List<FruitActivitiesModel> parse(List<String> transaction);
}
