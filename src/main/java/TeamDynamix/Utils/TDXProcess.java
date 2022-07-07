package TeamDynamix.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

import java.util.HashMap;

public abstract class TDXProcess {

    private ObservableList<TDXTask> taskList;
    private HashMap<String, Object> taskOutputList;
    private int currentTaskIndex;
    private final String name;
    private final String description;
    private TDXTask currentTask;
    private String resultMessage = "";




    public abstract void saveTaskOutput(String key, Object obj);
    public abstract Object processTask(int taskIndex);
    public abstract void validateInput(BorderPane mainBorderPane);
    public abstract boolean getValidated();
    public abstract void execute();


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

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }


}
