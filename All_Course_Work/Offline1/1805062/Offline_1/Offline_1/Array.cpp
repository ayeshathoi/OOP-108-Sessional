#include <iostream>
#include <cstdlib>
using namespace std;
#define SIZE 100
#define EMPTY -99

class Array
{
    int a[SIZE];
    int length;
    // you are not allowed to add any field; you can only add methods
public:
    // your code
    Array()
    {
        length = 0;
    }
    Array(int size)
    {
        length = size;
        for (int i = 0; i < size; i++)
        {
            a[i] = EMPTY;
        }
    }
    Array(int i,int e)
    {
        length=i;
        for(i; i>=0; i--)
            a[i]=e;
    }
    Array(int i,int x[])
    {
        length=i;
        int n;
        for(n=0; n<i; n++)
        {
            a[n]=x[n];
        }
    }
    clone(Array x)
    {
        length=x.length;
        for(int i=0; i<length; i++)
            a[i]=x.a[i];

    }

    void setLength(int size)
    {
        length = size;
    }
    int getLength()
    {
        return length;
    }
    void setElementAt(int i, int e)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        a[i]=e;
    }
    int getElementAt(int i)
    {
        if(i >= length)
        {
            cout << "Invalid Index" << endl;
            exit(0);
        }
        return a[i];
    }
    void print()
    {
        for(int i =0; i < length; i++)
        {
            cout << a[i] << " ";
        }
        cout << endl;
    }
    // your code
};
