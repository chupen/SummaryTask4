package ua.nure.teteruk.entity;

import java.util.Objects;

public class Group {
    private int id;
    private String name;
    private int facultyId;

    public int getId() {
        return id;
    }

    public Group setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public Group setFacultyId(int facultyId) {
        this.facultyId = facultyId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                facultyId == group.facultyId &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, facultyId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", facultyId=").append(facultyId);
        sb.append('}');
        return sb.toString();
    }
}
