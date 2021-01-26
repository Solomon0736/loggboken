import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * den är serializeable så att den spara texterna i filen.
 * den inhåller body,user och datum
 * return den ArrayList tar allt från Entry filen till den har mappen
 */
public class Model implements Serializable {
    private ArrayList<Entry> entries;

    public ArrayList<Entry> getEntries() {
        return entries;
    }
// skapat constructor till Modelen och i den arreylisten sparar entries
    public Model() {
        this.entries = new ArrayList<>();
    }


    /**
     * jag skapat Entery som kommer bifoga till arraylist.
     * @param body den är body som finns entry.
     * @param user den är user som finns entry.
     * @param datum den är datum som finns entry.
     * @return  skapa entry
     */
    public Entry createEntry(String body, String user,String datum) {
        Entry entry = new Entry(body,user,datum);
        this.entries.add(entry);
        return entry;

    }}
