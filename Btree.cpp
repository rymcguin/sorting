#include <iostream>
#include <conio.h>
using namespace std;
#define MAX 4
#define MIN 2
struct Node {
    int val[MAX + 1], counter;
    Node *linker[MAX + 1];
};
Node *root;
Node * createNode(int val, Node *sub) {
    Node *newNode = new Node;
    newNode->val[1] = val;
    newNode->counter = 1;
    newNode->linker[0] = root;
    newNode->linker[1] = sub;
    return newNode;
}
void addToNode(int val, int index, Node *node, Node *sub) {
    int j = node->counter;
    while (j > index) {
        node->val[j + 1] = node->val[j];
        node->linker[j + 1] = node->linker[j];
        j--;
    }
    node->val[j + 1] = val;
    node->linker[j + 1] = sub;
    node->counter++;
}
//ADD
void insert(int val) {
    int flag, i;
    Node *sub;
 
    flag = setValueInNode(val, &i, root, &sub);
    if (flag){
        root = createNode(i, sub);
	}
}
//SEARCH
void search(int val, int *index,Node *myNode) {
    if (!myNode) {
        return;
    }
 
    if (val < myNode->val[1]) {
        *index = 0;
    }
    else {
        for (*index = myNode->counter;
            (val < myNode->val[*index] && *index > 1); (*index)--);
        if (val == myNode->val[*index]) {
            cout << "Given data is Found\n";
            return;
        }
    }
    search(val, index, myNode->linker[*index]);
    return;
}
//REMOVE
void removeVal(Node *myNode, int index) {
    int i = index + 1;
    while (i <= myNode->counter) {
        myNode->val[i - 1] = myNode->val[i];
        myNode->linker[i - 1] = myNode->linker[i];
        i++;
    }
    myNode->counter--;
}
//TRAVERSAL
void trav(Node *myNode) {
    int i;
    if (myNode) {
        for (i = 0; i < myNode->counter; i++) {
            trav(myNode->linker[i]);
            cout<< myNode->val[i + 1]<<' ';
        }
        trav(myNode->linker[i]);
    }
}

