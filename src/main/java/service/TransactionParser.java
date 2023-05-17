package service;

import model.fruitActivitiesModel;
import java.util.List;

public interface TransactionParser {
    List<fruitActivitiesModel> parse(List<String> transaction);
}
