package task_3;

public class StudentState {

    private String hashCode = null;
    private String errorText = null;
    private String state = null;

    public String getHashCode() {
        return hashCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getState() {
        return state;
    }

    public StudentState(String hashcode, String errorText, String state){
        this.hashCode = hashcode;
        this.errorText = errorText;
        this.state = state;
    }
}
