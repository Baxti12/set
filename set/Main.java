import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.reverse(sortedList);
        System.out.println(sortedList);

        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.clear();
        System.out.println(set);

        HashSet<Integer> cloneSet = new HashSet<>(set);
        System.out.println(cloneSet);

        ArrayList<Integer> arrayList = new ArrayList<>(cloneSet);
        System.out.println(arrayList);

        for (int i = 0; i < arrayList.size(); i += 2) {
            System.out.println(arrayList.get(i));
        }

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println(getCommonElements(set1, set2));
        System.out.println(getUniqueElements(set1, set2));
        System.out.println(getFirstUnique(set1, set2));
        System.out.println(getSecondUnique(set1, set2));
        System.out.println(getEvenElements(set1, set2));
    }

    public static ArrayList<Integer> getCommonElements(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        return new ArrayList<>(common);
    }

    public static ArrayList<Integer> getUniqueElements(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> unique = new HashSet<>(set1);
        unique.addAll(set2);
        unique.removeAll(getCommonElements(set1, set2));
        return new ArrayList<>(unique);
    }

    public static ArrayList<Integer> getFirstUnique(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> firstUnique = new HashSet<>(set1);
        firstUnique.removeAll(set2);
        return new ArrayList<>(firstUnique);
    }

    public static ArrayList<Integer> getSecondUnique(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> secondUnique = new HashSet<>(set2);
        secondUnique.removeAll(set1);
        return new ArrayList<>(secondUnique);
    }

    public static ArrayList<Integer> getEvenElements(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> combined = new HashSet<>(set1);
        combined.addAll(set2);
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : combined) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }
}
