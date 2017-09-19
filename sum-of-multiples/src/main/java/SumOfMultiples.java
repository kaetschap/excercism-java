import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class SumOfMultiples {
    int sum;

    SumOfMultiples(int number, int[] set) {
        // use hashSet: no duplicates allowed
        Set<Integer> multiples = new HashSet<>();

        for (int factor : set) {
            IntStream.range(1, number).filter(i -> (i % factor == 0)).forEach(multiples::add);
        }

        this.sum = multiples.stream().reduce(0, (a,b) -> a + b);
    }

    int getSum() {
        return this.sum;
    }
}
