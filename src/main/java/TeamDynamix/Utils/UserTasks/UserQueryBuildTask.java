package TeamDynamix.Utils.UserTasks;

import TeamDynamix.Utils.TDXTask;

public class UserQueryBuildTask implements TDXTask {
    private String name;
    private int order;
    private String buttonLabel;
    private String description;
    private boolean status = false;
    private boolean isActive;
    private boolean isConfidential;
    private boolean isEmployee;
    private int userType = 0;
    private String queryString = "ERROR";

    public UserQueryBuildTask(int order, String name, String buttonLabel, String description) {
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
        System.out.println("UserQueryBuild: Need to build the execute function.");
    }

    public void loadInputs(boolean isActive, boolean isConfidential, boolean isEmployee, int userType) {
        this.isActive = isActive;
        this.isConfidential = isConfidential;
        this.isEmployee = isEmployee;
        this.userType = userType;
    }

    public String returnOutput() {
        return queryString;
    }
}
