package tictactoe;

class Cycle {
    private Core core = new Core();
    private FrameGame frame = new FrameGame();
    private boolean next = false;

    private void startPosition(){
        next = false;
        frame.update(core.startPosition());
    }

    private void moveUser(){
        frame.setText("Your move");

        while(!core.moveUser( frame.getIndexUser())){
            Helper.sleep(10);
        }

        frame.setText("");
    }
    private void movePC(){
        frame.setText("PC is thinking");

        core.movePC();

        frame.setText("");
    }

    private void updateFrame(){
        frame.update(core.getMatrix());
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
