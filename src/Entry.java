import java.io.Serializable;
import java.sql.Timestamp;

public class Entry implements Serializable {
    String body;
    String user;
   String datum;
   String id;

    /**
     *Jag har returnad body,datum och user för att få tillbaka resultat
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

   public String getId() { return id; }

    public Entry(String s, String body, String user, String datum) {
        this.body = body;
        this.user = user;
        this.datum=datum;
        this.id= id;
    }

}
