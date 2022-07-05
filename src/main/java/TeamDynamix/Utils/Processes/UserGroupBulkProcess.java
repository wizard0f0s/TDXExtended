package TeamDynamix.Utils.Processes;

import TeamDynamix.Utils.TDXProcess;

public class UserGroupBulkProcess extends TDXProcess {

    public UserGroupBulkProcess(String name, String description) {
        super(name, description);
    }

    @Override
    public void saveTaskOutput(String key, Object obj) {
        super.getTaskOutputs().put(key, obj);
    }

    @Override
    public Object processTask(int taskIndex) {

        switch (taskIndex) {
            case 0:
                //nothing to do here
                break;
            case 1:
                // pass in the query string from step 1 (index 0)
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return null;
    }
}
