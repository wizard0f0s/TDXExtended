package TeamDynamix.Utils;

public interface TDXTask {

    String getName();
    int getOrder();
    String getButtonLabel();
    String getDescription();
    boolean getStatus();
    void execute();
}
