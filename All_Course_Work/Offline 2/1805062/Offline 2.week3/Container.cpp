# include <iostream>
using namespace std;

# define INTEGER 1
# define INT_ARRAY 2
# define INT_MATRIX 3

// Container class can contain an integer, or an integer array or an integer matrix, but exactly one of them
class Container
{
    // Do not add any additional member variable
    int *value;
    int *valueArray;
    int **valueMatrix;
    int firstDim, secondDim;    // the dimensions of array/matrix, in case of single integer, both should be 0
    int storedType;

    // the following is a private method, not needed from outside
    void reset()
    {
        if (value != NULL)
        {
            delete value;
        }
        if (valueArray != NULL)
        {
            delete []valueArray;
        }
        if (valueMatrix != NULL)
        {
            for(int i=0; i<firstDim; i++)
            {
                delete []valueMatrix[i];
            }
            delete []valueMatrix;
        }
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
    }

public:
    // do not write any additional public method except for those which you are asked to, according to the comments
    Container()
    {
        cout << "Constructing Container with empty parameter" << endl;
        cout << "___________________________________________" << endl;
        value = NULL;
        valueArray = NULL;
        valueMatrix = NULL;
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
    }

    Container (int val)
    {
        cout << "Constructing Container with a single integer parameter" << endl;
        cout << "______________________________________________________" << endl;
        value= new int;
        *value=val;
        valueArray=NULL;
        valueMatrix=NULL;
        firstDim = 0;
        secondDim = 0;
        storedType = INTEGER;
    }

    Container (int *valArr, int len)
    {
        cout << "Constructing Container with integer array parameter" << endl;
        cout << "___________________________________________________" << endl;
        valueArray=new int[len];
        value=NULL;
        valueMatrix=NULL;
        firstDim = len;
        secondDim = 0;
        storedType = INT_ARRAY;
        for(int i=0; i<firstDim; i++)
            valueArray[i]=valArr[i];
    }

    Container (int **valMat, int r, int c)
    {
        cout << "Constructing Container with integer matrix parameter" << endl;
        cout << "____________________________________________________" << endl;
        value=NULL;
        valueArray=NULL;
        valueMatrix=new int*[r];
        for(int i=0; i<r; i++)
            valueMatrix[i]=new int[c];
        firstDim = r;
        secondDim = c;
        storedType = INT_MATRIX;
        for(int i=0; i<firstDim; i++)
        {
            for(int j=0; j<secondDim; j++)
                valueMatrix[i][j]=valMat[i][j];
        }
    }

    // write a copy constructor whose first two lines should be as follows:
    Container(const Container &a)
    {
        cout << "Calling copy constructor of Container" << endl;
        cout << "_____________________________________" << endl;
        if(a.storedType==INTEGER)
        {
            value= new int;
            value=a.value;
            valueArray=NULL;
            valueMatrix=NULL;
            firstDim = a.firstDim;
            secondDim = a.secondDim;
            storedType=a.storedType;
        }
        else if(a.storedType==INT_ARRAY)
        {
            valueArray=new int[a.firstDim];
            value=NULL;
            valueMatrix=NULL;
            firstDim = a.firstDim;
            secondDim = a.secondDim;
            storedType=a.storedType;
            for(int i=0; i<firstDim; i++)
                valueArray[i]=a.valueArray[i];
        }
        else if(a.storedType==INT_MATRIX)
        {
            value=NULL;
            valueArray=NULL;
            valueMatrix=new int*[a.firstDim];
            for(int i=0; i<a.firstDim; i++)
                valueMatrix[i]=new int[a.secondDim];
            firstDim = a.firstDim;
            secondDim = a.secondDim;
            storedType=a.storedType;
            for(int i=0; i<a.firstDim; i++)
            {
                for(int j=0; j<a.secondDim; j++)
                    valueMatrix[i][j]=a.valueMatrix[i][j];
            }
        }
        else if(a.storedType==-1)
        {
            firstDim = 0;
            secondDim = 0;
            storedType=a.storedType;
            value=NULL;
            valueArray=NULL;
            valueMatrix=NULL;
        }
    }

    void setItem (int val)
    {
        reset();
        valueArray=NULL;
        valueMatrix=NULL;
        firstDim = 0;
        secondDim = 0;
        storedType = INTEGER;
        value=new int (val);
    }

    void setItem (int *valArr, int len )
    {
        reset();
        valueArray=new int[len];
        value=NULL;
        valueMatrix=NULL;
        firstDim = len;
        secondDim = 0;
        storedType = INT_ARRAY;
        for(int i=0; i<firstDim; i++)
        {
            valueArray[i]=valArr[i];
        }
    }

    void setItem (int **valMat, int r, int c)
    {
        reset();
        value=NULL;
        valueArray=NULL;
        valueMatrix=new int*[r];
        for(int i=0; i<r; i++)
            valueMatrix[i]=new int[c];
        firstDim = r;
        secondDim = c;
        storedType = INT_MATRIX;
        for(int i=0; i<firstDim; i++)
        {
            for(int j=0; j<secondDim; j++)
            {
                valueMatrix[i][j]=valMat[i][j];
            }
        }
    }

    void * getItem()
    {
        if (value != NULL) return value;
        if (valueArray != NULL) return valueArray;
        if (valueMatrix != NULL) return valueMatrix;
        return NULL;
    }

    int getFirstDim()
    {
        return firstDim;
    }

    int getSecondDim()
    {
        return secondDim;
    }

    int getStoredType()
    {
        return storedType;
    }

    void print()
    {
        if (value != NULL)
        {
            cout << "There is only an integer value in the container object" << endl;
            cout << "The value is: " << *value << endl;
        }
        else if (valueArray != NULL)
        {
            cout << "There is an integer array in the container object" << endl;
            cout << "The values stored in the array are:" << endl;
            for (int i=0; i<firstDim; i++)
            {
                cout << valueArray[i] << " ";
            }
            cout << endl;
        }
        else if (valueMatrix != NULL)
        {
            cout << "There is an integer matrix in the container object" << endl;
            cout << "The values stored in the matrix are:" << endl;
            for (int i=0; i<firstDim; i++)
            {
                for (int j=0; j<secondDim; j++)
                {
                    cout << valueMatrix[i][j] << " ";
                }
                cout << endl;
            }
        }
        else
        {
            cout << "The object has no elements" << endl;
        }
    }

    ~Container()
    {
        if (value != NULL)
        {
            cout << "Freeing allocated memory for a single integer" << endl;
            delete value;
        }
        if (valueArray != NULL)
        {
            cout << "Freeing allocated memory for integer array" << endl;
            delete []valueArray;
        }
        if (valueMatrix != NULL)
        {
            cout << "Freeing allocated memory for integer matrix" << endl;
            for(int i=0; i<firstDim; i++)
            {
                delete [] valueMatrix[i];
            }
            delete [] valueMatrix;
        }
        firstDim = 0;
        secondDim = 0;
        storedType = -1;
        cout << "_____________________" << endl;
        cout << "Destructing Container" << endl;
    }
};
