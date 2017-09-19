import java.util.ArrayList;
import java.util.List;

class LuhnValidator {

    boolean isValid(String candidate) {
        String strippedString = candidate.replaceAll(" ", "");

        if(strippedString.length() == 1) {
            return false;
        }

        if(strippedString.matches("[^0-9]")) {
            return false;
        }

        // double every second digit starting from the end of the string
        Integer doubleMod = strippedString.length() % 2 == 0 ? 0 : 1;

        char [] strippedArray = strippedString.toCharArray();
        List<Integer> doubledNumberArray = new ArrayList<>();
        Integer cur_digit;

        for (int i = 0; i < strippedArray.length; i++) {
            if (i % 2 == doubleMod) {
                cur_digit = Character.getNumericValue(strippedArray[i]) * 2;
                cur_digit = cur_digit > 9 ? cur_digit - 9 : cur_digit;
                doubledNumberArray.add(cur_digit);
            } else {
                doubledNumberArray.add(Character.getNumericValue(strippedString.charAt(i)));
            }
        }

        Integer luhnsum = doubledNumberArray.stream().reduce(0, (a, b) -> a + b);
        return luhnsum % 10 == 0;
    }

}
