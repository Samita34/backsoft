package backend.backsoft.dto;

public class ResponseDTO {
    private String codeMessage;
    private Object result;
    private String message;

    public ResponseDTO(Object result) {
        this.codeMessage = "TASK-0000";
        this.result = result;
        this.message = "OK";
    }

    public ResponseDTO(String codeMessage, String message) {
        this.codeMessage = codeMessage;
        this.message = message;
    }

    public String getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseDTO [codeMessage=" + codeMessage + ", message=" + message + ", result=" + result + "]";
    }
}