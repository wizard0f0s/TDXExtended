package TeamDynamix.Utils;

public class QueryStrings {

    public static String BuildUserListQuery(boolean isActive, boolean isConfidential, boolean isEmployee, int userType) {
        return ("isActive=" + isActive + "&isConfidential=" + isConfidential + "&isEmployee=" + isEmployee + "&userType=" + userType);
    }
}
