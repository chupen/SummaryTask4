package ua.nure.teteruk.entity;

import java.util.Objects;

public class TestQuestion {
    private int id;
    private int testInfoId;
    private String questionText;

    public int getId() {
        return id;
    }

    public TestQuestion setId(int id) {
        this.id = id;
        return this;
    }

    public int getTestInfoId() {
        return testInfoId;
    }

    public TestQuestion setTestInfoId(int testInfoId) {
        this.testInfoId = testInfoId;
        return this;
    }

    public String getQuestionText() {
        return questionText;
    }

    public TestQuestion setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestQuestion that = (TestQuestion) o;
        return id == that.id &&
                testInfoId == that.testInfoId &&
                Objects.equals(questionText, that.questionText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, testInfoId, questionText);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestQuestion{");
        sb.append("id=").append(id);
        sb.append(", testInfoId=").append(testInfoId);
        sb.append(", questionText='").append(questionText).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
