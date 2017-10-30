package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length;col++) {
				pic[row][col] = " ";
			}
		}
		//drawHorizontalLine(pic,1);
		//drawVerticalLine(pic,2);
		//drawSlot(pic,4,5);
		drawBox(pic,1,4);
		print(pic);
		
	}
	/**
	 * draws
	 * 	_
	 * |*|
	 * |_|
	 * that star is row,col
	 * @param pic
	 * @param row
	 * @param col
	 */
	private static void drawBox(String[][] pic, int row, int col) {
		drawSlot(pic,row,col);
		if(row > 0)
			for(int i = col-1; i <= col + 1; i++) {
				pic[row-1][i] = "_";
			}
		if(row < pic.length-1) {
			drawSlot(pic,row+1,col);
			pic[row+1][col] = "_";
		}
		
	}
	/**
	 * a slot looks like this :
	 * ||
	 * It is two vertical lines with a space between them
	 * The coordinates row,col are the coordinates of the space
	 * in other words a slot is a vertical in front of row, col and after row, column
	 * @param pic
	 * @param row
	 * @param column
	 */
	private static void drawSlot(String[][] pic, int row, int col) {
		if(col ==0 && col != pic[row].length-1)
			pic[row][col+1] = "|";
		else if(col == pic[row].length-1 && col != 0)
			pic[row][col-1] = "|";
		else if (col != pic[row].length-1 && col != 0) {
			pic[row][col-1] = "|";
			pic[row][col+1] = "|";
		}
		
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length;row++) {
			pic[row][col] = "|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length;col++) {
			pic[row][col] = "_";
		}
	}
	
	/**
	 * prints contents of pics, row by row
	 * no brackets or commas
	 * @param pic
	 */
	private static void print(String[][] pic) {
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length;col++) {
				if(col == pic[row].length-1)
					System.out.println(pic[row][col]);
				else
					System.out.print(pic[row][col]);
			}
		}
		
	}

}
