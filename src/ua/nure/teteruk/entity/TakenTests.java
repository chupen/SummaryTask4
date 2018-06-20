package ua.nure.teteruk.entity;

import java.util.Objects;

public class TakenTests {
    private int id;
    private int mark;
    private int passed;
    private String dateOfTaking;
    private int userId;
    private int testsInfoId;

    public int getId() {
        return id;
    }

    public TakenTests setId(int id) {
        this.id = id;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public TakenTests setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public int getPassed() {
        return passed;
    }

    public TakenTests setPassed(int passed) {
        this.passed = passed;
        return this;
    }

    public String getDateOfTaking() {
        return dateOfTaking;
    }

    public TakenTests setDateOfTaking(String dateOfTaking) {
        this.dateOfTaking = dateOfTaking;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public TakenTests setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getTestsInfoId() {
        return testsInfoId;
    }

    public TakenTests setTestsInfoId(int testsInfoId) {
        this.testsInfoId = testsInfoId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakenTests that = (TakenTests) o;
        return id == that.id &&
                mark == that.mark &&
                passed == that.passed &&
                userId == that.userId &&
                testsInfoId == that.testsInfoId &&
                Objects.equals(dateOfTaking, that.dateOfTaking);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mark, passed, dateOfTaking, userId, testsInfoId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TakenTests{");
        sb.append("id=").append(id);
        sb.append(", mark=").append(mark);
        sb.append(", passed=").append(passed);
        sb.append(", dateOfTaking='").append(dateOfTaking).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", testsInfoId=").append(testsInfoId);
        sb.append('}');
        return sb.toString();
    }
}
