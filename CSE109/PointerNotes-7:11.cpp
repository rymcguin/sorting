//&- Reference operator
//* - Derefernce operator

//int x = * y;
//"Set x to value to which y points"

//int* z = &x;
//"point z to address of x"
//"z points to address of z"
//"z points to x".....this is what the code reads like.
//pointer --> pointer.... if left is a pointer right has to be a pointer
//value --> value....^^

// All possibilities
    // int x = _ ; - declare value
    // int *x = _ ; - declare pointer
    // _ = *x ; - dereference pointer - maybe pointer, maybe value
    // _ = &x ; - reference value - pointer
    //int **x  = declare 2D