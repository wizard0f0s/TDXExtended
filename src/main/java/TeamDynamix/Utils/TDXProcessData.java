package TeamDynamix.Utils;

import TeamDynamix.Utils.UserTasks.GetUserListTask;
import TeamDynamix.Utils.UserTasks.UserQueryBuildTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TDXProcessData {

    private static TDXProcessData instance = new TDXProcessData();
    private static String filename = "ProcessData.dat";
    private ObservableList<TDXProcess> processList;

    public static TDXProcessData getInstance() {
        return instance;
    }

    private TDXProcessData() {
        //implement if needed
    }

    public ObservableList<TDXProcess> getProcessList() {
        return processList;
    }

    public void addProcess(TDXProcess process) {
        processList.add(process);
    }

    public void loadProcesses() throws IOException {

        processList = FXCollections.observableArrayList();

        // this will need to read from a file in the future
        UserQueryBuildTask task1 = new UserQueryBuildTask(1, "User Search Options", "Set Search Options",
                "These are bulk search parameters that provide identifying groupings of users.");
        GetUserListTask task2 = new GetUserListTask(2, "Get List of Users", "Get User List",
                "Using the User Query tools, search for a list of users matching these parameters.");
        TDXProcess userGroupBulkProcess = new TDXProcess("User Group Bulk Management",
                "These tasks provide bulk management tools for managing groupings of users and groups within TeamDynamix.");
        userGroupBulkProcess.addTask(task1);
        userGroupBulkProcess.addTask(task2);
        processList.add(userGroupBulkProcess);
    }

    public void saveProcesses() throws IOException {
        // write this to save the objects to a file
    }
}
