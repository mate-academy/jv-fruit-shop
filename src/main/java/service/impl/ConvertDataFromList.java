package service.impl;

import service.ConvertData;

public class ConvertDataFromList implements ConvertData {
    private String spliterator;

    public ConvertDataFromList(String spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public String[] converteData(String data) {
        return data.split(spliterator);
    }
}
