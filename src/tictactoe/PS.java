package tictactoe;

class PS {
    // final
    final static int width = 6;
    final static int height = 5;
    final static int lengthVector = 4;
    final static int multiplication = 50;
    final static int widthMult = width*multiplication;
    final static int heightMult = height*multiplication;
    
    final static String symbolEmpty = "";
    final static String symbolStart = "X";
    final static String symbolFinish = "0";
    final static String draw = "draw";
    final static String process = "process";
    
    // dynamic
    private static int depth = 7;
    private static String symbolPC = symbolStart;
    private static String symbolUser = symbolFinish;
    
    static String getSymbolPC()   { return symbolPC;   }
    static String getSymbolUser() { return symbolUser; }
    static int    getDepth()      { return depth;      }
    
    // function
    static String switchX0(String symbol){
        if(symbol.equals(symbolStart)) { 
            return symbolFinish; 
        }else { 
            return symbolStart ; 
        }
    }
    
    static String switchPcUser(){
        symbolPC = switchX0(symbolPC);
        symbolUser = switchX0(symbolUser);
        return symbolUser;
    }
    
    static int getLevel(){ return depth - 3; }
    
    static int switchLevel(){
        if(depth<9) { depth++;   }
        else        { depth = 4; }
        return getLevel();
    }
    
    
}
