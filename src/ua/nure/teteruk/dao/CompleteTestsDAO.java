package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.services.CompleteTestService;

import java.util.List;

public interface CompleteTestsDAO extends GenericDAO<CompleteTests> {

    List<CompleteTests> getByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId);

    List<CompleteTests> getCorrectByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId);

    boolean updateCompleteTest(CompleteTests completeTests, int testQuestionId, int testInfoId);

    boolean deleteByTestInfo(TestInfo entity);
}
