package mod;

import cont.JOP;
import view.Board;

public class World {
	
	//Declaring and initializing variables needed to properly execute the code
	private Board _s;
	private Game _m;
	public boolean running = true;
	public boolean on = true;
	public boolean cut = true;
	
	int r1 = 5;
	int r2 = 5;
	int r3 = 5;
	int r4 = 5;
	int r5 = 5;
	int r6 = 5;
	int r7 = 5;
	int cmax = 7;
	int cmin = 0;
	
	int cwin = 0;
	int pwin = 0;
	int cpur = 1;
	int score;
	
	int p1win = 0;
	int p2win = 0;
	int pvpr = 1;
	int score1;
	int score2;
	
	boolean won = false;
	boolean lost = false;
	
	int random = (int) (Math.random() * (cmax - cmin + 1) + cmin);
	
	public World()
	{
		_m = new Game();
		_s = new Board(_m);
		
		//Sets up the infinite loop to play the game 
		while(running == true)
		{
			
			//Determine whether the player wants to play against a computer or someone else
			String response = JOP.in("Type PVP if you want to play against another player\nType CPU if you want to play against a computer\nType Exit at anytime to leave\nType Customize to change the game's icons\nType Menu to come back here\n\nTyping menu will reset all counters and player scores");
			
			if(response.equalsIgnoreCase("exit"))
				System.exit(0);
			
			//Computer
			if (response.equalsIgnoreCase("cpu"))
			{
				//Sets up the infinite loop to play the game 
				on = true;
				while(on == true)
				{
					//Displays the default board
					String map = _s.generateGame();
					String msg = "What column do you want to place your piece in?\nRound Number: " + cpur + ". Player Wins: " + pwin + ". Computer Wins: " + cwin +".\nPlayer Score: " + score + ".";
					String move = JOP.in(map + msg);
					
					if(move.equalsIgnoreCase("exit"))
					System.exit(0);
					
					//Resets all variable and sends the player back to the main menu
					if(move.equalsIgnoreCase("menu"))
					{
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						cwin = 0;
						pwin = 0;
						cpur = 1;
						score = 0;
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						on = false;
					}
					
					//Places the player's move in the selected row
					else if(Integer.parseInt(move) == 1)
					{
						if(r1>-1)
						{
							Game.cfb[r1][Integer.parseInt(move) - 1] = 2;
							r1--;
						}
					}
					else if(Integer.parseInt(move) == 2)
					{
						if(r2>-1)
						{
							Game.cfb[r2][Integer.parseInt(move) - 1] = 2;
							r2--;
						}
					}
					else if(Integer.parseInt(move) == 3)
					{
						if(r3>-1)
						{
							Game.cfb[r3][Integer.parseInt(move) - 1] = 2;
							r3--;
						}
					}
					else if(Integer.parseInt(move) == 4)
					{
						if(r4>-1)
						{
							Game.cfb[r4][Integer.parseInt(move) - 1] = 2;
							r4--;
						}
					}
					else if(Integer.parseInt(move) == 5)
					{
						if(r5>-1)
						{
							Game.cfb[r5][Integer.parseInt(move) - 1] = 2;
							r5--;
						}
					}
					else if(Integer.parseInt(move) == 6)
					{
						if(r6>-1)
						{
							Game.cfb[r6][Integer.parseInt(move) - 1] = 2;
							r6--;
						}
					}
					else if(Integer.parseInt(move) == 7)
					{
						if(r7>-1)
						{
							Game.cfb[r7][Integer.parseInt(move) - 1] = 2;
							r7--;
						}
					}
					
					computerMove();
					checkStates();
					
					//Checks to see if the player won, if so, it resets the game, clears the board, and increases the round number
					if(won == true)
					{
						pwin++;
						score = score + 10 * cpur;
						
						String a = _s.generateGame();
						String aa = "You won!!\nRound Number: " + cpur + "\nPlayer Wins: " + pwin + "\nComputer Wins: " + cwin + "\nPlayer Score: " + score;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						cpur++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						won = false;
					}
					
					//Checks to see if the Computer won, if so, resets the variables, clears the board, and increases the round number
					if(lost == true)
					{
						cwin++;
						
						String a = _s.generateGame();
						String aa = "You lost.\nRound Number: " + cpur + "\nPlayer Wins: " + pwin + "\nComputer Wins: " + cwin +"\nPlayer Score: " + score;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						cpur++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						lost = false;
					}
				}
			}
			
			//Other Player
			if (response.equalsIgnoreCase("pvp"))
			{
				//Sets up the infinite loop to play the game 
				on = true;
				while(on == true)
				{
					//Displays the default board
					cut = true;
					String map = _s.generateGame();
					String msg = "What column does Player 1 want to place their piece in?\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win +".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
					String move = JOP.in(map + msg);
					
					if(move.equalsIgnoreCase("exit"))
					System.exit(0);
					
					//Resets all variable and sends the player back to the main menu
					if(move.equalsIgnoreCase("menu"))
					{
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						p1win = 0;
						p2win = 0;
						pvpr = 1;
						score1 = 0;
						score2 = 0;
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						on = false;
						cut = false;
					}
					
					//Places player 1's move in the selected row
					else if(Integer.parseInt(move) == 1)
					{
						if(r1>-1)
						{
							Game.cfb[r1][Integer.parseInt(move) - 1] = 2;
							r1--;
						}
					}
					else if(Integer.parseInt(move) == 2)
					{
						if(r2>-1)
						{
							Game.cfb[r2][Integer.parseInt(move) - 1] = 2;
							r2--;
						}
					}
					else if(Integer.parseInt(move) == 3)
					{
						if(r3>-1)
						{
							Game.cfb[r3][Integer.parseInt(move) - 1] = 2;
							r3--;
						}
					}
					else if(Integer.parseInt(move) == 4)
					{
						if(r4>-1)
						{
							Game.cfb[r4][Integer.parseInt(move) - 1] = 2;
							r4--;
						}
					}
					else if(Integer.parseInt(move) == 5)
					{
						if(r5>-1)
						{
							Game.cfb[r5][Integer.parseInt(move) - 1] = 2;
							r5--;
						}
					}
					else if(Integer.parseInt(move) == 6)
					{
						if(r6>-1)
						{
							Game.cfb[r6][Integer.parseInt(move) - 1] = 2;
							r6--;
						}
					}
					else if(Integer.parseInt(move) == 7)
					{
						if(r7>-1)
						{
							Game.cfb[r7][Integer.parseInt(move) - 1] = 2;
							r7--;
						}
					}
					
					//Checks if Player 1 won before letting Player 2 go
					checkStates();
					
					if(won == true)
					{
						p1win++;
						score1 = score1 + 10 * pvpr;
						
						String a = _s.generateGame();
						String aa = "Player 1 won\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win + ".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						pvpr++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						won = false;
						cut = false;
					}
					
					if(lost == true)
					{
						p2win++;
						score2= score2 + 10 * pvpr;
						
						String a = _s.generateGame();
						String aa = "Player 2 won\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win + ".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						pvpr++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						lost = false;
						cut = false;
					}
					
					if(cut == true)
					{
					
					String mp = _s.generateGame();
					String mg = "What column does Player 2 want to place their piece in?\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win +".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
					String mve = JOP.in(mp + mg);
					
					if(mve.equalsIgnoreCase("exit"))
					System.exit(0);
					
					//Resets all variable and sends the player back to the main menu
					if(mve.equalsIgnoreCase("menu"))
					{
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						p1win = 0;
						p2win = 0;
						pvpr = 1;
						score1 = 0;
						score2 = 0;
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						on = false;
					}
					
					//Places player 2's move in the selected row
					else if(Integer.parseInt(mve) == 1)
					{
						if(r1>-1)
						{
							Game.cfb[r1][Integer.parseInt(mve) - 1] = 1;
							r1--;
						}
					}
					else if(Integer.parseInt(mve) == 2)
					{
						if(r2>-1)
						{
							Game.cfb[r2][Integer.parseInt(mve) - 1] = 1;
							r2--;
						}
					}
					else if(Integer.parseInt(mve) == 3)
					{
						if(r3>-1)
						{
							Game.cfb[r3][Integer.parseInt(mve) - 1] = 1;
							r3--;
						}
					}
					else if(Integer.parseInt(mve) == 4)
					{
						if(r4>-1)
						{
							Game.cfb[r4][Integer.parseInt(mve) - 1] = 1;
							r4--;
						}
					}
					else if(Integer.parseInt(mve) == 5)
					{
						if(r5>-1)
						{
							Game.cfb[r5][Integer.parseInt(mve) - 1] = 1;
							r5--;
						}
					}
					else if(Integer.parseInt(mve) == 6)
					{
						if(r6>-1)
						{
							Game.cfb[r6][Integer.parseInt(mve) - 1] = 1;
							r6--;
						}
					}
					else if(Integer.parseInt(mve) == 7)
					{
						if(r7>-1)
						{
							Game.cfb[r7][Integer.parseInt(mve) - 1] = 1;
							r7--;
						}
					}
					
					//Checks if Player 2 won
					checkStates();
					
					if(won == true)
					{
						p1win++;
						score1 = score1 + 10 * pvpr;
						
						String a = _s.generateGame();
						String aa = "Player 1 won\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win + ".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						pvpr++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						won = false;
					}
					
					if(lost == true)
					{
						p2win++;
						score2= score2 + 10 * pvpr;
						
						String a = _s.generateGame();
						String aa = "Player 2 won\nRound Number: " + pvpr + ". Player 1 Wins: " + p1win + ". Player 2 Wins: " + p2win + ".\nPlayer 1 Score: " + score1 + ". Player 2 Score: " + score2;
						JOP.msg(a + aa);
						
						r1 = 5;
						r2 = 5;
						r3 = 5;
						r4 = 5;
						r5 = 5;
						r6 = 5;
						r7 = 5;
						pvpr++;
						
						for(int r = 0; r < Game.cfb.length; r++)
						{
							for(int c = 0; c < Game.cfb[0].length; c++)
							{
								while(Game.cfb[r][c] > 0)
								{
									Game.cfb[r][c] = Game.cfb[r][c] - 1;
								}
							}
						}
						lost = false;
					}
				}
				}
				
			}
			
			//Allows the user to customize the icons used on the board
			if(response.equalsIgnoreCase("customize"))
			{
				on = true;
				while(on == true)
				{
				String respons = JOP.in("Type Empty if you want to change the character for the empty spots\nType Player if you want to change the player icon\nType Com if you want to change the computer icon\nType Menu to go back to the menu\n\nChanging the player icon also changes the Player 1 icon\nChanging the computer icon also changes the Player 2 icon");
				
				//Changes the icon for the board's empty spaces
				if (respons.equalsIgnoreCase("empty"))
				{
					String respon = JOP.in("What do you want to change the empty spot icon to?\n\nIt is recommened to change the icons to one character icons, such as O or *");
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					Board._bspace = respon;
					JOP.msg("The icon has been changed.");
				}
				
				//Changes the icon for the player/Player 1
				if (respons.equalsIgnoreCase("player"))
				{
					String respon = JOP.in("What do you want to change the player icon to?\n\nIt is recommened to change the icons to one character icons, such as O or *");
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					Board._ply = respon;
					JOP.msg("The icon has been changed.");
				}
				
				//Changes the icon for the computer/Player 2
				if (respons.equalsIgnoreCase("com"))
				{
					String respon = JOP.in("What do you want to change the computer icon to?\n\nIt is recommened to change the icons to one character icons, such as O or *");
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					Board._comp = respon;
					JOP.msg("The icon has been changed.");
				}
				if (respons.equalsIgnoreCase("menu"))
				{
					on = false;
				}
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				}
				
			}
		}
		
	}

	
	//Method that gets the Computer's move
	public void computerMove()
	{
		
		if(random == 0)
		{
			if(r1>-1)
			{
				Game.cfb[r1][random] = 1;
				r1--;
			}
		}
		if(random == 1)
		{
			if(r2>-1)
			{
				Game.cfb[r2][random] = 1;
				r2--;
			}
		}
		if(random == 2)
		{
			if(r3>-1)
			{
				Game.cfb[r3][random] = 1;
				r3--;
			}
		}
		if(random == 3)
		{
			if(r4>-1)
			{
				Game.cfb[r4][random] = 1;
				r4--;
			}
		}
		if(random == 4)
		{
			if(r5>-1)
			{
				Game.cfb[r5][random] = 1;
				r5--;
			}
		}
		if(random == 5)
		{
			if(r6>-1)
			{
				Game.cfb[r6][random] = 1;
				r6--;
			}
		}
		if(random == 6)
		{
			if(r7>-1)
			{
				Game.cfb[r7][random] = 1;
				r7--;
			}
		}
		
		random = (int) (Math.random() * (cmax - cmin + 1) + cmin);
	}
	
