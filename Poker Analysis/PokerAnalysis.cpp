/*
	Krithika Kannan
	KXK180046
	CS 1336.002
	Final Project
	30 November 2019
*/

//header files
#include<iostream> //for cin/cout
#include<cstdlib> //for rand()/srand()
#include<iomanip> //for setw, setprecision, fixed, left/right
#include<ctime> //for time()

using namespace std;

//constant variables
const int NUMBER_OF_CARDS = 52; //total number of cards in a deck
const int NUMBER_OF_SWAPS = 10000; //number of times the deck is swapped
const int HAND_SIZE = 5; //the number of cards in a hand
const int TOTAL_RANKINGS = 9; //the total number of ranking categories in poker

//Prototypes
void createArr(int cards[], int numCards); //creates an array of sequential integers from 0 to 51
void shuffle(int cards[], int swaps, int numCards); //shuffles array values randomly 
void seperate(int cards[], int hands[], int size); //puts the first 5 elements of the cards array into the hands array
void sort(int cards[], int size); //sorts an integer array in an ascending order 
int select(int hands[], int ranking[], int size); //analyzes which type of hand the array's contents are
int straightFlush(int hands[], int size); //checks to see if the hand array is a rank 1 hand
int fourOfAKind(int hands[], int size); //checks to see if the hand array is a rank 2 hand
int fullHouse(int hands[]); //checks to see if the hand array is a rank 3 hand
int flush(int hands[], int size); //checks to see if the hand array is a rank 4 hand
int straight(int hands[], int size); //checks to see if the hand array is a rank 5 hand
int threeOfAKind(int hands[]); //checks to see if the hand array is a rank 6 hand
int onePair(int hands[]); //checks to see if the hand array is a rank 7 hand
int twoPair(int hands[]); //checks to see if the hand array is a rank 8 hand
int highCard(); //checks to see if the hand array is a rank 9 hand
void calculate(int ranking[], int numHands, int ranks); //calculates the total number and percent of hands in each ranking
void converter(int hands[], int size); //converts cards array number into card value
void key(); //prints out the rank number key

/*
	This program analyzes a hand of 5 cards in poker and displays which rank the hand falls under
*/
int main()
{ 
	//Variables - arrays
	int cards[NUMBER_OF_CARDS]; //stores an array of 52 cards represented as integers from 0 to 51
	int hands[HAND_SIZE]; //stores a hand of 5 cards, which is randomy selected from the 0 to 51 card array
	int ranking[TOTAL_RANKINGS] = {0}; //an array of 5 elements. Each array position represents a specifc card rank 

	//Stores the cards array with integers from 0 to 51
	createArr(cards, NUMBER_OF_CARDS); //calls the create array method

	//Variables - integers to keep track of number of hands and their rank
	int handRank = 0; //staores the integer rank category of a hand
	int numHands = 0; //stroes the total number of hands that the user enters

	//Asks the user the number of hands they want to generate
	cout << "How many hands should be generated" << endl; //promts the user to enter a number of hands
	cin >> numHands; //stores the entered value in the numHands variable
	cout << endl; //goes to the next line(was used for formatting purposes)

	//Used for the shuffle function called by main()
	srand(time(NULL)); //Sets the seed value to time(0)

	//Loop foes through each element of the hands array
	for (int i = 0; i < numHands; i++) //goes through each element
	{
		//Call to functions
		shuffle(cards, NUMBER_OF_SWAPS, NUMBER_OF_CARDS); //shuffles the cards array
		seperate(cards, hands, HAND_SIZE); //puts the first 5 elements of the cards array into the hands array 
		sort(hands, HAND_SIZE); //sorts the hands array integers in ascending order

		//Prints out the hand number for all the hands
		cout << "Hand " << i + 1 << ": " << endl; //i + 1 is the hand number
		cout << setw(5); //shifts the elements of the hands array to the right (used for formatting)

		//Prints out the elements of hands array
		for (int i = 0; i < HAND_SIZE; i++)
		{
			//Formats the output
			cout << hands[i] << setw(3); //prints out the position value and 3 spaces
			if (i != 4) //after each element a comma followed by a space is printed
			{
				cout << ", "; //comma and space printed
			}
		}

		//Prints out the card equivalent of the integer value of the array
		cout << endl; //Used to go to the next line
		converter(hands, HAND_SIZE); //calls the converter function

		//Calculates hand rank
		cout << endl; //Used to go to the next line
		handRank = select(hands, ranking, HAND_SIZE); //calls the selct method and stores ranking value in handRank

		//Prints out hand rank type
		switch (handRank) //uses a switch statement besed on hand rank value
		{
			//if handRank equals 1
			case 1: cout << "Hand " << i + 1 << " is a straight flush." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 2
			case 2: cout << "Hand " << i + 1 << " is a four of a kind." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 3
			case 3: cout << "Hand " << i + 1 << " is a full house." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 4
			case 4: cout << "Hand " << i + 1 << " is a flush." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 5
			case 5: cout << "Hand " << i + 1 << " is a straight." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 6
			case 6: cout << "Hand " << i + 1 << " is a three of a kind." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 7
			case 7: cout << "Hand " << i + 1 << " is a two pair." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 8
			case 8: cout << "Hand " << i + 1 << " is a one pair." << endl; //i + 1 is the hand number
				break;
			//if handRank equals 9
			case 9: cout << "Hand " << i + 1 << " is a high card." << endl; //i + 1 is the hand number
				break;
			//if handRank does not equal 1-9 
			default: cout << "There was an error processing hand " << i + 1 << endl; //i + 1 is the hand number
				break;
		}

		//Sorts cards array back into order from 0 to 51
		cout << endl; //used to go to the next line (for formatting)
		sort(cards, NUMBER_OF_CARDS); //calls the sort function
	}

	//Prints out the rank key
	key(); //calls the key function

	//calculates the number and percentages of ranks
	cout << endl; //used to go to the next line (for formatting)
	calculate(ranking, numHands, TOTAL_RANKINGS); //calls the calculate method

	//program returns 0 if working
	return 0;
}

