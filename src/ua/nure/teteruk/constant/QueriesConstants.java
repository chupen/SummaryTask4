package ua.nure.teteruk.constant;

public final class QueriesConstants {
    private QueriesConstants() {
        throw new UnsupportedOperationException();
    }


    //    Users
    public static final String USERS_CREATE = "INSERT INTO users (login, password, email, role_name, name, surname, is_blocked, groups_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String USERS_FIND_BY_LOGIN_OR_EMAIL = "SELECT * FROM users WHERE login=? OR email=?";
    public static final String USERS_DELETE = "DELETE FROM users WHERE login = ?";
    public static final String USERS_UPDATE = "UPDATE users SET login = ?, email = ?, name = ?, surname = ?, groups_id = ?";
    public static final String USERS_UPDATE_FULL = "UPDATE users SET login=?, password = ?, email = ?, role_name = ?, name = ?, surname = ?, is_blocked = ?, groups_id = ? WHERE login=?";
    public static final String USERS_GET_BY_ID = "SELECT * FROM users WHERE id=?";
    public static final String USERS_GET = "SELECT * FROM users WHERE login =?";
    public static final String USERS_GET_ALL = "SELECT * FROM users";
    public static final String USERS_GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? AND password=?";
    public static final String USERS_IS_BLOCKED = "SELECT is_blocked FROM users WHERE login=?";
    public static final String USERS_CHANGE_STATUS = "UPDATE users SET is_blocked=? WHERE login=?";

    //    Universities
    public static final String UNIVERSITIES_CREATE = "INSERT INTO universities (name, sphere) values (?, ?)";
    public static final String UNIVERSITIES_GET_BY_NAME = "SELECT * FROM universities WHERE name=?";
    public static final String UNIVERSITIES_UPDATE_SPHERE = "UPDATE universities SET sphere=? WHERE name=?";
    //    public static final String UNIVERSITIES_UPDATE_NAME = "UPDATE universities SET name=? WHERE id=?";
    public static final String UNIVERSITIES_DELETE = "DELETE FROM universities WHERE name=?";
    public static final String UNIVERSITIES_GET_ALL = "SELECT * FROM universities";

    //    Faculties
    public static final String FACULTIES_CREATE = "INSERT INTO faculties (name, universities_id) VALUES (?, ?)";
    public static final String FACULTIES_DELETE = "DELETE FROM faculties WHERE name=?";
    public static final String FACULTIES_GET_ALL = "SELECT * FROM faculties";
    public static final String FACULTIES_GET_BY_NAME = "SELECT * FROM faculties WHERE name=?";
    //    public static final String FACULTIES_UPDATE_
    public static final String FACULTIES_GET_BY_UNIVERSITY_ID = "SELECT * FROM faculties WHERE universities_id = ?";

    //  Groups
    public static final String GROUPS_CREATE = "INSERT INTO st4.groups (name, faculties_id) VALUES (?, ?)";
    public static final String GROUPS_GET = "SELECT * FROM st4.groups WHERE id=?";
    public static final String GROUPS_GET_ALL = "SELECT * FROM st4.groups";
    public static final String GROUPS_DELETE = "DELETE FROM st4.groups WHERE name=?";
    public static final String GROUPS_GET_BY_NAME = "SELECT * FROM st4.groups WHERE name=?";

    // CompleteTests
    public static final String COMPLETE_TESTS_CREATE = "INSERT INTO complete_tests (test_questions_id, tests_info_id, answer_text, is_correct) VALUES (?,?,?,?)";
    public static final String COMPLETE_TESTS_GET_ALL = "SELECT * FROM complete_tests";
    public static final String COMPLETE_TESTS_GET_ALL_CORRECT_BY_TEST_INFO_ID_AND_TEST_QUESTION_ID = "SELECT * FROM complete_tests WHERE tests_info_id=? AND test_questions_id=? AND is_correct=1";
    public static final String COMPLETE_TESTS_GET_BY_TEST_INFO_ID_AND_TEST_QUESTION_ID = "SELECT * FROM complete_tests WHERE tests_info_id=? AND test_questions_id=?";
    public static final String COMPLETE_TESTS_UPDATE = "UPDATE complete_tests SET answer_text=?, is_correct=? WHERE answer_id=? AND test_questions_id=? AND tests_info_id=?";
    public static final String COMPLETE_TESTS_DELETE = "DELETE FROM complete_tests WHERE answer_id=? AND test_questions_id=? AND tests_info_id=?";
    public static final String COMPLETE_TESTS_DELETE_BY_TEST_INFO_ID = "DELETE FROM complete_tests WHERE tests_info_id=?";

