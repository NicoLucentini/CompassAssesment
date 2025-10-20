package org.lucentininicolas;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

public class JaroWinklerComparer {
    public static JaroWinklerSimilarity comparer = new JaroWinklerSimilarity();

    public static double compare(String a, String b){
        return comparer.apply(a,b);
    }
}
