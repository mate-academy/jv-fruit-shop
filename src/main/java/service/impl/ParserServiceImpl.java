package service.impl;

import service.ParserService;

public class ParserServiceImpl implements ParserService {
    @Override
    public String[] parser(String string) {
        return string.split(",");
    }
}