	//Method that checks if anyone won and who won
	public void checkStates()
	{
		int [] states = new int[2];
		states[0] = 0;
		states[1] = 0;
		int[][] temp = Game.cfb;
		//check TOP RIGHT connect fours
		for(int r = 3; r < Game.cfb.length; r++)
		{
			for(int c = 0; c < 4; c++)
			{
				if(temp[r][c] != 0 && temp[r][c] == temp[r-1][c+1] && temp[r][c] == temp[r-2][c+2] && temp[r][c] == temp[r-3][c+3])
				{
					if(temp[r][c] == 1)
					{
						states[0] = 1;
					}
					else
					{
						states[1] = 1;
					}
				}
			}
		}
		
		//check TOP LEFT connect fours
		for(int r = 3; r < Game.cfb.length; r++)
		{
			for(int c = 3; c < Game.cfb[r].length; c++)
			{
				if(temp[r][c] != 0 && temp[r][c] == temp[r-1][c-1] && temp[r][c] == temp[r-2][c-2] && temp[r][c] == temp[r-3][c-3])
				{
					if(temp[r][c] == 1)
					{
						states[0] = 1;
					}
					else
					{
						states[1] = 1;
					}
				}
			}
		}
		
		//check VERTICAL connect fours
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < Game.cfb[r].length; c++)
			{
				if(temp[r][c] != 0 && temp[r][c] == temp[r+1][c] && temp[r][c] == temp[r+2][c] && temp[r][c] == temp[r+3][c])
				{
					if(temp[r][c] == 1)
					{
						states[0] = 1;
					}
					else
					{
						states[1] = 1;
					}
				}
			}
		}
		//check HORIZONTAL connect fours
		for(int r = 0; r < Game.cfb.length; r++)
		{
			for(int c = 0; c < 4; c++)
			{
				if(temp[r][c] != 0 && temp[r][c] == temp[r][c+1] && temp[r][c] == temp[r][c+2] && temp[r][c] == temp[r][c+3])
				{
					if(temp[r][c] == 1)
					{
						states[0] = 1;
					}
					else
					{
						states[1] = 1;
					}
				}
			}
		}
		
		if(states[0] == 1)
		{
			lost = true;
			
		}
		else if(states[1] == 1)
		{
			won = true;
			
		}
	
		
	}

}
