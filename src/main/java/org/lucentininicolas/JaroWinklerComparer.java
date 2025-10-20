package org.lucentininicolas;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

public class JaroWinklerComparer {
    public static JaroWinklerSimilarity comparer = new JaroWinklerSimilarity();

    public static double compare(String a, String b){
        if(a == null || b == null)
            return 0;
        if(a.isEmpty() || b.isEmpty())
            return 0;
        return comparer.apply(a,b);
    }
}
