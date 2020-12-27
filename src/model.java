import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class model {
    private ArrayList<Entry> entries;

    public Entry createEntry(String body, String user) {
        Entry entry = new Entry(body,user);
        this.entries.add(entry);
        return entry;
    }}
