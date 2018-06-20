package ua.nure.teteruk.entity;

import java.util.Objects;

public class CompleteTests {
    private int answerId;
    private int testQuestionId;
    private int testInfoId;
    private String answerText;
    private int correct;

    public int getAnswerId() {
        return answerId;
    }

    public CompleteTests setAnswerId(int answerId) {
        this.answerId = answerId;
        return this;
    }

    public int getTestQuestionId() {
        return testQuestionId;
    }

    public CompleteTests setTestQuestionId(int testQuestionId) {
        this.testQuestionId = testQuestionId;
        return this;
    }

    public int getTestInfoId() {
        return testInfoId;
    }

    public CompleteTests setTestInfoId(int testInfoId) {
        this.testInfoId = testInfoId;
        return this;
    }

    public String getAnswerText() {
        return answerText;
    }

    public CompleteTests setAnswerText(String answerText) {
        this.answerText = answerText;
        return this;
    }

    public int getCorrect() {
        return correct;
    }

    public CompleteTests setCorrect(int correct) {
        this.correct = correct;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteTests that = (CompleteTests) o;
        return answerId == that.answerId &&
                testQuestionId == that.testQuestionId &&
                testInfoId == that.testInfoId &&
                correct == that.correct &&
                Objects.equals(answerText, that.answerText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(answerId, testQuestionId, testInfoId, answerText, correct);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompleteTests{");
        sb.append("answerId=").append(answerId);
        sb.append(", testQuestionId=").append(testQuestionId);
        sb.append(", testInfoId=").append(testInfoId);
        sb.append(", answerText='").append(answerText).append('\'');
        sb.append(", correct=").append(correct);
        sb.append('}');
        return sb.toString();
    }
}
