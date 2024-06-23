#include <iostream>
#include <cstdlib>
using namespace std;


class Stack
{
    Array s;
    int size;
    int top;
public:
    Stack()
    {
        top=0;
        s.setLength(0) ;
    }
    Stack(int x)
    {
        s.setLength(x);
        top=0;
        size=x;
    }
    int isFull()
    {
        if(top==size)
            return 1;
        else return 0;
    }
    int isEmpty()
    {
        if(top==0)
            return 1;
        else return 0;
    }
    void push(int x)
    {
        if(isFull())
        {
            cout << "Stack is full" << endl;
            exit(0);
        }
        s.setElementAt(top,x);
        top++;
        // your code
    }
    int pop()
    {
        if(isEmpty())
        {
            cout << "Stack is empty" << endl;
            exit(0);
        }
        top--;
        return s.getElementAt(top);
    }
    clone(Stack x)
    {
       size=x.size;
       top=x.top;
       s.setLength(size);
        for(int i=top-1,j=0; i>=0; i--,j++)
            s.setElementAt(j,x.s.getElementAt(i));

    }
};
