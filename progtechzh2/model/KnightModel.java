package progtechzh2.model;

import java.awt.Point;
import java.util.Random;

public class KnightModel {
    
    private final Field[][] table;
    private final int size;
    private final Random rand = new Random();
    private Point curr = new Point();
    
    public KnightModel(int size){
        this.size = size;
        this.table = new Field[size][size];
        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; j++) {
                this.table[i][j] = new Field();
            }
        }
    }
    
    public void start() {
        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; j++) {
                this.table[i][j].setStatus(Field.EMPTY_FIELD);
            }
        }
        curr.x = rand.nextInt(size);
        curr.y = rand.nextInt(size);
        this.table[curr.x][curr.y].setStatus(Field.ON_FIELD);
    }
    
    public int getFieldStatus(int i, int j) {
        return this.table[i][j].getStatus();
    }
    
    public void moveTo(int i, int j) throws InvalidMoveException {
        if((!(Math.abs(curr.x - i) == 2 && Math.abs(curr.y - j) == 1) &&
           !(Math.abs(curr.x - i) == 1 && Math.abs(curr.y - j) == 2)) ||
            this.table[i][j].getStatus() == Field.VISITED_FIELD) {
            throw new InvalidMoveException("Invalid Move");
        }
        this.table[curr.x][curr.y].setStatus(Field.VISITED_FIELD);
        curr.x = i;
        curr.y = j;
        this.table[i][j].setStatus(Field.ON_FIELD);
    }
    
    public boolean isVictory() {
        boolean b = true;
        for(int i = 0; b && i < size; ++i) {
            for(int j = 0; b && j < size; ++j) {
                b = this.table[i][j].getStatus() != Field.EMPTY_FIELD;
            }
        }
        return b;
    }
}
