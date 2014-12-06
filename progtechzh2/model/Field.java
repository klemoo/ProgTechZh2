package progtechzh2.model;

public class Field {
    
    public static final int ON_FIELD = 0;
    public static final int VISITED_FIELD = 1;
    public static final int EMPTY_FIELD = 2;
    
    private int status;
    
    public Field() {
        this.status = EMPTY_FIELD;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        ///exp if nem 1,2,3
        this.status = status;
    }
}

