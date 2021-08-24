
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        if (size % 2 == 0) {
            return null;
        }

        MagicSquare square = new MagicSquare(size);

        int fill = 1;
        
        int pointerX = size / 2;
        int pointerY = 0;
        
        int lastX = 0;
        int laxtY = 0;

        while (fill <= (size * size)) {

            if (square.readValue(pointerX, pointerY) == 0) {

                square.placeValue(pointerX, pointerY, fill); // fill square if empty

                fill++; //update fill value

                lastX = pointerX;
                laxtY = pointerY;

                pointerX++; //move pointer to next fill position
                pointerY--;
            } else {

                pointerX = lastX;
                pointerY = laxtY + 1;
            }

            if (pointerX >= square.getWidth()) { //if X position is bigger than array size, return to X = 0

                pointerX = 0;
            }

            if (pointerY < 0) {

                pointerY = square.getHeight() - 1;
            }
        }

        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }

}
