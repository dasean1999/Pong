package gaming;

import bridges.games.NonBlockingGame;
import bridges.base.*;
import bridges.base.NamedSymbol;

public class Main extends NonBlockingGame {
	public Main(int num, String name, String api) {
		super(num, name, api, 20, 50);
	}
	  Paddle player_one, player_two;
	  Ball ball;
	  
	  int score1 = 0, score2 = 0;
	  int rows=20;
	  int cols=50;
	  
	  public void handleInput() {
	      // INPUT LOGIC
		  if(keyUp() && player_one.y != 0) {
			  player_one.y -= 1;
		  }
		  if(keyDown() && player_one.y+(player_one.length) <= (rows-1)) {
			  player_one.y += 1;
		  }
		  if(keyW() && player_two.y != 0) {
			  player_two.y -= 1;
		  }
		  if(keyS() && player_two.y+(player_two.length) <= (rows-1)) {
			  player_two.y += 1;
		  }
	  }
	  
	  //draws ball and paddles
	  public void draw() {
		  for(int a=0; a < cols; a++) {
			  for(int b=0; b<rows; b++) {
				  setBGColor(b,a,NamedColor.black);
			  }
		  }
	      for (int i = 0; i < player_one.length; ++i) {
	    	  setBGColor(player_one.y+i, player_one.x, NamedColor.white);   
	      }
	      for (int j = 0; j < player_two.length; ++j) {
	    	  setBGColor(player_two.y+j, player_two.x, NamedColor.white);   
	      }
	      setBGColor(ball.x, ball.y, NamedColor.white);
	  }
	  
	  //controls ball movement
	  public void ballPlay() {
		  if (ball.y <= (cols-1) && ball.x <= (rows-1)) {
			  ball.y -= ball.velocityy;
			  ball.x -= ball.velocityx;
		  }
		  if(ball.x == 0) {
			  ball.velocityx *= -1;
		  }
		  if(ball.x == 19)
			  ball.velocityx *= -1; 
		  //starts ball in the center, forces it the opposite direction (JUST FOR TEST, NOT ESSENTIAL)
		  if(ball.y == 0 || ball.y == cols-1) {
			  ball.y = cols/2;
			  ball.velocityy *= -1;
			  ball.velocityx *= -1;
		  }
		  
	  }
	  
	  //keeps score
	  public void keepScore() {
		  if(ball.y == 1) {
			  score1 += 1;
		  }
		  if(ball.y == cols-2) {
			  score2 += 1;
		  }
		  updateScoreBoard(score1, score2);
	  }
	  
	  //handles scoreboards
	  public void updateScoreBoard(int score, int score2) {
		  drawSymbol(0, 12, NamedSymbol.values()[score+53], NamedColor.white);
		  drawSymbol(0, 38, NamedSymbol.values()[score2+53], NamedColor.white);
		  if(score == 10 || score2 == 10) {
			  drawSymbol(0, 12, NamedSymbol.none, NamedColor.white);
			  drawSymbol(0, 38, NamedSymbol.none, NamedColor.white);
			  win();
		  }
	  }
	  
	  //win condition, will update
	  public void win() {
		  ball.velocityx = 0;
		  ball.velocityy = 0;
		  ball.y = 0;
		  if(score1 == 10) {
			  
		  }
		  if(score2 == 10) {
			  
		  }
	  }
	  public void initialize() {
	    // draw players
	    player_one = new Paddle(1, rows/2);
	    player_two = new Paddle(cols-2, rows/2);
	    ball = new Ball(rows/2, cols/2, 0, 0);
	  }
	  
	  //collision function
	  public void checkHit() {
		  if(ball.y == player_one.y && player_one.y == ball.x) {
			  ball.velocityy *= -1;
			  ball.velocityx *= -1;
		  }
		 if(ball.y == player_two.y && player_two.y == ball.x) {
			  ball.velocityy *= -1;
			  ball.velocityx *= -1;
		  }
	  }
	  
	  //added a start game condition
	  public void startGame() {
		  if(keyQ()) {
			  ball.velocityx = 1;
			  ball.velocityy = 1;
		  }
	  }
	  
	  public void gameLoop() {
		checkHit();
		handleInput();
	    draw();
	    ballPlay();
	    keepScore();
	    startGame();
	  }
	  
	public static void  main (String args[]) {
    Main g = new Main(0, "username", "API Key");
	
    g.start();
    
	}
	//paddle and ball classes  
	class Paddle {
	  public int x = 0;
	  public int y = 0;
	  public int length = 0;
	  public Paddle(int x, int y) {
	    this.x = x;
	    this.y = y;
	    this.length = 3;
	  }
	}
	
	class Ball {
		public int x = 0;
		public int y = 0;
		public int velocityx = 0;
		public int velocityy = 0;
		public Ball(int x, int y, int vely, int velx) {
			this.x = x;
			this.velocityx = velx;
			this.velocityy = vely;
			this.y = y;
		}
		
	}
}