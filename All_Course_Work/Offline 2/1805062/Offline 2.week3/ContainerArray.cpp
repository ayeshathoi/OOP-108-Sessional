# include <cstdlib>
# include "Container.cpp"

class ContainerArray{
    Container *arrayOfContainers;
    int allocatedSize;
public:
    ContainerArray(){
        allocatedSize = 0;
        arrayOfContainers = NULL;
    }

    ContainerArray(int len){
        allocatedSize = len;
        arrayOfContainers = new Container[allocatedSize];
    }

    void setAllocatedSize(int sz){
        if(arrayOfContainers!=NULL)
            delete []arrayOfContainers;
        allocatedSize=sz;
        arrayOfContainers=new Container[allocatedSize];
    }

    int getAllocatedSize(){
        return allocatedSize;
    }

    Container getItemAt(int index){
        if (index >= allocatedSize){
            cout << "Cannot get item, Exception: Container Array index out of bound";
            exit(0);
        }
        return arrayOfContainers[index];
    }

     void setItemAt(Container a,int index)
     {
        if(index>=allocatedSize)
            cout << "Exception: Container Array index out of bound";
        if(a.getStoredType()==INTEGER)
            arrayOfContainers[index].setItem(((int)a.getItem()));
        else if(a.getStoredType()==INT_ARRAY)
            arrayOfContainers[index].setItem((int*)a.getItem(),a.getFirstDim());
        else if(a.getStoredType()==INT_MATRIX)
            arrayOfContainers[index].setItem((int**)a.getItem(),a.getFirstDim(),a.getSecondDim());
    }

    ~ContainerArray(){
        delete []arrayOfContainers;
        allocatedSize=0;
        arrayOfContainers=NULL;
    }
};

int main(){
    // the following braces indicate scope of variables declared in them
    // at the end of a brace enclosed block, object destructors will be called
    {
        Container a;
        a.print();
        if (a.getItem() == NULL){
            cout << "No value is stored in the container" << endl;
        }
        else{
            cout << "Some value is stored in the container" << endl;
        }
    }

    {
        Container a(100);
        a.print();
        if (a.getItem() == NULL){
            cout << "No value is stored in the container" << endl;
        }
        else if (a.getStoredType() == INTEGER){
            int *val = (int *) a.getItem();
            cout << "The integer value retrieved from container object is: " << *val << endl;
        }
        else{
            cout << "Some value is stored in the container" << endl;
        }
    }

    {
        int *arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        Container a(arr, 3);
        a.print();
        if (a.getItem() == NULL){
            cout << "No value is stored in the container" << endl;
        }
        else if (a.getStoredType() == INT_ARRAY){
            arr = (int *)a.getItem();
            cout << "The integer array retrieved from container object is: " << endl;
            for (int i=0; i<3; i++){
                cout << arr[i] << " ";
            }
            cout << endl;
        }
        else{
            cout << "Some value is stored in the container" << endl;
        }
    }

    {
        int **mat = new int*[2];
        mat[0] = new int[3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;
        mat[1] = new int[3];
        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;
        Container a(mat, 2, 3);
        a.print();
        if (a.getItem() == NULL){
            cout << "No value is stored in the container" << endl;
        }
        else if (a.getStoredType() == INT_MATRIX){
            mat = (int **)a.getItem();
            cout << "The integer matrix retrieved from container object is: " << endl;
            for (int i=0; i<2; i++){
                for (int j=0; j<3; j++){
                    cout << mat[i][j] << " ";
                }
                cout << endl;
            }
        }
        else{
            cout << "Some value is stored in the container" << endl;
        }
    }

    Container a;
    Container b(100);

    int *arr = new int[3];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;

    Container c(arr, 3);

    int **mat = new int*[2];
    mat[0] = new int[3];
    mat[0][0] = 1;
    mat[0][1] = 2;
    mat[0][2] = 3;
    mat[1] = new int[3];
    mat[1][0] = 4;
    mat[1][1] = 5;
    mat[1][2] = 6;

    Container d(mat, 2, 3);

    cout << endl;
    cout << "Demonstrating objects of ContainerArray class..." << endl;
    cout << endl;

    int firstObjArraySize = 3, secondObjArraySize = 4;
    ContainerArray containerArray1;
    ContainerArray containerArray2(secondObjArraySize);
    cout << secondObjArraySize << " constructors with empty parameters are called" << endl;

    containerArray1.setAllocatedSize(firstObjArraySize);
    cout << firstObjArraySize << " constructors with empty parameters are called" << endl;

    containerArray1.setItemAt(a, 0);
    containerArray1.setItemAt(b, 2);
    containerArray1.setItemAt(c, 1);

    containerArray2.setItemAt(c, 0);
    containerArray2.setItemAt(d, 1);

    for (int i=0; i<3; i++){
        cout << i << "-th element of 1st container array:" << endl;
        containerArray1.getItemAt(i).print();
    }

    for (int i=0; i<2; i++){
        cout << i << "-th element of 2nd container array:" << endl;
        containerArray2.getItemAt(i).print();
    }

    return 0;
}
