package code;
public class Tournament {
	private Strategy[] strats;
	private Table data;
	public Tournament() {
		String[] names = {"AlwaysA", "AlwaysB", "Greedy", "Generous", "Random", "Minimize", "Copycat", "Beatlast"};
		strats = new Strategy[8];
		for (int i = 0; i < 8; i++) {
			this.strats[i] = new Strategy(names[i]);
		}
	}
	public Tournament(String[] names) {
		for (int i = 0; i < 8; i++) {
			this.strats[i] = new Strategy(names[i]);
		}
	}
	public void runTournament(int repeats) {
		int[] scores = new int[8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int[] results = runMatch(strats[i], strats[j], repeats);
				scores[i] += results[0];
				scores[j] += results[1];
			}
		}
	}
	public int[] runMatch(Strategy a, Strategy b, int repeats) {
		int[] results = {0, 0};
		for (int i = 0; i < repeats; i++) {
			int choiceA = a.run(data.getValues(false));
			int choiceB = b.run(data.getValues(true));
			results[0] += data.getValue(choiceA, choiceB, 0);
			results[1] += data.getValue(choiceA, choiceB, 1);
		}
		return results;
	}
	public static void main(String[] args) {
		Tournament smth = new Tournament();
		smth.runTournament(6);
	}
}