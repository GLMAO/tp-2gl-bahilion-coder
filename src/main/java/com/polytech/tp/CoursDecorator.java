package com.polytech.tp;

public abstract class CoursDecorator implements ICours {
    protected ICours coursDecorated;

    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }
    
    // TODO: Forcer l'implémentation des méthodes de ICours
}