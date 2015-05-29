#include <iostream>

void flag_coins (int *coins, char *coin_tracker, int coins_per_side, char op) ;
int main () {
	int cases;
	std::cin >> cases;
	while (cases-->0) {
		int num_coins, num_weighings;
		std::cin >> num_coins >> num_weighings;
		char coin_tracker[num_coins+1];
		// P = Possible Fake
		// R = Real
		// B = big
		// S = small
		for (int i=1; i<=num_coins; i++)
			coin_tracker[i] = 'P';
		while (num_weighings-->0) {
			int coins_per_side;
			std::cin >> coins_per_side;
			int coins[coins_per_side*2+1];
			for (int i=1; i<=2*coins_per_side; i++) {
				std::cin >> coins[i];
			}
			char comp; // >, =, <
			std::cin >> comp;
			switch (comp) {
				case '=':
					for (int i=1; i<=coins_per_side*2; i++)
						coin_tracker[coins[i]] = 'R';
					break;
				case '<':
					// Coins that weren't weighed are real
					for (int i=1; i<=num_coins; i++) {
						if (coin_tracker[i]!='R') {
							bool found = false;
							for (int j=1; j<=coins_per_side*2; j++) {
								if (coins[j]==i)
									found = true;
							}
							if (!found)
								coin_tracker[i]='R';
						}
					}
					flag_coins (coins, coin_tracker, coins_per_side, '<');
					break;
				case '>':
					for (int i=1; i<=num_coins; i++) {
						if (coin_tracker[i]!='R') {
							bool found = false;
							for (int j=1; j<=coins_per_side*2; j++) {
								if (coins[j]==i)
									found = true;
							}
							if (!found)
								coin_tracker[i]='R';
						}
					}
					flag_coins (coins, coin_tracker, coins_per_side, '>');
					break;
				default:
					break;
			}
		}
		int count = 0;
		int false_coin = 0;
		for (int i=1; i<=num_coins; i++) {
			if (coin_tracker[i]!='R')
				count+=1;
		}
		if (count==1)
			std::cout << false_coin << std::endl << std::endl;
		else
			std::cout << 0 << std::endl << std::endl;

	}
}

void flag_coins (int *coins, char *coin_tracker, int coins_per_side, char op) {
	if (op=='>') {
		for (int i=1; i<=coins_per_side; i++) {
			if (coin_tracker[coins[i]]=='S')
				coin_tracker[coins[i]] = 'R';
			else if (coin_tracker[coins[i]]=='P')
				coin_tracker[coins[i]] = 'G';
		}

		for (int i=coins_per_side+1; i<=2*coins_per_side; i++) {
			if (coin_tracker[coins[i]]=='G')
				coin_tracker[coins[i]] = 'S';
			else if (coin_tracker[coins[i]]=='P')
				coin_tracker[coins[i]] = 'S';
		}
	} else {
		for (int i=coins_per_side+1; i<=2*coins_per_side; i++) {
			if (coin_tracker[coins[i]]=='S')
				coin_tracker[coins[i]] = 'R';
			else if (coin_tracker[coins[i]]=='P')
				coin_tracker[coins[i]] = 'G';
		}

		for (int i=1; i<=coins_per_side; i++) {
			if (coin_tracker[coins[i]]=='G')
				coin_tracker[coins[i]] = 'S';
			else if (coin_tracker[coins[i]]=='P')
				coin_tracker[coins[i]] = 'S';
		}
	}
}