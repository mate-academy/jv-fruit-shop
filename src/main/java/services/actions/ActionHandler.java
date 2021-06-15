package services.actions;

import java.util.Map;

public interface ActionHandler {
    Map<String, Integer> getResultOfAction(String fruitName, int fruitCount);
}
