import org.json.JSONObject;

public class JSONCheck {
    public static  void main(String[] args) {
        java.lang.String str="{\"name\":\"John\", \"age\":30, \"car\":null}";
        JSONObject json=new JSONObject(str);
        json.put("hello","hello");
        System.out.println(json);


    }
}

