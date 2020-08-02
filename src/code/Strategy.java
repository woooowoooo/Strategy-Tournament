package code;
public class Strategy {
	private String name;
	public Strategy(String type) {
		name = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	private int greederous(int[][][] data, boolean greedy) {
		int diff = (data[0][0][0] + data[0][1][0]) - (data[1][0][0] + data[1][1][0]);
		if (diff == 0) {
			return random();
		} else if ((diff < 0) ^ greedy) {
			return 0;
		} else {
			return 1;
		}
	}
	private int random() {
		return (int) Math.round(Math.random());
	}
	private int minimize(int[][][] data) {
		int diff = (data[0][0][1] + data[0][1][1]) - (data[1][0][1] + data[1][1][1]);
		if (diff == 0) {
			return random();
		} else if (diff < 0) {
			return 0;
		} else {
			return 1;
		}
	}
	private int copycat(int last) {
		return last;
	}
	private int beatlast(int[][][] data, int last) {
		if (data[0][last][0] == data[1][last][0]) {
			return random();
		} else if (data[0][last][0] < data[1][last][0]) {
			return 0;
		} else {
			return 1;
		}
	}
	public int run(int[][][] data) {
		switch (name) {
			case "AlwaysA":
				return 0;
			case "AlwaysB":
				return 1;
			case "Greedy":
				return greederous(data, true);
			case "Generous":
				return greederous(data, false);
			case "Random":
				return random();
			case "Minimize":
				return minimize(data);
			case "Copycat":
				return copycat(1);
			case "Beatlast":
				return beatlast(data, 1);
			default:
				System.err.println("Not a valid strategy, doing \"Random\".");
				return random();
		}
	}
	public String toString() {
		return name;
	}
	public static void main(String[] args) {
		Strategy strat = new Strategy("Greedy");
		Table bob = new Table();
		bob.setValuesSymmetric(2, 5, 6, 9);
		System.out.println("Strat decides " + strat.run(bob.getValues(true)));
	}
}