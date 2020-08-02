package code;
import java.util.Arrays;
public class Table {
	private int[][][] values;
	public Table() {
		values = new int[2][2][2];
	}
	public int getValue(int x, int y, int z) {
		return values[x][y][z];
	}
	public int getValue(int coord) {
		int x = coord >> 2 & 1;
		int y = coord >> 1 & 1;
		int z = coord & 1;
		return values[x][y][z];
	}
	public int[][][] getValues(boolean transpose) {
		if (!transpose) {
			return values;
		} else {
			return getTranspose();
		}
	}
	public void setValue(int x, int y, int z, int val) {
		values[x][y][z] = val;
	}
	public void setValue(int coord, int val) {
		int x = coord >> 2 & 1;
		int y = coord >> 1 & 1;
		int z = coord & 1;
		setValue(x, y, z, val);
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
	}
	public int[][][] getTranspose() {
		int[][][] trans = new int[2][2][2];
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				for (int z = 0; z < 2; z++) {
					trans[x][y][z] = values[y][x][z ^ 1];
				}
			}
		}
		return trans;
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