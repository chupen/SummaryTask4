package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.Group;

public interface GroupDAO extends GenericDAO<Group> {

    Group getByName(String groupName);
}
