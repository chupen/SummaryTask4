package ua.nure.teteruk.services;

import ua.nure.teteruk.dao.TakenTestsDAO;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.transaction.TransactionManager;

import java.util.List;

public class TakenTestsServiceImpl implements TakenTestsService {

    private TakenTestsDAO takenTestsDAO;
    private TransactionManager transactionManager;

    public TakenTestsServiceImpl(TakenTestsDAO takenTestsDAO, TransactionManager transactionManager) {
        this.takenTestsDAO = takenTestsDAO;
        this.transactionManager = transactionManager;
    }

    @Override
    public TakenTests createTakenTest(TakenTests takenTest) {
        return transactionManager.execute(() -> takenTestsDAO.create(takenTest));
    }

    @Override
    public List<TakenTests> getTakenTestsByUserId(int userId) {
        return transactionManager.execute(()->takenTestsDAO.getTakenTestsByUserId(userId));
    }

    @Override
    public List<TakenTests> getAllTakenTest() {
        return transactionManager.execute(() -> takenTestsDAO.getAll());
    }

    @Override
    public boolean deleteTakenTests(TakenTests takenTests) {
        return transactionManager.execute(()->takenTestsDAO.delete(takenTests));
    }

    @Override
    public boolean deleteTakenTestsByTestInfoId(TestInfo testInfo) {
        return transactionManager.execute(()->takenTestsDAO.deleteByTestInfoId(testInfo));
    }
}
