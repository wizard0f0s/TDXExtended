package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Api.Users.UserListing;
import TeamDynamix.Utils.TDXTask;
import TeamDynamix.Utils.TDX_Authentication;

import java.net.HttpURLConnection;
import java.util.List;

public class GetUserListTask implements TDXTask {

    private String name;
    private int order;
    private String buttonLabel;
    private String description;
    private boolean status = false;
    private TDX_Authentication tdxAuth;
    private HttpURLConnection connection;
    private String baseSite;
    private String apiPath;
    private String method;
    private List<UserListing> userList;

    public GetUserListTask(int order, String name, String buttonLabel, String description) {
        this.order = order;
        this.name = name;
        this.buttonLabel = buttonLabel;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getButtonLabel() {
        return buttonLabel;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void execute() {
        System.out.println("GetUserList: Need to build the execute function.");
    }

    public void loadInputs(TDX_Authentication tdxAuth, HttpURLConnection connection, String baseSite, String apiPath, String method) {
        this.tdxAuth = tdxAuth;
        this.connection = connection;
        this.baseSite = baseSite;
        this.apiPath = apiPath;
        this.method = method;
    }

    public List<UserListing> returnOutput() {
        return userList;
    }
}
