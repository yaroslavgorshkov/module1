package Task2;

public class Chessboard {

    private final int maxNumberPosition;
    private final int minNumberPosition;
    private final int maxSymbolPosition;
    private final int minSymbolPosition;


    public Chessboard() {
        this.maxNumberPosition = 8;
        this.minNumberPosition = 0;
        this.maxSymbolPosition = 72;
        this.minSymbolPosition = 65;
    }

    public boolean isPositionValid(String position) {
        if (position.length() != 2) {
            return false;
        }

        int symbolPosition = position.charAt(0);
        if (symbolPosition < minSymbolPosition || symbolPosition > maxSymbolPosition) {
            return false;
        }

        char charNumberPosition = position.charAt(1);
        if (!Character.isDigit(charNumberPosition)) {
            return false;
        }
        int intNumberPosition = Character.getNumericValue(charNumberPosition);
        return intNumberPosition != minNumberPosition && intNumberPosition <= maxNumberPosition;
    }

    public boolean isMovingValid(String startPosition, String movingPosition) {
        if (!isPositionValid(movingPosition)) {
            System.out.print("Неправильное положение коня!");
            return false;
        }

        int startPositionSymbol = startPosition.charAt(0);
        int startPositionNumerical = Character.getNumericValue(startPosition.charAt(1));

        int movingPositionSymbol = movingPosition.charAt(0);
        int movingPositionNumerical = Character.getNumericValue(movingPosition.charAt(1));

        return  (startPositionSymbol + 1 == movingPositionSymbol && startPositionNumerical + 2 == movingPositionNumerical) ||
                (startPositionSymbol + 2 == movingPositionSymbol && startPositionNumerical + 1 == movingPositionNumerical) ||
                (startPositionSymbol + 2 == movingPositionSymbol && startPositionNumerical - 1 == movingPositionNumerical) ||
                (startPositionSymbol + 1 == movingPositionSymbol && startPositionNumerical - 2 == movingPositionNumerical) ||
                (startPositionSymbol - 1 == movingPositionSymbol && startPositionNumerical - 2 == movingPositionNumerical) ||
                (startPositionSymbol - 2 == movingPositionSymbol && startPositionNumerical - 1 == movingPositionNumerical) ||
                (startPositionSymbol - 2 == movingPositionSymbol && startPositionNumerical + 1 == movingPositionNumerical) ||
                (startPositionSymbol - 1 == movingPositionSymbol && startPositionNumerical + 2 == movingPositionNumerical);
    }
}