/*
	This function stores integers 0 to 51 into an array
*/
void createArr(int cards[], int numCards) //parameter is an integer array and number of cards
{
	//for loop goes through all elements of the cards array
	for (int i = 0; i < numCards; i++) //numCards is equal to 52
	{
		//sets card position at i to i
		cards[i] = i;
	}
}

/*
	This function swaps two random positions of an array a set number of times
*/
void shuffle(int cards[], int swaps, int numCards) //parameters are an int array and the number of swaps
{
	//variables
	int randNumb[NUMBER_OF_SWAPS]; //creates an array with the size of NUMBER_OF_SWAPS(10,000)
	int temp; //vaiable stores temporary array value

	//goes through randNumb array and fills each position with a random number from 0 to 51
	for (int i = 0; i < swaps; i++)
	{
		randNumb[i] = rand() % numCards; //stores random numbers from 0 to 51 into randNumb
	}

	//swaps each position of the cards array with random numbers from the randNumb array
	for (int i = 0; i < swaps - 1; i++) //swaps - 1 is used because i + 1 has to be in range
	{
		//swap
		temp = cards[randNumb[i]]; //temporary variable stores cards array value
		cards[randNumb[i]] = cards[randNumb[i+1]]; //random cards array position stores a second random cards array position
		cards[randNumb[i+1]] = temp; //the second random cards array position stores the temp value
	}
}

/*
	This function copies the first 5 elements of one array into another array
*/
void seperate(int cards[], int hands[], int size) //the parameters are two int arrays and the size of the secind array
{
	//the for loop goes through all the elemnts of an array
	for (int i = 0; i < size; i++) //size is equal to 5
	{
		//the hands array gets filled with cards array values
		hands[i] = cards[i];
	}
}

/*
	This function uses a bubble sort to sort the elements of an array in ascending order
*/
void sort(int cards[], int size) //the parameters are an integer array and its size
{
	//variables
	int temp; //stores a temporary int value during swaps

	//bubble sort
	for (int i = 0; i < size; i++) //controls the number of passes
	{
		for (int j = 0; j < size - i - 1; j++) //one pass through the array
		{
			if (cards[j] > cards[j + 1]) //checks to see if the first element is greater or less than the second element
			{
				temp = cards[j]; //temp stores the cards array value at j
				cards[j] = cards[j + 1]; //cards array at j stores cards array value at j + 1
				cards[j + 1] = temp; //cards array at j + 1 stores temp value
			}
		}
	}
}

