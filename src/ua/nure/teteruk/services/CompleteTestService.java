package ua.nure.teteruk.services;

import ua.nure.teteruk.dao.mapper.CompleteTestMapper;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;

import java.util.List;

public interface CompleteTestService {
    //Subject
    Subject creteSubject(Subject subject);

    Subject getSubject(int subjectId);

    List<Subject> getAllSubjects();

    //TestInfo
    TestInfo createTestInfo(TestInfo testInfo);

    TestInfo getTestInfo(int id);

    TestInfo getTestInfoByName(String name);

    List<TestInfo> getAllTestInfos();

    List<TestInfo> getTestInfoBySubjectId(int subjectId);

    List<TestInfo> testInfoOrderByTestInfoName();

    List<TestInfo> testInfoOrderByComplexity();

    boolean updateTestInfo(TestInfo testInfo, int testInfoId);

    boolean deleteTestInfo(TestInfo testInfo);

    //TestQuestion
    TestQuestion createTestQuestion(TestQuestion testQuestion);

    TestQuestion getTestQuestion(int testQuestionId);

    List<TestQuestion> getTestQuestionsByTestInfoId(int testInfoId);

    List<TestQuestion> getAllTestQuestions();

    TestQuestion getTestQuestionByTestInfoIdAndQuestionText(int testInfoId, String questionText);

    boolean updateTestQuestion(TestQuestion testQuestion, int questionId, int testInfoId);

    boolean deleteTestQuestionsByTestInfo(TestInfo testInfo);

    //CompleteTests
    CompleteTests createCompleteTests(CompleteTests completeTests);

    List<CompleteTests> getCompleteTestsByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId);

    List<CompleteTests> getCorrectCompleteTestsByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId);

    List<CompleteTests> getAllCompleteTests();

    boolean updateCompleteTest(CompleteTests completeTests, int testQuestionId, int testInfoId);

    boolean deleteCompleteTestsByTestInfo(TestInfo testInfo);

}
