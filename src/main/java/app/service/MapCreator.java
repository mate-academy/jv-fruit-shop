package app.service;

import app.strategy.OperationHandler;
import java.util.Map;

public interface MapCreator {
    Map<String, OperationHandler> createMap();
}
