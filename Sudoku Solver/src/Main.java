import java.util.*;

public class Main {
	
	public static int[][] board;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		int width = input.nextInt();
		int height = size / width;
		input.nextLine();
		board = buildBoard(size);
		
		int row = 0;
		int column = 0;
		boolean solved = false;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if(line.equals("0")) {
				solved = solve(size, width, height);
				if(solved) {
					System.out.println("\n\nSolved:\n");
					printBoard(board, size, width, height);
				}
				else {
					System.out.println("CAN'T! WON'T!\n");
				}
				break;
			}
			else if(line.length() == 3) {
				Scanner ls = new Scanner(line);
				solved = solve(size, width, height);
				if(solved) {
					System.out.println("Solved:\n");
					printBoard(board, size, width, height);
				}
				else {
					System.out.println("CAN'T! WON'T!\n");
				}
				size = ls.nextInt();
				width = ls.nextInt();
				height = size / width;
				row = 0;
				ls.close();
			}
			else {
				Scanner ls = new Scanner(line);
				int i = 0;
				while(i < size) {
					board[row][column] = ls.nextInt(36);
					i++;
					column++;
				}
				if(row < size) {
					row++;
					column = 0;
				}
				ls.close();
			}
			
		}
		input.close();
	}

	private static boolean solve(int size, int width, int height) {
		boolean status = true;
		int column = 0;
		int row = 0;
		status = solveRow(row, column, size, width, height);
		return status;
	}

	private static boolean solveRow(int row, int column, int size, int width, int height) {
		if(column == size) {
			column = 0;
			row++;
		}
		if(row == size) {
			return true;
		}
		if(board[row][column] != 0) {
			return solveRow(row, column + 1, size, width, height);
		}
		
		for(int i = 1; i <= size; i++) {
			if(isValid(size, width, height, row, column, i)) {
				board[row][column] = i;
				if(solveRow(row, column + 1, size, width, height)) {
					return true;
				}
			}
		}
		board[row][column] = 0;
		return false;
	}

	private static boolean inRow(int size, int row, int num) {
		for(int i = 0; i < size; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean inColumn(int size, int column, int num) {
		for(int i = 0; i < size; i++) {
			if(board[i][column] == num) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean inBlock(int width, int height, int row, int column, int num) {
		int x = (column / width) * width;
		int y = (row / height) * height;
		int temp = x;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(board[y][x] == num) {
					return false;
				}
				x++;
			}
			y++;
			x = temp;
		}
		return true;
	}
	
	private static boolean isValid(int size, int width, int height, int row, int column, int num) {
		if(inRow(size, row, num) == true && inColumn(size, column, num) == true && 
				inBlock(width, height, row, column, num) == true) {
			return true;
		}
		return false;
	}

	private static void printBoard(int[][] board, int size, int width, int height) {
		for(int i = 0; i < size; i++) {
			if(i % height == 0 && i != 0) {
				System.out.println();
			}
			for(int j = 0; j < size; j++) {
				if(j % width == 0 && j != 0) {
					System.out.print(" ");
				}
				if(j != size - 1) {
					if(board[i][j] > 9) {
						System.out.print(Integer.toString(board[i][j], 36).toUpperCase() + " ");
					}
					else {
						System.out.print(board[i][j] + " ");
					}
				}
				else {
					if(board[i][j] > 9) {
						System.out.print(Integer.toString(board[i][j], 36).toUpperCase() + " ");
						if(j == size - 1) {
							System.out.print(" ");
						}
					}
					else {
						System.out.print(board[i][j] + "  ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] buildBoard(int size) {
		int[][] board = new int[size][size];
		return board;
		}

	
}