package service.actions;

import model.FruitDataDto;

public interface ActivityHandler {
    boolean apply(FruitDataDto fruitDataDto);
}
