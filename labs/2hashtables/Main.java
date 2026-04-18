import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable d = new HashTable();

        int i = 0;

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            boolean removeIt = i % 16 == 0;
            Integer count = d.get(word);
            boolean isPresent = count != null;

            if (isPresent) {
                if (removeIt) {
                    d.remove(word);
                } else {
                    d.put(word, count + 1);
                }
            } else if (!removeIt) {
                d.put(word, 1);
            }
            i++;

        }

        // Hitta max (count, word)
        int maxCount = -1;
        String bestWord = "";

        for (HashTable.Entry entry : d.getAllEntries()) {
            String word = entry.key;
            int count = entry.value;

            if (count > maxCount || (count == maxCount && word.compareTo(bestWord) < 0)) {
                maxCount = count;
                bestWord = word;
            }
        }

        if (d.getAllEntries().isEmpty()) {
            System.out.println("Tom tabell");
            return;
        }
        System.out.println(bestWord + " " + maxCount);
    }
}