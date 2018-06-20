package ua.nure.teteruk.entity;

import java.util.Objects;

public class TestInfo {
    private int id;
    private String name;
    private Complexity complexity;
    private int time;
    private int passMark;
    private int subjectId;
    private int authorId;

    public int getId() {
        return id;
    }

    public TestInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public TestInfo setComplexity(Complexity complexity) {
        this.complexity = complexity;
        return this;
    }

    public int getTime() {
        return time;
    }

    public TestInfo setTime(int time) {
        this.time = time;
        return this;
    }

    public int getPassMark() {
        return passMark;
    }

    public TestInfo setPassMark(int passMark) {
        this.passMark = passMark;
        return this;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public TestInfo setSubjectId(int subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public int getAuthorId() {
        return authorId;
    }

    public TestInfo setAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestInfo testInfo = (TestInfo) o;
        return id == testInfo.id &&
                time == testInfo.time &&
                passMark == testInfo.passMark &&
                subjectId == testInfo.subjectId &&
                authorId == testInfo.authorId &&
                Objects.equals(name, testInfo.name) &&
                complexity == testInfo.complexity;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, complexity, time, passMark, subjectId, authorId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", complexity=").append(complexity);
        sb.append(", time=").append(time);
        sb.append(", passMark=").append(passMark);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", authorId=").append(authorId);
        sb.append('}');
        return sb.toString();
    }
}
