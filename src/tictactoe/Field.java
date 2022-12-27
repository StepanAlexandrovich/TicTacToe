package tictactoe;

class Field { 
    private Matrix matrix = new Matrix(PS.width,PS.height);
    private int length = matrix.getLength();
    private String symbolEmpty = PS.symbolEmpty;
     
    //// GET SET ////
    int getLength(){ return length; }
    
    Matrix getMatrix(){
        return matrix.copy();
    }
    
    void setMatrix(Matrix matrix){
        this.matrix = matrix;
    }
    //// ACTION ////
    void randomStart(String symbol){
        reset();
        matrix.setSymbol((int)(Math.random()*length),symbol);
    }
    
    boolean move(String symbol,int index){
        if(
                index>=0 && 
                index<length && 
                matrix.getSymbol(index).equals(symbolEmpty)){ 
            
            matrix.setSymbol(index,symbol);
            return true;
        }
        return false; 
    }
    
    void resetMove(int index){
        matrix.setSymbol(index,symbolEmpty);
    }
    
    void reset(){
        matrix.fill(symbolEmpty);
    }
     
}
