package gaming;

import bridges.games.NonBlockingGame;
import bridges.base.*;
import bridges.base.NamedSymbol;

public class Main extends NonBlockingGame {
	public Main(int num, String name, String api) {
		super(num, name, api, 20, 50);
	}
	//adds paddles and balls
	  Paddle player_one, player_two;
	  Ball ball;
	  
	  //adds score and sets game barriers
	  int score1 = 0, score2 = 0;
	  int rows=20;
	  int cols=50;
	  
	  public void handleInput() {
	      // INPUT LOGIC
		  if(keyW() && player_one.y != 0) {
			  player_one.y -= 1;
		  }
		  if(keyS() && player_one.y+(player_one.length) <= (rows-1)) {
			  player_one.y += 1;
		  }
		  if(keyUp() && player_two.y != 0) {
			  player_two.y -= 1;
		  }
		  if(keyDown() && player_two.y+(player_two.length) <= (rows-1)) {
			  player_two.y += 1;
		  }
	  }
	  
	  //draws ball and paddles
	  public void draw() {
		  for(int a=0; a < cols; ++a) {
			  for(int b=0; b<rows; ++b) {
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
		  ball.y -= ball.velocityy;
		  ball.x -= ball.velocityx;
		  if(ball.x == 0 || ball.x == (rows-1)) {
			  ball.velocityx *= -1;
		  }
		  if(ball.y == 1) {
			  ball.velocityx *= 0;
			  ball.velocityy *= 0;
			  score2 += 1;
			  ball.x = rows/2;
			  ball.y = cols/2;
		  }
		  if(ball.y == (cols-2)) {
			  ball.velocityx *= 0;
			  ball.velocityy *= 0;
			  score1 += 1;
			  ball.x = rows/2;
			  ball.y = cols/2;
		  }
	  }
	  
	  //handles score boards
	  public void updateScoreBoard(int score, int score2) {
		  drawSymbol(0, 12, NamedSymbol.values()[score+53], NamedColor.white);
		  drawSymbol(0, 38, NamedSymbol.values()[score2+53], NamedColor.white);
		  if(score == 10 || score2 == 10) {
			  drawSymbol(0, 12, NamedSymbol.none, NamedColor.white);
			  drawSymbol(0, 38, NamedSymbol.none, NamedColor.white);
			  win();
		  }
	  }
	  //win condition, will update, displays winner
	  public void win() {
		  for (int i = 0; i < player_one.length; ++i) {
	    	  setBGColor(player_one.y+i, player_one.x, NamedColor.black);   
	      }
	      for (int j = 0; j < player_two.length; ++j) {
	    	  setBGColor(player_two.y+j, player_two.x, NamedColor.black);   
	      }
		  ball.velocityx = 0;
		  ball.velocityy = 0;
		  if(score1 == 10) {
			  drawSymbol(7, 18, NamedSymbol.P, NamedColor.white);
			  drawSymbol(7, 19, NamedSymbol.L, NamedColor.white);
			  drawSymbol(7, 20, NamedSymbol.A, NamedColor.white);
			  drawSymbol(7, 21, NamedSymbol.Y, NamedColor.white);
			  drawSymbol(7, 22, NamedSymbol.E, NamedColor.white);
			  drawSymbol(7, 23, NamedSymbol.R, NamedColor.white);
			  drawSymbol(7, 25, NamedSymbol.one, NamedColor.white);
			  drawSymbol(7, 27, NamedSymbol.W, NamedColor.white);
			  drawSymbol(7, 28, NamedSymbol.I, NamedColor.white);
			  drawSymbol(7, 29, NamedSymbol.N, NamedColor.white);
			  drawSymbol(7, 30, NamedSymbol.S, NamedColor.white);
			  drawSymbol(8, 19, NamedSymbol.G, NamedColor.white);
			  drawSymbol(8, 20, NamedSymbol.A, NamedColor.white);
			  drawSymbol(8, 21, NamedSymbol.M, NamedColor.white);
			  drawSymbol(8, 22, NamedSymbol.E, NamedColor.white);
			  drawSymbol(8, 24, NamedSymbol.O, NamedColor.white);
			  drawSymbol(8, 25, NamedSymbol.V, NamedColor.white);
			  drawSymbol(8, 26, NamedSymbol.E, NamedColor.white);
			  drawSymbol(8, 27, NamedSymbol.R, NamedColor.white);
		  }
		  if(score2 == 10) {
			  drawSymbol(7, 18, NamedSymbol.P, NamedColor.white);
			  drawSymbol(7, 19, NamedSymbol.L, NamedColor.white);
			  drawSymbol(7, 20, NamedSymbol.A, NamedColor.white);
			  drawSymbol(7, 21, NamedSymbol.Y, NamedColor.white);
			  drawSymbol(7, 22, NamedSymbol.E, NamedColor.white);
			  drawSymbol(7, 23, NamedSymbol.R, NamedColor.white);
			  drawSymbol(7, 25, NamedSymbol.two, NamedColor.white);
			  drawSymbol(7, 27, NamedSymbol.W, NamedColor.white);
			  drawSymbol(7, 28, NamedSymbol.I, NamedColor.white);
			  drawSymbol(7, 29, NamedSymbol.N, NamedColor.white);
			  drawSymbol(7, 30, NamedSymbol.S, NamedColor.white);
			  drawSymbol(8, 19, NamedSymbol.G, NamedColor.white);
			  drawSymbol(8, 20, NamedSymbol.A, NamedColor.white);
			  drawSymbol(8, 21, NamedSymbol.M, NamedColor.white);
			  drawSymbol(8, 22, NamedSymbol.E, NamedColor.white);
			  drawSymbol(8, 24, NamedSymbol.O, NamedColor.white);
			  drawSymbol(8, 25, NamedSymbol.V, NamedColor.white);
			  drawSymbol(8, 26, NamedSymbol.E, NamedColor.white);
			  drawSymbol(8, 27, NamedSymbol.R, NamedColor.white);
		  }
		  
	  }
	  //added a start game condition
	  public void startGame() {
		  int count = 0;
		  double rand = Math.random();
		  double rand2 = Math.random();
		  if(keyQ()) {
			  drawSymbol(7, 17, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 18, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 19, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 20, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 21, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 23, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 25, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 26, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 28, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 29, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 30, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 31, NamedSymbol.none, NamedColor.white);
			  drawSymbol(7, 32, NamedSymbol.none, NamedColor.white);
			  if(rand < .5) {
				  ball.velocityx = -1;
			  }
			  else {
				  ball.velocityx = 1;
			  }
			  if(rand2 > .5) {
				  ball.velocityy = -1;
			  }
			  else
				  ball.velocityy = 1;
			  count++;
			  if(count > 0) {
				  drawSymbol(8, 14, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 15, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 16, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 17, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 18, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 20, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 22, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 23, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 25, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 26, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 27, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 28, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 29, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 31, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 32, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 33, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 34, NamedSymbol.none, NamedColor.white);
				  drawSymbol(8, 35, NamedSymbol.none, NamedColor.white);
			  }
		  }
	  }
	  
	  public void gameLoop() {
		checkHit();
		handleInput();
	    draw();
		ballPlay();
	    updateScoreBoard(score1, score2);
	    startGame();
	  }
	//collision function
	  public void checkHit() {
		  if(ball.y == 3) {
			  if(player_one.y == 0) {
				  if(ball.x == 0 && ball.x <= 3) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 1) {
				  if(ball.x >= 1 && ball.x <= 4) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 2) {
				  if(ball.x >= 2 && ball.x <= 5) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 3) {
				  if(ball.x >= 3 && ball.x <= 6) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 4) {
				  if(ball.x >= 4 && ball.x <= 7) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 5) {
				  if(ball.x >= 5 && ball.x <= 8) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 6) {
				  if(ball.x >= 6 && ball.x <= 9) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 7) {
				  if(ball.x == 7 && ball.x <= 10) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 8) {
				  if(ball.x >= 8 && ball.x <= 11) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 9) {
				  if(ball.x >= 9 && ball.x <= 12) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 10) {
				  if(ball.x == 10 && ball.x <= 13) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 11) {
				  if(ball.x >= 11 && ball.x <= 14) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 12) {
				  if(ball.x >= 12 && ball.x <= 15) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 13) {
				  if(ball.x >= 13 && ball.x <= 16) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 14) {
				  if(ball.x >= 14 && ball.x <= 17) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 15) {
				  if(ball.x >= 15 && ball.x <= 18) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_one.y == 16) {
				  if(ball.x >= 16 && ball.x <= 19) {
					  ball.velocityy *= -1;
				  }
			  }
		  }
		  if(ball.y == cols-4) {
			  if(player_two.y == 0) {
				  if(ball.x == 0 && ball.x <= 3) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 1) {
				  if(ball.x >= 1 && ball.x <= 4) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 2) {
				  if(ball.x >= 2 && ball.x <= 5) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 3) {
				  if(ball.x >= 3 && ball.x <= 6) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 4) {
				  if(ball.x >= 4 && ball.x <= 7) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 5) {
				  if(ball.x >= 5 && ball.x <= 8) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 6) {
				  if(ball.x >= 6 && ball.x <= 9) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 7) {
				  if(ball.x == 7 && ball.x <= 10) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 8) {
				  if(ball.x >= 8 && ball.x <= 11) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 9) {
				  if(ball.x >= 9 && ball.x <= 12) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 10) {
				  if(ball.x == 10 && ball.x <= 13) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 11) {
				  if(ball.x >= 11 && ball.x <= 14) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 12) {
				  if(ball.x >= 12 && ball.x <= 15) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 13) {
				  if(ball.x >= 13 && ball.x <= 16) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 14) {
				  if(ball.x >= 14 && ball.x <= 17) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 15) {
				  if(ball.x >= 15 && ball.x <= 18) {
					  ball.velocityy *= -1;
				  }
			  }
			  if(player_two.y == 16) {
				  if(ball.x >= 16 && ball.x <= 19) {
					  ball.velocityy *= -1;
				  }
			  }
		  }
	  }
	  public void initialize() {
		   // draw players and instructions
		   player_one = new Paddle(3, rows/2);
		   player_two = new Paddle(cols-4, rows/2);
		   ball = new Ball(rows/2, cols/2, 0, 0);
		   drawSymbol(7, 17, NamedSymbol.P, NamedColor.white);
		   drawSymbol(7, 18, NamedSymbol.R, NamedColor.white);
		   drawSymbol(7, 19, NamedSymbol.E, NamedColor.white);
		   drawSymbol(7, 20, NamedSymbol.S, NamedColor.white);
		   drawSymbol(7, 21, NamedSymbol.S, NamedColor.white);
		   drawSymbol(7, 23, NamedSymbol.Q, NamedColor.white);
		   drawSymbol(7, 25, NamedSymbol.T, NamedColor.white);
		   drawSymbol(7, 26, NamedSymbol.O, NamedColor.white);
		   drawSymbol(7, 28, NamedSymbol.S, NamedColor.white);
		   drawSymbol(7, 29, NamedSymbol.T, NamedColor.white);
		   drawSymbol(7, 30, NamedSymbol.A, NamedColor.white);
		   drawSymbol(7, 31, NamedSymbol.R, NamedColor.white);
		   drawSymbol(7, 32, NamedSymbol.T, NamedColor.white);
		   drawSymbol(8, 14, NamedSymbol.P, NamedColor.white);
		   drawSymbol(8, 15, NamedSymbol.R, NamedColor.white);
		   drawSymbol(8, 16, NamedSymbol.E, NamedColor.white);
		   drawSymbol(8, 17, NamedSymbol.S, NamedColor.white);
		   drawSymbol(8, 18, NamedSymbol.S, NamedColor.white);
		   drawSymbol(8, 20, NamedSymbol.Q, NamedColor.white);
		   drawSymbol(8, 22, NamedSymbol.T, NamedColor.white);
		   drawSymbol(8, 23, NamedSymbol.O, NamedColor.white);
		   drawSymbol(8, 25, NamedSymbol.S, NamedColor.white);
		   drawSymbol(8, 26, NamedSymbol.T, NamedColor.white);
		   drawSymbol(8, 27, NamedSymbol.A, NamedColor.white);
		   drawSymbol(8, 28, NamedSymbol.R, NamedColor.white);
		   drawSymbol(8, 29, NamedSymbol.T, NamedColor.white);
		   drawSymbol(8, 31, NamedSymbol.A, NamedColor.white);
		   drawSymbol(8, 32, NamedSymbol.G, NamedColor.white);
		   drawSymbol(8, 33, NamedSymbol.A, NamedColor.white);
		   drawSymbol(8, 34, NamedSymbol.I, NamedColor.white);
		   drawSymbol(8, 35, NamedSymbol.N, NamedColor.white);
	  }
	  
	public static void  main (String args[]) {
    Main g = new Main(5, "dbrow205", "1463390117587");
	
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
	    this.length = 4;
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