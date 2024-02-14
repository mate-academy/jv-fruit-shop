package service;

import dao.ActionDao;
import java.util.List;

public interface ParserService {
    ActionDao parseToObject(List<String> stringList);
}
