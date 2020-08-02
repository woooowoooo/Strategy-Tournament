package code;
import java.util.Arrays;
public class Table {
	private int[][][] values;
	private int[][][] transpose;
	public Table() {
		values = new int[2][2][2];
		transpose = new int[2][2][2];
	}
	public int getValue(int coord) {
		return values[coord >> 2 & 1][coord >> 1 & 1][coord & 1];
	}
	public void setValue(int coord, int val) {
		int x = coord >> 2 & 1;
		int y = coord >> 1 & 1;
		int z = coord & 1;
		setValue(x, y, z, val);
	}
	public int getValue(int x, int y, int z) {
		return values[x][y][z];
	}
	public void setValue(int x, int y, int z, int val) {
		values[x][y][z] = val;
		transpose[y][x][z ^ 1] = val;
	}
	public int[][][] getValues() {
		return values;
	}
	public void setValuesSymmetric(int a, int b, int c, int d) {
		values[0][0][0] = a;
		values[0][0][1] = a;
		values[0][1][0] = b;
		values[0][1][1] = c;
		values[1][0][0] = c;
		values[1][0][1] = b;
		values[1][1][0] = d;
		values[1][1][1] = d;
		setTranspose();
	}
	public int[][][] getTranspose() {
		return transpose;
	}
	public void setTranspose() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				transpose[i][j][0] = values[j][i][1];
				transpose[i][j][1] = values[j][i][0];
			}
		}
	}
	public String toString() {
		return Arrays.deepToString(this.values[0]) + "\n" + Arrays.deepToString(this.values[1]);
	}
	public static void main(String[] args) {
		Table bob = new Table();
		System.out.println(bob);
		System.out.println(bob.getValue(3));
	}
}