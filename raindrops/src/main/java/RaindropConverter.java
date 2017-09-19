class RaindropConverter {

    String convert(int number) {
        StringBuilder raindropSound = new StringBuilder();

        if (number % 3 == 0) {
            raindropSound.append("Pling");
        }

        if (number % 5 == 0) {
            raindropSound.append("Plang");
        }

        if (number % 7 == 0) {
            raindropSound.append("Plong");
        }

        if (raindropSound.length() == 0) {
            raindropSound.append(number);
        }

        return raindropSound.toString();
    }

}
