package service.impl;

import java.util.List;
import service.ParserService;
import strategy.impl.TransactionImpl;

public class ParserServiceImpl implements ParserService {
    @Override
    public void parseFile(List<String> data) {
        data.forEach(a -> new TransactionImpl().operate(a));
    }
}
