package ua.nure.teteruk.services;

import ua.nure.teteruk.dao.CompleteTestsDAO;
import ua.nure.teteruk.dao.SubjectDAO;
import ua.nure.teteruk.dao.TestInfoDAO;
import ua.nure.teteruk.dao.TestQuestionDAO;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.transaction.TransactionManager;

import java.util.List;

public class CompleteTestServiceImpl implements CompleteTestService {

    private SubjectDAO subjectDAO;
    private TestInfoDAO testInfoDAO;
    private TestQuestionDAO testQuestionDAO;
    private CompleteTestsDAO completeTestsDAO;
    private TransactionManager transactionManager;

    public CompleteTestServiceImpl(SubjectDAO subjectDAO, TestInfoDAO testInfoDAO,
                                   TestQuestionDAO testQuestionDAO, CompleteTestsDAO completeTestsDAO,
                                   TransactionManager transactionManager) {
        this.subjectDAO = subjectDAO;
        this.testInfoDAO = testInfoDAO;
        this.testQuestionDAO = testQuestionDAO;
        this.completeTestsDAO = completeTestsDAO;
        this.transactionManager = transactionManager;
    }

    //Subject
    @Override
    public Subject creteSubject(Subject subject) {
        return transactionManager.execute(()->subjectDAO.create(subject));
    }

    @Override
    public Subject getSubject(int subjectId) {
        return transactionManager.execute(()->subjectDAO.get(subjectId));
    }

    @Override
    public List<Subject> getAllSubjects() {
        return transactionManager.execute(()->subjectDAO.getAll());
    }

    //TestInfo
    @Override
    public TestInfo createTestInfo(TestInfo testInfo) {
        return transactionManager.execute(()->testInfoDAO.create(testInfo));
    }

    @Override
    public TestInfo getTestInfo(int id) {
        return transactionManager.execute(()->testInfoDAO.get(id));
    }

    @Override
    public TestInfo getTestInfoByName(String name) {
        return transactionManager.execute(()->testInfoDAO.getByName(name));
    }

    @Override
    public List<TestInfo> getAllTestInfos() {
        return transactionManager.execute(()->testInfoDAO.getAll());
    }

    @Override
    public List<TestInfo> getTestInfoBySubjectId(int subjectId) {
        return transactionManager.execute(()->testInfoDAO.getBySubjectId(subjectId));
    }

    @Override
    public List<TestInfo> testInfoOrderByTestInfoName() {
        return transactionManager.execute(()->testInfoDAO.orderByName());
    }

    @Override
    public List<TestInfo> testInfoOrderByComplexity() {
        return transactionManager.execute(()->testInfoDAO.orderByComplexity());
    }

    @Override
    public boolean updateTestInfo(TestInfo testInfo, int testInfoId) {
        return transactionManager.execute(()->testInfoDAO.updateTestInfo(testInfo, testInfoId));
    }

    @Override
    public boolean deleteTestInfo(TestInfo testInfo) {
        return transactionManager.execute(()->testInfoDAO.delete(testInfo));
    }

    //TestQuestion
    @Override
    public TestQuestion createTestQuestion(TestQuestion testQuestion) {
        return transactionManager.execute(()->testQuestionDAO.create(testQuestion));
    }

    @Override
    public TestQuestion getTestQuestion(int testQuestionId) {
        return transactionManager.execute(()->testQuestionDAO.get(testQuestionId));
    }

    @Override
    public List<TestQuestion> getTestQuestionsByTestInfoId(int testInfoId) {
        return transactionManager.execute(()->testQuestionDAO.getTestQuestionsByTestInfoId(testInfoId));
    }

    @Override
    public List<TestQuestion> getAllTestQuestions() {
        return transactionManager.execute(()->testQuestionDAO.getAll());
    }

    @Override
    public TestQuestion getTestQuestionByTestInfoIdAndQuestionText(int testInfoId, String questionText) {
        return transactionManager.execute(()->testQuestionDAO.getTestQuestionByTestInfoIdAndQuestionText(testInfoId, questionText));
    }

    @Override
    public boolean updateTestQuestion(TestQuestion testQuestion, int questionId, int testInfoId) {
        return transactionManager.execute(()->testQuestionDAO.updateTestQuestion(testQuestion, questionId, testInfoId));
    }

    @Override
    public boolean deleteTestQuestionsByTestInfo(TestInfo testInfo) {
        return transactionManager.execute(()->testQuestionDAO.deleteByTestInfo(testInfo));
    }

    //CompleteTests
    @Override
    public CompleteTests createCompleteTests(CompleteTests completeTests) {
        return transactionManager.execute(()->completeTestsDAO.create(completeTests));
    }

    @Override
    public List<CompleteTests> getCompleteTestsByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId) {
        return transactionManager.execute(()->completeTestsDAO.getByTestInfoIdAndTestQuestionId(testInfoId, testQuestionId));
    }

    @Override
    public List<CompleteTests> getAllCompleteTests() {
        return transactionManager.execute(()->completeTestsDAO.getAll());
    }

    @Override
    public List<CompleteTests> getCorrectCompleteTestsByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId) {
        return transactionManager.execute(()->completeTestsDAO.getCorrectByTestInfoIdAndTestQuestionId(testInfoId, testQuestionId));
    }

    @Override
    public boolean updateCompleteTest(CompleteTests completeTests, int testQuestionId, int testInfoId) {
        return transactionManager.execute(()->completeTestsDAO.updateCompleteTest(completeTests, testQuestionId, testInfoId));
    }

    @Override
    public boolean deleteCompleteTestsByTestInfo(TestInfo testInfo) {
        return transactionManager.execute(()->completeTestsDAO.deleteByTestInfo(testInfo));
    }
}
