package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.Faculty;

import java.util.List;

public interface FacultyDAO extends GenericDAO<Faculty> {

    List<Faculty> getByUniversityId(int universityId);
}
