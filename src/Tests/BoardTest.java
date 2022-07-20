package Tests;

import logic.*;
import io.*;
import ui.*;

import java.util.*;
import java.lang.Math;

import MachineIntellegence.MachineIntellegence;

public class BoardTest {
	
	private static final int TEST_NUMBER = 100;
	
	private static void computerVsRandom() {
		int b = 0;
		int w = 0;
		try {
			for(int i = 0; i < TEST_NUMBER; i++) {
				Board game = new Board();
				ArrayList<String> pos = game.initializePossibleMoves();
				while(!pos.isEmpty()) {
					String st = pos.get((int) (Math.random() * (pos.size() - 1)));
					pos = new ArrayList<String>(game.move(st));
					if(pos.isEmpty()) break;
					st = MachineIntellegence.move(game);
					pos = new ArrayList<String>(game.move(st));
					if(pos.isEmpty()) break;
				}
				if(game.isWin().equals(Board.GameResult.BlackWin)) {	
					b++;
				}
				else if(game.isWin().equals(Board.GameResult.WhiteWin)){
					w++;
				}
			}
			System.out.print("White win = ");
			System.out.println(w);
			System.out.print("Black win = ");
			System.out.println(b);
			
			System.out.print("true: ");
			System.out.println(b + w);
			System.out.print("false: ");
			System.out.println(TEST_NUMBER - b - w);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] argv) {
		try {
			long time1 = System.currentTimeMillis();
			computerVsRandom();
			System.out.println((double)(System.currentTimeMillis() - time1) / 1000);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}