    // Subjects
    public static final String SUBJECTS_CREATE = "INSERT INTO subjects (name) VALUES (?)";
    public static final String SUBJECTS_GET = "SELECT * FROM subjects WHERE id=?";
    public static final String SUBJECTS_GET_ALL = "SELECT * FROM subjects";
    public static final String SUBJECTS_DELETE = "DELETE FROM subjects WHERE id=?";

    // TestsInfo
    public static final String TESTS_INFO_CREATE = "INSERT INTO tests_info (name, complexity, time, pass_mark, subjects_id, author_id) VALUES (?,?,?,?,?,?)";
    public static final String TESTS_INFO_GET = "SELECT * FROM tests_info WHERE id=?";
    public static final String TESTS_INFO_UPDATE = "UPDATE tests_info SET name=?, complexity=?, time=?, pass_mark=?, subjects_id=?, author_id=? WHERE id=?";
    public static final String TESTS_INFO_GET_BY_NAME = "SELECT * FROM tests_info WHERE name=?";
    public static final String TESTS_INFO_GET_ALL = "SELECT * FROM tests_info";
    public static final String TESTS_INFO_GET_BY_SUBJECT_ID = "SELECT * FROM tests_info WHERE subjects_id=?";
    public static final String TESTS_INFO_SORT_BY_COMPLEXITY = "SELECT * FROM tests_info ORDER BY complexity";
    public static final String TESTS_INFO_SORT_BY_NAME = "SELECT * FROM tests_info ORDER BY name";
    public static final String TESTS_INFO_DELETE = "DELETE FROM tests_info WHERE name=?";

    // TestQuestions
    public static final String TEST_QUESTIONS_CREATE = "INSERT INTO test_questions (tests_info_id, q_text) VALUES (?,?)";
    public static final String TEST_QUESTIONS_GET = "SELECT * FROM test_questions WHERE id=?";
    public static final String TEST_QUESTIONS_GET_BY_TEST_INFO_ID = "SELECT * FROM test_questions WHERE tests_info_id=?";
    public static final String TEST_QUESTIONS_GET_ALL = "SELECT * FROM test_questions";
    public static final String TEST_QUESTION_BET_BY_TEST_INFO_ID_AND_QUESTION_TEXT = "SELECT * FROM test_questions WHERE tests_info_id=? AND q_text=?";
    public static final String TEST_QUESTIONS_UPDATE = "UPDATE test_questions SET q_text=? WHERE id=? AND tests_info_id=?";
    public static final String TEST_QUESTIONS_DELETE = "DELETE FROM test_questions WHERE id=? AND tests_info_id=?";
    public static final String TEST_QUESTIONS_DELETE_BY_TEST_INFO_ID = "DELETE FROM test_questions WHERE tests_info_id=?";

    //TakenTests
    public static final String TAKEN_TESTS_CREATE = "INSERT INTO taken_tests (mark, is_passed, date_of_taking, users_id, tests_info_id) VALUES (?,?,?,?,?)";
    public static final String TAKEN_TESTS_GET_BY_USER_ID = "SELECT * FROM taken_tests WHERE users_id=?";
    public static final String TAKEN_TESTS_GET_ALL = "SELECT * FROM taken_tests";
    public static final String TAKEN_TESTS_DELETE = "DELETE FROM taken_tests WHERE  id=?";
    public static final String TAKEN_TESTS_DELETE_BY_TEST_INFO_ID = "DELETE FROM taken_tests WHERE tests_info_id=?";
}
