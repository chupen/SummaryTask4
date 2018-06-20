package ua.nure.teteruk.entity;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private UserRole role;
    private String name;
    private String surname;
    private int blocked;
    private int groupId;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getBlocked() {
        return blocked;
    }

    public User setBlocked(int blocked) {
        this.blocked = blocked;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public User setGroupId(int universityId) {
        this.groupId = universityId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                blocked == user.blocked &&
                groupId == user.groupId &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                role == user.role &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, email, role, name, surname, blocked, groupId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", role=").append(role);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", blocked=").append(blocked);
        sb.append(", groupId=").append(groupId);
        sb.append('}');
        return sb.toString();
    }
}
