package services;

import services.actions.ActionHandler;

public interface ActionTypeStrategy {
    ActionHandler get(String type);
}
