#include<bits/stdc++.h>
using namespace std;

class StringMath
{

    char *x;

public:
    int get_length()
    {
        return strlen(x);
    }
    StringMath()
    {
        x=new char[2];
        *x='0';

    }
    StringMath(char *s)
    {
        int length=strlen(s);
        x=new char[length+1];
        for(int i=0; i<length+1; i++)
            x[i]=s[i];
    }
    ~StringMath()
    {
        delete[]x;
    }

   StringMath& operator=(const StringMath &a)
    {
        delete []x;
        x=new char[strlen(a.x)+1];
        strcpy(x,a.x);
        return *this;
    }
    StringMath operator +( StringMath&a)
    {


        int temp=atoi(a.x)+atoi(this->x);
        char s[sizeof(int)*8+1];
        StringMath sum(itoa(temp,s,10));

        return sum;
    }

    void printContent(){
    cout<<x<<endl;}


    StringMath operator +(int a)
    {


        int temp=a+atoi(this->x);
        char s[sizeof(int)*8+1];
        StringMath sum(itoa(temp,s,10));
        return sum;


    }

    bool operator >(int n)
    {
        return atoi(x)>n;
    }

    bool operator>(StringMath &b)
    {
        int a=atoi(this->x);
        int c=atoi(b.x);
        if(a>c)
        return true;
        else
            return false;
    }



    friend StringMath operator +(int a, StringMath &b);
    StringMath operator++(int unused)
 {
        int x=atoi(this->x);
        ++x;
        char s[sizeof(int)*8+1];
        itoa(x,s,10);
        strcpy(this->x,s);
        return *this;
    }
};

StringMath operator +(int a, StringMath &b)
{
        int temp=a+atoi(b.x);
        char s[sizeof(int)*8+1];
        StringMath sum(itoa(temp,s,10));

        return sum;

}




int main()
{

    StringMath a;
    StringMath b("123");

    StringMath c("757");
    StringMath d("220");

    StringMath e;
    a=d;
    a.printContent();
    d.printContent();
    cout<<endl;

    a=b+c+d;
    a.printContent();
    b.printContent();
    c.printContent();
    d.printContent();

    cout<<endl;
    e=d=c;
    e.printContent();
    d.printContent();
    c.printContent();
    cout<<endl;
    int n=345;
    cout<<endl;
    if(c>n)
    {

        e=c+n;
        cout<<endl;
    }
    e.printContent();

    e=n+b;
    e.printContent();
    cout<<endl;
    if(e>b)
    {e++;}
    e.printContent();

}
