import java.util.LinkedList;

public class HashTable {

    static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[16];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public Integer get(String key) {
        int index = hash(key);

        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }

        return null;
    }

    public void put(String key, int value) {
        int index = hash(key);

        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        table[index].add(new Entry(key, value));
    }

    public void remove(String key) {
        int index = hash(key);

        for (int i = 0; i < table[index].size(); i++) {
            Entry e = table[index].get(i);

            if (e.key.equals(key)) {
                table[index].remove(i);
                return;
            }
        }
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public LinkedList<Entry> getAllEntries() {
        LinkedList<Entry> allEntries = new LinkedList<>();

        for (LinkedList<Entry> table1 : table) {
            for (Entry e : table1) {
                allEntries.add(e);
            }
        }

        return allEntries;
    }
}