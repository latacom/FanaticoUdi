package udinova.fanatico.Models.RETROFIT;

/**
 * Created by osboliviadev on 20/6/17.
 */
public class Respuesta<T> {
    public int Code;
    public String DataType;
    public String DateTime;
    public String Message;
    public String Tag;
    public String Title;
    public T Values;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public T getValues() {
        return Values;
    }

    public void setValues(T values) {
        Values = values;
    }

    public boolean respuestaExitosa() {

        if (Code == 0) {
            return true;
        } else if (Code>0) {
            return false;
        }
        return true;
    }
}