/*
	This function returns the type of rank a hand has
*/
int select(int hands[], int ranking[], int size) //parameters are the hands array, ranking array, and size of the hands array
{
	//uses if, else if, and else conditionals
	if (straightFlush(hands, size) == 1) //for rank 1
	{
		ranking[0] += 1; //increases ranking array position at 0 by 1
		return 1; //returns rank number
	}
	else if (fourOfAKind(hands, size) == 2) //for rank 2
	{
		ranking[1] += 1; //increases ranking array position at 1 by 1
		return 2; //returns rank number
	}
	else if (fullHouse(hands) == 3) //for rank 3
	{
		ranking[2] += 1; //increases ranking array position at 2 by 1
		return 3; //returns rank number
	}
	else if (flush(hands, size) == 4) //for rank 4
	{
		ranking[3] += 1; //increases ranking array position at 3 by 1
		return 4; //returns rank number
	}
	else if (straight(hands, size) == 5) //for rank 5
	{
		ranking[4] += 1; //increases ranking array position at 4 by 1
		return 5; //returns rank number
	}
	else if (threeOfAKind(hands) == 6) //for rank 6
	{
		ranking[5] += 1; //increases ranking array position at 5 by 1
		return 6; //returns rank number
	}
	else if (twoPair(hands) == 7) //for rank 7
	{
		ranking[6] += 1; //increases ranking array position at 6 by 1
		return 7; //returns rank number
	}
	else if (onePair(hands) == 8) //for rank 8
	{
		ranking[7] += 1; //increases ranking array position at 7 by 1
		return 8; //returns rank number
	}
	else if (highCard() == 9) //for rank 9
	{
		ranking[8] += 1; //increases ranking array position at 0 by 1
		return 9; //returns rank number
	}
	else //if there was an error
	{
		return -1; //returns -1
	}
}

/*
	A straight flush has a hand of cards all in sequential rank in the same suit
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Straight_flush
*/
int straightFlush(int hands[], int size) //parameters are int array and its size
{
	//variables
	int count = 0; //keeps track of number of pairs
	int count2 = 0; //keeps track of the total elements added together

	//goes through each element of the array
	for (int i = 0; i < size - 1; i++) //size - 1 meands the loop stops before the last element
	{
		if ((hands[i + 1] - hands[i]) == 4) //checks to see if the difference between the elements is equal to 4
		{
			count++; //increases count by 1
		}

		count2 += hands[i]; //adds each element of the array to count2
	}

	//adds the last element of the array to count2
	count2 += hands[size - 1]; 
	
	//checks to see if all the cards are similar
	if (count == 4) //count has to equal 4
	{
		return 1; //returns rank number
	}
	/*
		Takes into account of royal straight flush or ace-high straight flush
		
		Cards                                              = Value in array    = total added together
		Aspades Kspades Qspades Jspades 10spades           = 0, 48, 44, 40, 36 = 168
		Ahearts Khearts Qhearts Jhearts 10hearts           = 1, 49, 45, 41, 37 = 173
		Adiamonds Kdiamonds Qdiamonds Jdiamonds 10diamonds = 2, 50, 46, 42, 38 = 178
		Aclubs Kclubs Qclubs Jclubs 10clubs                = 3, 51, 47, 43, 39 = 183
	*/
	else if (count2 == 168 || count2 == 173 || count2 == 178 || count2 == 183) //values are explained above
	{
		return 1; //returns rank number
	}
	else //if there was an error
	{
		return -1; //returns -1
	}
}

/*
	A four of a kind is a hand that has 4 cards of the same rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Four_of_a_kind
*/
int fourOfAKind(int hands[], int size) //parameter is int hands array and size of the array
{
	//variables
	int count = 0; //keps track of pairs

	//goes through each element of the array
	for (int i = 0; i < size - 1; i++) //size - 1 means the loops stops before the last value
	{
		//equation used to find rank: x/4 + 1
		if ((hands[i+1]/4 + 1)  == (hands[i]/4 + 1)) //checks to see of the hands array values are similar
		{
			count++; //increases count by 1
		}
	}

	//checks for pairs
	if (count == 3) //count needs to be equal to 3
	{
		return 2; //returns the rank number
	}
	else //if there was an error
	{
		return -1; //return -1
	}
}

