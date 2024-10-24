package lab01;

public class CoinFlipExperiment {
	
	static public int coinFlipExperiment(){
		int winnings = 0;
		for (int count = 0; count <= 100; count++) {
		double flip = Math.random();
			if (flip < 0.505) {
				winnings += 1;
			}
			else {
				winnings -= 1;
			}
		count ++;
	}
		return winnings;
}

	public static void main(String[] args) {
		int amount = coinFlipExperiment();
		System.out.println("Win/loss amount: " + amount);
     } //end of main method
} //end of CoinFLipExperiment class