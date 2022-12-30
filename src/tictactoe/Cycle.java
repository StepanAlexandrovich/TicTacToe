package tictactoe;

class Cycle {
    private Core core = new Core();
    private FrameGame frame = new FrameGame();
    private boolean next = false;

    private int lastMove = -1;

    private void startPosition(){
        next = false;
        lastMove = -1;
        frame.update(core.startPosition(),lastMove);
    }

    private void moveUser(){
        frame.setText("Your move");

        do{
            lastMove = core.moveUser( frame.getIndexUser());
            Helper.sleep(10);
        }while(lastMove ==-1);

        frame.setText("");
    }
    private void movePC(){
        frame.setText("PC is thinking");

        lastMove = core.movePC();

        frame.setText("");
    }

    private void updateFrame(){
        frame.update(core.getMatrix(),lastMove);
    }

    private String frameSettings(){
        return new FrameSettings(core.getResult()).process();
    }

    private void process(){
        startPosition();

        while(true){
            if(next = !next){ moveUser();}
            else            { movePC(); }

            updateFrame();

            if(core.gameOver()){
                switch(frameSettings()){
                    case "restart": startPosition();      break;
                    case "close":   System.exit(0); break;
                }
            }
        }

    }

    ///////////////////////////////////////////
    public static void main(String[] args) { new Cycle().process(); }
    
}