/*
	A full house is a deck with 3 cards in one rank and 2 cards in another rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house
*/
int fullHouse(int hands[]) //parameter is an int array
{
	//uses the equation x/4 + 1 to find rank

	//checks the first three elements for a pair of three
	if ((hands[0] / 4 + 1) == (hands[1] / 4 + 1) == (hands[2] / 4 + 1))
	{
		//checks the last two elements for a pair
		if ((hands[3] / 4 + 1) == (hands[4] / 4 + 1))
		{
			return 3; //return the rank number
		}
		else //an error occured
		{
			return -1; //returns -1
		}
	}
	//checks the last three elements for a pair of three
	else if ((hands[2] / 4 + 1) == (hands[3] / 4 + 1) == (hands[4] / 4 + 1))
	{
		//checks the first two elements for a pair
		if ((hands[0] / 4 + 1) == (hands[1] / 4 + 1))
		{
			return 3; //returns the rank number
		}
		else //an error occured
		{
			return -1; //returns -1
		}
	}
	else //an error occured
	{
		return -1; //returns -1
	} 
}

/*
	A flush is a hand that has all the cards in the same suit but not in sequential rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Flush
*/
int flush(int hands[], int size) //parameter int array and size of the array
{
	//variables
	int count = 0; // keeps track of pairs

	//for loop goes through array
	for (int i = 0; i < size - 1; i++) //size-1 means the loop stops befor the last element
	{
		//uses the equation x % 4 to find suit
		if ((hands[i + 1] % 4) == (hands[i] % 4)) //checks to see if the pair is in the same suit
		{
			count++; //increases count by 1
		}
	}

	//if the number of count is equal to 4
	if (count == 4)
	{
		return 4; //returns rank number
	}
	else //an error occured
	{
		return -1; //return -1
	}
}

/*
	A straight is a hand that contains cards in sequential rank but different suits
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Straight
*/
int straight(int hands[], int size) //parameters are an int array and its size
{
	//variables
	int count = 0; //keeps track fo the pairs

	//for loop goes through array
	for (int i = 0; i < size - 1; i++) //size-1 means the loop stops befor the last element
	{
		//uses the equation x/4 + 1 to find rank
		if (((hands[i + 1] / 4 + 1) - (hands[i] / 4 + 1)) == 1) //checks to see sequential rank
		{
			count++; //increases count by 1
		}
	}

	//if the number of count is equal to 4
	if (count == 4)
	{
		return 5; //return rank number;
	}
	else //if an error occured
	{
		return -1; //return -1
	}
}

/*
	A three of a kind is hand with three cards in one rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Three_of_a_kind
*/
int threeOfAKind(int hands[]) //parameter is an int array
{
	//uses the equation x/4 + 1 to find rank
	if ((hands[0] / 4 + 1) == (hands[1] / 4 + 1) == (hands[2] / 4 + 1)) //checks first 3 positions
	{
		return 6; //returns rank number
	}
	else if ((hands[2] / 4 + 1) == (hands[3] / 4 + 1) == (hands[4] / 4 + 1)) //checks last three positions
	{
		return 6; //returns rank number
	}
	else if((hands[1] / 4 + 1) == (hands[2] / 4 + 1) == (hands[3] / 4 + 1)) //checks middle positions
	{
		return 6; //returns rank number
	}
	else //if an error occured
	{
		return -1; //return -1
	}
}

/*
	A two pair is a hand with two pairs of cards with the same rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair
*/
int twoPair(int hands[]) //parameters is an int array
{
	if(((hands[0]/4 + 1) == (hands[1]/4 + 1)) && ((hands[2] / 4 + 1) == (hands[3] / 4 + 1))) //checks first two and next two positions
	{
		return 7; //returns rank number
	}
	else if(((hands[0] / 4 + 1) == (hands[1] / 4 + 1)) && ((hands[3] / 4 + 1) == (hands[4] / 4 + 1))) //checks first two and last two positions
	{
		return 7; //returns rank number
	}
	else if(((hands[1] / 4 + 1) == (hands[2] / 4 + 1)) && ((hands[3] / 4 + 1) == (hands[4] / 4 + 1))) //checks last two positions and two before that
	{
		return 7; //returns rank number
	}
	else //if an error occured
	{
		return -1; //return -1
	}
}

