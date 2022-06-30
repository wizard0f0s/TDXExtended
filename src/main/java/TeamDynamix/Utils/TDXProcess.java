package TeamDynamix.Utils;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.List;

public class TDXProcess {

    private ObservableList<TDXTask> taskList;
    private final String name;
    private final String description;


    public TDXProcess(String name, String description) {
        this.name = name;
        this.description = description;
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
}
