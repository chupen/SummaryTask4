package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.TestInfo;

import java.util.List;

public interface TestInfoDAO extends GenericDAO<TestInfo> {
    
    TestInfo getByName(String name);

    boolean updateTestInfo(TestInfo entity, int id);

    List<TestInfo> getBySubjectId(int subjectId);

    List<TestInfo> orderByName();

    List<TestInfo> orderByComplexity();
}
