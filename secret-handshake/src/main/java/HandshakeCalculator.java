import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signalList = new ArrayList<>();

        if (bitSet(number, 1)) {
            signalList.add(Signal.WINK);
        }

        if (bitSet(number, 2)) {
            signalList.add(Signal.DOUBLE_BLINK);
        }

        if (bitSet(number, 3)) {
            signalList.add(Signal.CLOSE_YOUR_EYES);
        }

        if (bitSet(number, 4)) {
            signalList.add(Signal.JUMP);
        }

        if (bitSet(number, 5)) {
            Collections.reverse(signalList);
        }

        return signalList;
    }

    private boolean bitSet(int number, int place) {
        int binaryPower = ((int)Math.pow(2, place-1));
        return ((number & binaryPower) == binaryPower);
    }
}
