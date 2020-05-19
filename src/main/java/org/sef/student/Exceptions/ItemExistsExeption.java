package org.sef.student.Exceptions;

public class ItemExistsExeption extends Exception {
    private String name;

    public ItemExistsExeption(String name) {
        super(String.format("An item with the name %s already exists!", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

