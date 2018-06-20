package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;

import java.util.List;

public interface TakenTestsDAO extends GenericDAO<TakenTests> {
    
    List<TakenTests> getTakenTestsByUserId(int userId);

    boolean deleteByTestInfoId(TestInfo testInfo);
}
