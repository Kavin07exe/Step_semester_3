package week11.class_problems;

import java.util.*;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] ids) {
        HashSet<String> set = new HashSet<>();

        for (String id : ids) {
            if (!set.add(id))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] ids = new String[n];

        for (int i = 0; i < n; i++)
            ids[i] = sc.next();

        System.out.println(hasDuplicate(ids));

        sc.close();
    }
}