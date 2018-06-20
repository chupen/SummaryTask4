package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;

import java.util.List;

public interface TestQuestionDAO extends GenericDAO<TestQuestion> {
    
    List<TestQuestion> getTestQuestionsByTestInfoId(int testInfoId);

    boolean deleteByTestInfo(TestInfo entity);
    
    boolean updateTestQuestion(TestQuestion entity, int id, int testInfoId);

    TestQuestion getTestQuestionByTestInfoIdAndQuestionText(int testInfoId, String questionText);
}
