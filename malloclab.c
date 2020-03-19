// V. Oliver Walsh and Ryan McGinness

#include <stdio.h>

double* multiplyByTwo (double* input) {
  // double twice = input * 2.0;
  double* twice = malloc(sizeof(double));
  twice[0] = *input * 2.0;
  return twice;
}

int main (int argc, char *argv[])
{
    int* age = malloc(sizeof(int));
    age[0] = 30;
    double salary[0] = 12345.67;
    double* myList = malloc(sizeof(double));;
    myList[0] = 1.2;
    myList[1] = 2.3;
    myList[2] = 3.4;

    double* double_salary = multiplyByTwo(salary);

    printf("double your salary is %.3f\n", double_salary);
    free(double_salary);

  return 0;
}