import java.io.Serializable;
import java.sql.Timestamp;

public class Entry implements Serializable {
    String body;
    String user;
   String datum;

    /**
     *
     * @return den
     */
    public String getBody() {
        return body;
    }

    public String getDatum() {
       return datum;
    }

    public String getUser() {
        return user;
    }


    public Entry(String body, String user,String datum) {
        this.body = body;
        this.user = user;
        this.datum=datum;


    }

}
