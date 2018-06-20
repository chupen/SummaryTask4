package ua.nure.teteruk.constant;

public class ServletContextAttributesConstants {
    public static final String USER_SERVICE = "userService";
    public static final String USER_SESSION = "session_user";
    public static final String COMPLETE_TEST_SERVICE = "completeTestService";
    public static final String TAKEN_TESTS_SERVICE = "takenTestsService";

    private ServletContextAttributesConstants(){
        throw new UnsupportedOperationException();
    }
}
