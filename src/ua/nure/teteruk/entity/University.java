package ua.nure.teteruk.entity;

import java.util.Objects;

public class University {
    private int id;
    private String name;
    private String sphere;

    public int getId() {
        return id;
    }

    public University setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(String name) {
        this.name = name;
        return this;
    }

    public String getSphere() {
        return sphere;
    }

    public University setSphere(String sphere) {
        this.sphere = sphere;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(sphere, that.sphere);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, sphere);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("University{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sphere='").append(sphere).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
