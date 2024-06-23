#include <iostream>
#include <cstdlib>
using namespace std;

class Queue
{
    Array s;
    int size;
    int front;
    int rear;
public:
    Queue()
    {
        front=0;
        size=0;
        rear=0;
        s.setLength(0) ;
    }
    Queue(int x)
    {
        s.setLength(x);
        front=0;
        rear=0;
        size=x;
    }
    int isFull()
    {
        if(rear==size)
            return 1;
        else return 0;
    }

    int isEmpty()
    {
        if(rear==0)
            return 1;
        else return 0;
    }
    void enqueue(int x)
    {
        if(isFull())
        {
            cout << "Queue is full" << endl;
            exit(0);
        }
        s.setElementAt(rear,x);
        rear++;
    }
    int dequeue()
    {
        if(isEmpty())
        {
            cout << "Queue is empty" << endl;
            exit(0);
        }
        rear--;
        return s.getElementAt(front++);// your code
    }
    clone(Queue x)
    {
       size=x.size;
       front=x.front;
       rear=x.rear;
       s=x.s;
    }
    // your code
};
