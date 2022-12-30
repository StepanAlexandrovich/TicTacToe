package tictactoe;

class Core {  
    //// игровая платформа
    private Field field = new Field();
    private Winner winner = new Winner();
    private Counter counter = new Counter();
        
    Matrix getMatrix(){
        return field.getMatrix();
    }
    
    Matrix startPosition(){   
        if(PS.getSymbolPC().equals(PS.symbolStart)){
            field.randomStart(PS.getSymbolPC());
        }else{
            field.reset();
        }
        return field.getMatrix();
    }
    
    boolean movePC(){
        int position = counter.process(PS.getSymbolPC(),field.getMatrix());
        return field.move(PS.getSymbolPC(), position);
    }
    
    boolean moveUser(int position){
        return field.move(PS.getSymbolUser(), position);
    }
    
    boolean gameOver(){
        if(winner.getWinner(field.getMatrix()).equals(PS.process)){
            return false;
        }else{
            return true;
        }
    }
    
    String getResult(){
        if(winner.getWinner(field.getMatrix()).equals(PS.getSymbolPC())  ) { return "YOU LOST"; }else
        if(winner.getWinner(field.getMatrix()).equals(PS.getSymbolUser())) { return "YOU WON" ; }else
        if(winner.getWinner(field.getMatrix()).equals(PS.draw))            { return PS.draw;    }else    
        return PS.process;
    }
    
    
}
