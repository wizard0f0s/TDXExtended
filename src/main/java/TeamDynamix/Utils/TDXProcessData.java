package TeamDynamix.Utils;

import TeamDynamix.Utils.Processes.UserGroupBulkProcess;
import TeamDynamix.Utils.UserTasks.GetGroupListTask;
import TeamDynamix.Utils.UserTasks.GetUserListTask;
import TeamDynamix.Utils.UserTasks.GroupSearchQueryBuildTask;
import TeamDynamix.Utils.UserTasks.UserQueryBuildTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TDXProcessData {

    private static TDXProcessData instance = new TDXProcessData();
    private static String filename = "ProcessData.dat";
    private ObservableList<TDXProcess> processList;
    private TDXProcess currentProcess;

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

    public TDXProcess getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(TDXProcess currentProcess) {
        this.currentProcess = currentProcess;
    }

    public void loadProcesses() throws IOException {

        processList = FXCollections.observableArrayList();

        // this will need to read from a file in the future
        TDXTask task1 = new UserQueryBuildTask(1, "User Search Options", "Set Search Options",
                "These are bulk search parameters that provide identifying groupings of users.");
        TDXTask task2 = new GetUserListTask(2, "UserSearch", "Get User List",
                "Using the User Query tools, search for a list of users matching these parameters.");
        TDXTask task3 = new GroupSearchQueryBuildTask(3, "Group Search Options", "Set Group Search Options",
                "These are the bulk search parameters that provide a collection of groups to work with.");
        TDXTask task4 = new GetGroupListTask(4, "GroupSearch", "Get Group List",
                "Using the Group Search Query tools, search for a list of groups matching these parameters.");
        TDXProcess userGroupBulkProcess = new UserGroupBulkProcess("User Group Bulk Management",
                "These tasks provide bulk management tools for managing groupings of users and groups within TeamDynamix.");
        userGroupBulkProcess.addTask(task1);
        userGroupBulkProcess.addTask(task2);
        userGroupBulkProcess.addTask(task3);
        userGroupBulkProcess.addTask(task4);

        //Add new processes and tasks here

        processList.add(userGroupBulkProcess);
    }

    public void saveProcesses() throws IOException {
        // write this to save the objects to a file
    }
}
