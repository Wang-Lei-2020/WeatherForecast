#include <stdio.h>    /* For input and output   */
#include <stdlib.h>    /* For rand() and srand() */
#include <time.h>     /* For time() , clock()  and   CLOCKS_PER_SEC*/

int main(){
	int num[20] = {0};
	int prize[19] = {0};
	int x = 0;
	int seed;
    seed = time(NULL);
    srand((unsigned int)seed);     /* Initialize the random sequence */
	x = rand()%19+1;
	num[x] = 1;
	for(int i = 0 ; i < 5;i++){
		seed = time(NULL);
    	srand((unsigned int)seed);     /* Initialize the random sequence */
		x = rand()%19+1;
		if(num[x] == 1 || num[x] == 2 || x == 1 || x == 17){
			i --;
		}
		else{
			num[x] = 2;
		}
	}
	int a = 1;
	int b = 6;
	for(int i = 1;i < 20;i ++){
		if(num[i] == 1){
			prize[0] = i;
		}
		if(num[i] == 2){
			prize[a] = i;
			a ++;
		}
		if(num[i] == 0){
			prize[b] = i;
			b ++;
		}
	}
	printf("Ò»µÈ½±ÐòºÅÎª£º%dºÅ\n",prize[0]);
	printf("¶þµÈ½±ÐòºÅÎª£º%dºÅ %dºÅ %dºÅ %dºÅ %dºÅ\n",prize[1],prize[2],prize[3],prize[4],prize[5]);
	printf("ÈýµÈ½±ÐòºÅÎª£º%dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ %dºÅ",
			prize[6],prize[7],prize[8],prize[9],prize[10],prize[11],prize[12],prize[13],prize[14],prize[15],prize[16],prize[17],prize[18]);
	return 0;
} 
