package ua.nure.teteruk.entity;

import java.util.Objects;

public class Faculty {
    private int id;
    private String name;
    private int universitiesId;

    public int getId() {
        return id;
    }

    public Faculty setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Faculty setName(String name) {
        this.name = name;
        return this;
    }

    public int getUniversitiesId() {
        return universitiesId;
    }

    public Faculty setUniversitiesId(int universitiesId) {
        this.universitiesId = universitiesId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                universitiesId == faculty.universitiesId &&
                Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, universitiesId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Faculty{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", universitiesId=").append(universitiesId);
        sb.append('}');
        return sb.toString();
    }
}
