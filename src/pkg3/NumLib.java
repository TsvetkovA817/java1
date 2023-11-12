package pkg3;

public class NumLib {

    public boolean evenOddNumber(int pNum) {
        if (pNum % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numberInInterval(int pNum) {
        final int mIntStart=25;
        final int mIntEnd=100;
        if (pNum>=mIntStart && pNum <=mIntEnd) {
            return true;
        } else {
            return false;
        }
    }

}
