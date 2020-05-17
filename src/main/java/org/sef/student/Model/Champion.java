package org.sef.student.Model;

public class Champion {
    private String name;
    private String creator;
    public Champion(){

    }
    public Champion(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Champion ch = (Champion) o;

        if (!name.equals(ch.name)) return false;
        return true;
    }
    @Override
    public String toString() {
            return "Champion{" +
                    "name='" + name + '\'' +
                    ", created by='" + creator + '\'' +
                    '}';
    }
}

