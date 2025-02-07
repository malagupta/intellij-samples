package com.jetbrains.debugging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DebugStreamsExample {

/**
 * Displays debug results for intermediate operations visually.
 * 1. Add a breakpoint on the first line of main()
 * 2. Run code in debug mode
 * 3. Click on 'Trace Current Stream Chain' in the Debug window
 * 4. Alternate between 'split mode' and 'flat mode'
 * 5. Check out the results after execution of each method
 */

    public static void main(String[] args) {
        int[] result = IntStream.of(10, 87, 97, 43, 121, 20)
                                .flatMap(DebugStreamsExample::factorize)
                                .distinct()
                                .sorted()
                                .toArray();
        System.out.println(Arrays.toString(result));
    }

    private static IntStream factorize(int value) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            while (value % i == 0) {
                factors.add(i);
                value /= i;
            }
        }
        return factors.stream().mapToInt(Integer::intValue);
    }
}



