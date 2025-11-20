package com.polytech.tp;

public abstract class CoursDecorator implements ICours {
    protected ICours coursDecorated;

    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }
    
    @Override
    public abstract String getDescription();
    
    @Override
    public abstract double getDuree();
}