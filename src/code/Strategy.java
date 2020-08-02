package code;
public class Strategy {
	private String name;
	public Strategy(String type) {
		name = type;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public int run(int[][][] data) {
		switch (this.name) {
			case "AlwaysA":
				return 0;
			case "AlwaysB":
				return 1;
			case "Greedy":
				if (data[0][0][0] + data[0][1][0] >= data[1][0][0] + data[1][1][0]) {
					return 0;
				} else {
					return 1;
				}
			case "Generous":
				if (data[0][0][0] + data[0][1][0] <= data[1][0][0] + data[1][1][0]) {
					return 0;
				} else {
					return 1;
				}
			case "Random":
				return (int) Math.round(Math.random());
			case "Minimize":
				if (data[0][0][1] + data[0][1][1] <= data[1][0][1] + data[1][1][1]) {
					return 0;
				} else {
					return 1;
				}
			case "Copycat":
			case "Beatlast":
			default:
				return 0;
		}
	}
	public static void main(String[] args) {
		Strategy strat = new Strategy("Greedy");
		Table bob = new Table();
		bob.setValuesSymmetric(2, 5, 6, 9);
		System.out.println("Strat decides " + strat.run(bob.getValues(true)));
	}
}