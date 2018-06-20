package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.University;

public interface UniversityDAO extends GenericDAO<University> {

    University getByName(String universityName);

    void updateSphere(University entity);
}
