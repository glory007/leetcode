/*
 * This is asked recently in a google interview.

Given N number of players [for example lets consider N=8], each has a rank from 1 Ð N in a tournament. Where player with rank 1 [R1] implies he is the winner
 of the tournament and he had a match with player with rank 2 [R2] in the final.
So for R1 and R2 to reach final, the semis should have been something like R1 Vs R3 and R2 Vs R4.

So the question is implement a function with the prototype:

printTournamentParanthesis(int numberOfPlayers)
{

}

Where numberOfPlayers [assume this as 8] is the total number of players in the tournament with ranks 1 Ð N [every one has a unique rank], you need print

Output:
(((1,5),(3,7)),((2,6),(4,8)))

Output Explanation:
So usually if there are 8 player in the tournament P1,P2,P3,P4,P5,P6,P7,P8 Ð usually the scheduling will be like P1 plays P5, P2 plays P6, P3 plays P7 etc.
So after the first round you will be left with P1,P2,P3,P4. Now P1 plays P3 and P2 plays P4. => P1 plays P2 in final.
This is mentioned in a parenthesis form.
 */
public class printTournamentParanthesis {
	
	

}
