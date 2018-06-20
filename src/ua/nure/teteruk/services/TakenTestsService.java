package ua.nure.teteruk.services;

import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;

import java.util.List;

public interface TakenTestsService {

    TakenTests createTakenTest(TakenTests takenTest);

    List<TakenTests> getTakenTestsByUserId(int userId);

    List<TakenTests> getAllTakenTest();

    boolean deleteTakenTests(TakenTests takenTests);

    boolean deleteTakenTestsByTestInfoId(TestInfo testInfo);
}