/*
	A one pair is a hand with two cards of the same rank
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#One_pair
*/
int onePair(int hands[]) //parameter is an int array
{
	//uses the equation x/4 + 1 to find rank
	if ((hands[0] / 4 + 1) == (hands[1] / 4 + 1)) //checks first two positions
	{
		return 8; //returns rank number
	}
	else if ((hands[1] / 4 + 1) == (hands[2] / 4 + 1)) //checks next two positions
	{
		return 8; //returns rank number
	}
	else if ((hands[2] / 4 + 1) == (hands[3] / 4 + 1)) //checks next two positions
	{
		return 8; //returns rank number
	}
	else if ((hands[3] / 4 + 1) == (hands[4] / 4 + 1)) //checks last two positions
	{
		return 8; //returns rank number
	}
	else //if an error occured
	{
		return -1; //returns -1
	}
}

/*
	A high card is a hand with no pairs
	Information about the rank was taken from https://en.wikipedia.org/wiki/List_of_poker_hands#High_card
*/
int highCard() //no parameters
{
	return 9; //returns rank value
}

/*
	This function displays the table of rank number, number of hands in each rank, and percent of total hands in each rank
*/
void calculate(int ranking[], int numHands, int ranks) //parameters are an int array and its size and the number of ranks
{
	//variables
	double percent = 0.0; //used to store the calculated percent value

	//formats the table header
	cout << setw(12) << left << "Rank#: " << setw(23) << left << "|  Number of Hands: " << setw(30)
		<< left << "|  Percent of total hands: " << endl;

	//creates a dash between the table header and values
	for (int i = 0; i < 62; i++)
	{
		cout << "-";
	}

	//goes to the next line(used for formatting table)
	cout << endl;

	//calculates and displays the ranks
	for (int i = 0; i < ranks; i++)
	{
		//calculation to find percentage
		percent = static_cast<double>(ranking[i]) / numHands * 100;

		//display
		cout << setw(11) << right << i + 1 << " |" << setw(21) << right << ranking[i] << " |" << setw(22)
			<< right << fixed << setprecision(2) << percent << " %" << endl;
	}
}

/*
	This function converts a numerical value from 0 to 51 into the card type
*/
void converter(int hands[], int size) //parameters are an arry of int with its size
{
	//variables
	int rank = 0; //keeps track of rank number
	int suit = 0; //keeps track of suit type

	//used for formatting
	cout << setw(5);

	//display
	for (int i = 0; i < size; i++) //goes through the array 
	{
		rank = hands[i] / 4 + 1; //calculates rank number
		suit = hands[i] % 4; //calculates suit type

		//displays rank 
		switch (rank)
		{
			case 1:
				cout << "A";
				break;
			case 2:
				cout << "2";
				break;
			case 3:
				cout << "3";
				break;
			case 4:
				cout << "4";
				break;
			case 5:
				cout << "5";
				break;
			case 6:
				cout << "6";
				break;
			case 7:
				cout << "7";
				break;
			case 8:
				cout << "8";
				break;
			case 9:
				cout << "9";
				break;
			case 10:
				cout << "10";
				break;
			case 11:
				cout << "J";
				break;
			case 12:
				cout << "Q";
				break;
			case 13:
				cout << "K";
				break;
			default:
				cout << "ERROR";
				break;
		}

		//displays suit
		switch (suit)
		{
			case 0:
				cout << "spades";
				break;
			case 1:
				cout << "hearts";
				break;
			case 2:
				cout << "diamonds";
				break;
			case 3:
				cout << "clubs";
				break;
			default:
				cout << "ERROR";
				break;
		}

		//adds commas between each element
		if (i != 4)
		{
			cout << ", ";
		}
	}
}

/*
	This function prints out a key of ranks
*/
void key() //has no parameters
{
	//heading
	cout << "Rank Key: " << endl;

	//ranks
	cout << "Rank 1 is a straight flush" << endl;
	cout << "Rank 2 is a four of a kind" << endl;
	cout << "Rank 3 is a full house" << endl;
	cout << "Rank 4 is a flush" << endl;
	cout << "Rank 5 is a straight" << endl;
	cout << "Rank 6 is a three of a kind" << endl;
	cout << "Rank 7 is a two pair" << endl;
	cout << "Rank 8 is a one pair" << endl;
	cout << "Rank 9 is a high card" << endl;
}