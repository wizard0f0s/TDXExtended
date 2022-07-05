package TeamDynamix.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class TDXProcess {

    private ObservableList<TDXTask> taskList;
    private HashMap<String, Object> taskOutputList;
    private int currentTaskIndex;
    private final String name;
    private final String description;

    private TDXTask currentTask;


    public abstract void saveTaskOutput(String key, Object obj);
    public abstract Object processTask(int taskIndex);


    public TDXProcess(String name, String description) {
        this.name = name;
        this.description = description;
        taskList = FXCollections.observableArrayList();
        taskOutputList = new HashMap<>();
        currentTaskIndex = 0;
    }


    public ObservableList<TDXTask> getTasks() {
        return taskList;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addTask(TDXTask tdxTask) {
        taskList.add(tdxTask);
     }

    public HashMap<String, Object> getTaskOutputs() {
        return taskOutputList;
    }

    public TDXTask getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(TDXTask currentTask) {
        this.currentTask = currentTask;
    }
}
