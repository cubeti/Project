package org.sef.student.Exceptions;

public class ChampExistsExeption extends Exception {

    private String name;

    public ChampExistsExeption(String name) {
        super(String.format("A champion with the name %s already exists!", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
