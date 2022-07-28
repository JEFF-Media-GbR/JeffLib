package com.jeff_media.jefflib.tests;

import com.jeff_media.jefflib.data.tuples.Pair;
import com.jeff_media.jefflib.data.tuples.Quartet;
import com.jeff_media.jefflib.data.tuples.Quintet;
import com.jeff_media.jefflib.data.tuples.Triplet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestTuples {

    private final Integer first = 1;
    private final Integer second = 2;
    private final Integer third = 3;
    private final Integer fourth = 4;
    private final Integer fifth = 5;

    private final Pair<Integer, Integer> pair1 = Pair.of(first, second);
    private final Pair<Integer, Integer> pair2 = Pair.of(first, second);
    private final Triplet<Integer, Integer, Integer> triplet1 = Triplet.of(first, second, third);
    private final Triplet<Integer, Integer, Integer> triplet2 = Triplet.of(first, second, third);
    private final Quartet<Integer, Integer, Integer, Integer> quartet1 = Quartet.of(first, second, third, fourth);
    private final Quartet<Integer, Integer, Integer, Integer> quartet2 = Quartet.of(first, second, third, fourth);
    private final Quintet<Integer, Integer, Integer, Integer, Integer> quintet1 = Quintet.of(first, second, third, fourth, fifth);
    private final Quintet<Integer, Integer, Integer, Integer, Integer> quintet2 = Quintet.of(first, second, third, fourth, fifth);

    @Test
    public void testToString() {
        Assertions.assertEquals("Pair{first=1, second=2}", pair1.toString());
        Assertions.assertEquals("Triplet{first=1, second=2, third=3}", triplet1.toString());
        Assertions.assertEquals("Quartet{first=1, second=2, third=3, fourth=4}", quartet1.toString());
        Assertions.assertEquals("Quintet{first=1, second=2, third=3, fourth=4, fifth=5}", quintet1.toString());
    }

    @Test
    public void assertEquals() {
        Assertions.assertEquals(pair1, pair2);
        Assertions.assertEquals(triplet1, triplet2);
        Assertions.assertEquals(quartet1, quartet2);
        Assertions.assertEquals(quintet1, quintet2);
    }

}
