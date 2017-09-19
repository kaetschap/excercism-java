import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class NaturalNumber {
    int number;
    Classification classification;

    public NaturalNumber(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
        classifyNumber();
    }

    public Classification getClassification() {
        return this.classification;
    }

    private void classifyNumber() {
        int number = this.number;
        List<Integer> integerList = this.getFactors();
        Integer sumOfFactors = integerList.stream().collect(Collectors.summingInt(Integer::intValue));

        if (sumOfFactors == number) {
            this.classification = Classification.PERFECT;
        } else if (sumOfFactors > number) {
            this.classification = Classification.ABUNDANT;
        } else {
            this.classification = Classification.DEFICIENT;
        }
    }

    List<Integer> getFactors() {
        int number = this.number;
        List<Integer> intList = new ArrayList<>();

        if (number == 1) {
            intList.add(0);
            return intList;
        } else {
            intList.add(1);
        }

        for (int i = 2; i < (number / 2)+1; i++) {
            if (intList.contains(i)) {
                break;
            }

            if (number % i == 0) {
                intList.add(i);
                if (i == (number / i)) {
                    break;
                } else {
                    intList.add(number / i);
                }
            }
        }
        return intList;
    }
}
