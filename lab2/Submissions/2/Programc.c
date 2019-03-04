#include<stdio.h>

int main(int argc, char **argv){
    
    int x = 5, y = 6, a, b;
    float p = 0.5, q = 1.2;
    char r = 'x', s = 'y';
    
    a = x + y;
    b = x * q;
    a = a - b % y;

    if (a > b) {
        printf("This doesn't make any sense");
    } else {
        printf("Still None Sense");
    }
}