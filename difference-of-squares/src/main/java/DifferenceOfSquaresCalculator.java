import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {
    DifferenceOfSquaresCalculator() {}

    public int computeDifferenceOfSquares(int number) {
        return computeSquareOfSumTo(number) - computeSumOfSquaresTo(number);
    }

    public int computeSumOfSquaresTo(int number) {
        return IntStream
                .rangeClosed(1, number)
                .map(i -> (int) Math.pow(i, 2))
                .sum();
    }

    public int computeSquareOfSumTo(int number) {
        int n = (number + 1) * number / 2;
        return ((int) Math.pow(n, 2));
    }
}