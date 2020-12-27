import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class Model implements Serializable {
    private ArrayList<Entry> entries;

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public Model() {
        this.entries = new ArrayList<>();
    }

    public Entry createEntry(String body, String user) {
        Entry entry = new Entry(body,user);
        this.entries.add(entry);
        return entry;

    }}
