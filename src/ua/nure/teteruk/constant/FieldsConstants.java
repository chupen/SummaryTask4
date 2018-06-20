package ua.nure.teteruk.constant;

public final class FieldsConstants {
    private FieldsConstants() {
        throw new UnsupportedOperationException();
    }

    //Users
    public static final String USERS_ID = "id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_EMAIL = "email";
    public static final String USERS_ROLE = "role_name";
    public static final String USERS_NAME = "name";
    public static final String USERS_SURNAME = "surname";
    public static final String USERS_BLOCKED = "is_blocked";
    public static final String USERS_GROUP_ID = "groups_id";
    public static final int USERS_BLOCKED_TRUE = 1;
    public static final int USERS_BLOCKED_FALSE = 0;

    //Universities
    public static final String UNIVERSITIES_ID = "id";
    public static final String UNIVERSITIES_NAME = "name";
    public static final String UNIVERSITIES_SPHERE = "sphere";

    //Taken_tests
    public static final String TAKEN_TESTS_ID = "id";
    public static final String TAKEN_TESTS_MARK = "mark";
    public static final String TAKEN_TESTS_PASSED = "is_passed";
    public static final String TAKEN_TESTS_DATE_OF_TAKING = "date_of_taking";
    public static final String TAKEN_TESTS_USER_ID = "users_id";
    public static final String TAKEN_TESTS_TESTS_INFO_ID = "tests_info_id";

    //Complete_tests
    public static final String COMPLETE_TESTS_ANSWER_ID = "answer_id";
    public static final String COMPLETE_TESTS_TEST_QUESTION_ID = "test_questions_id";
    public static final String COMPLETE_TESTS_TEST_INFO_ID = "tests_info_id";
    public static final String COMPLETE_TESTS_ANSWER_TEXT = "answer_text";
    public static final String COMPLETE_TESTS_CORRECT = "is_correct";

    //Tests_info
    public static final String TESTS_INFO_ID = "id";
    public static final String TESTS_INFO_NAME = "name";
    public static final String TESTS_INFO_COMPLEXITY = "complexity";
    public static final String TESTS_INFO_TIME = "time";
    public static final String TESTS_INFO_PASS_MARK = "pass_mark";
    public static final String TESTS_INFO_SUBJECT_ID = "subjects_id";
    public static final String TESTS_INFO_AUTHOR_ID = "author_id";

    //Test_questions
    public static final String TEST_QUESTION_ID = "id";
    public static final String TEST_QUESTION_TEST_INFO_ID = "tests_info_id";
    public static final String TEST_QUESTION_QUESTION_TEXT = "q_text";

    //Subjects
    public static final String SUBJECTS_ID = "id";
    public static final String SUBJECTS_NAME = "name";

    //Faculties
    public static final String FACULTIES_ID = "id";
    public static final String FACULTIES_NAME = "name";
    public static final String FACULTIES_UNIVERSITIES_ID = "universities_id";

    //Groups
    public static final String GROUPS_ID = "id";
    public static final String GROUPS_NAME = "name";
    public static final String GROUPS_FACULTIES_ID = "faculties_id";
}