void splitNode(int val, int *ptr, int index, Node *node,Node *sub, Node **newNode) {
    int median, j;
 
    if (index > MIN)
        median = MIN + 1;
    else
        median = MIN;
 
    *newNode = new Node;
    j = median + 1;
    while (j <= MAX) {
        (*newNode)->val[j - median] = node->val[j];
        (*newNode)->linker[j - median] = node->linker[j];
        j++;
    }
    node->counter = median;
    (*newNode)->counter = MAX - median;
 
    if (index <= MIN) {
        addToNode(val, index, node, sub);
    }
    else {
        addToNode(val, index - median, *newNode, sub);
    }
    *ptr = node->val[node->counert];
    (*newNode)->linker[0] = node->linker[node->counter];
    node->counter--;
}
int setValueInNode(int val, int *ptr,Node *node, Node **sub) {
    int index;
    if(!node){
        *ptr = val;
        *sub = NULL;
        return 1;
    }
    if (val < node->val[1]){
        index = 0;
    }else{
        for (index = node->counter; (val < node->val[index] && index > 1); index--);
        if (val == node->val[index]){
            cout<<"Duplicates are not allowed\n";
            return 0;
        }
    }
    if (setValueInNode(val, ptr, node->linker[index], sub)) {
        if (node->counter < MAX) {
            addToNode(*ptr, index, node, *sub);
        }
        else {
            splitNode(*ptr, ptr, index, node, *sub, sub);
            return 1;
        }
    }
    return 0;
}
void copySuccessor(Node *myNode, int index) {
    Node *dummy;
    dummy = myNode->linker[index];
 
    for (; dummy->linker[0] != NULL;)
        dummy = dummy->linker[0];
    myNode->val[index] = dummy->val[1];
 
}
void doRightShift(Node *myNode, int index) {
    Node *x = myNode->linker[index];
    int j = x->counter;
 
    while (j > 0) {
        x->val[j + 1] = x->val[j];
        x->linker[j + 1] = x->linker[j];
    }
    x->val[1] = myNode->val[index];
    x->linker[1] = x->linker[0];
    x->counter++;
 
    x = myNode->linker[index - 1];
    myNode->val[index] = x->val[x->counter];
    myNode->linker[index] = x->linker[x->counter];
    x->counter--;
    return;
}
void doLeftShift(Node *myNode, int index) {
    int j = 1;
    Node *x = myNode->linker[index - 1];
 
    x->counter++;
    x->val[x->counter] = myNode->val[index];
    x->linker[x->counter] = myNode->linker[index]->linker[0];
 
    x = myNode->linker[index];
    myNode->val[index] = x->val[1];
    x->linker[0] = x->linker[1];
    x->counter--;
 
    while (j <= x->counter) {
        x->val[j] = x->val[j + 1];
        x->linker[j] = x->linker[j + 1];
        j++;
    }
    return;
}
void merge(Node *myNode, int index) {
    int j = 1;
    Node *x1 = myNode->linker[index], *x2 = myNode->linker[index - 1];
 
    x2->counter++;
    x2->val[x2->counter] = myNode->val[index];
    x2->linker[x2->counter] = myNode->linker[0];
 
    while (j <= x1->counter) {
        x2->counter++;
        x2->val[x2->counter] = x1->val[j];
        x2->linker[x2->counter] = x1->linker[j];
        j++;
    }
 
    j = index;
    while (j < myNode->counter) {
        myNode->val[j] = myNode->val[j + 1];
        myNode->linker[j] = myNode->linker[j + 1];
        j++;
    }
    myNode->counter--;
    free(x1);
}
void adjust(Node *myNode, int index) {
    if (!index) {
        if (myNode->linker[1]->counter > MIN) {
            doLeftShift(myNode, 1);
        }
        else {
            merge(myNode, 1);
        }
    }
    else {
        if (myNode->counter != index) {
            if (myNode->linker[index - 1]->counter > MIN) {
                doRightShift(myNode, index);
            }
            else {
                if (myNode->linker[index + 1]->counter > MIN) {
                    doLeftShift(myNode, index + 1);
                }
                else {
                    merge(myNode, index);
                }
            }
        }
        else {
            if (myNode->linker[index - 1]->counter > MIN)
                doRightShift(myNode, index);
            else
                merge(myNode, index);
        }
    }
}
int deleteValFromNode(int val,Node *myNode) {
    int index, flag = 0;
    if (myNode) {
        if (val < myNode->val[1]) {
            index = 0;
            flag = 0;
        }
        else {
            for (index = myNode->counter;
                (val < myNode->val[index] && index > 1); index--);
            if (val == myNode->val[index]) {
                flag = 1;
            }
            else {
                flag = 0;
            }
        }
        if (flag) {
            if (myNode->linker[index - 1]) {
                copySuccessor(myNode, index);
                flag = deleteValFromNode(myNode->val[index], myNode->linker[index]);
                if (flag == 0) {
                    cout<<"Given data is not present in B-Tree\n";
                }
            }
            else {
                removeVal(myNode, index);
            }
        }
        else {
            flag = deleteValFromNode(val, myNode->linker[index]);
        }
        if (myNode->linker[index]) {
            if (myNode->linker[index]->counter < MIN)
                adjust(myNode, index);
        }
    }
    return flag;
}
void deleteNode(int val,Node *myNode) {
    Node *temp;
    if (!deleteValFromNode(val, myNode)) {
        cout<<"Given value is not present in B-Tree\n";
        return;
    }
    else {
        if (myNode->counter == 0) {
            temp = myNode;
            myNode = myNode->linker[0];
            free(temp);
        }
    }
    root = myNode;
    return;
}
int main() {
    int val, opt;
    while (true) {
        cout<<"1. Insert\t2. Delete\n";
        cout<<"3. Search\t4. Traversal\n";
        cout<<"5. Exit\nEnter your choice: ";
        cin >> opt;
        cout << endl;
        switch (opt) {
        case 1:
            cout<<"Enter your input:";
            cin >> val;
            insert(val);
            break;
        case 2:
            cout<<"Enter the element to delete:";
            cin >> val;
            deleteNode(val, root);
            break;
        case 3:
            cout<<"Enter the element to search:";
            cin >> val;
            searching(val, &opt, root);
            break;
        case 4:
            trav(root);
            break;
        case 5:
            exit(0);
        }
        cout << endl;
    }
 
    system("pause");
}
}