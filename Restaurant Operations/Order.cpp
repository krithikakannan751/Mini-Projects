/*
    Krithika Kannan
    KXK180046
    10.12 Restaurant Operations
    Order.cpp 
    5/6/2020
*/

//header files
#include "Order.h" //order header

//constructor
Order::Order(string order, Menu *menu)
{
    nItems = 0;
    addItem(order, menu);
}

//methods
int Order::addItem(string order, Menu *menu)
{
    int added = 0;
    string tmp;
    istringstream ord(order.c_str());
    while(ord>>tmp)
    {
        MenuItem* tItem = menu->findItem(tmp);
        if(tItem != NULL)
        {
            orders[nItems] = tItem;
            nItems++;
            added++;
            continue;
        }
        else
        {
            cout<<"No item with code "<< tmp << endl;
        }
    }
    return added;
}

MenuItem* Order::getItem(const int index)
{
    return orders[index];
}

int Order::getNItems()
{
    return nItems;
}

void Order::printO()
{
    double tot = 0.0;
    for(int i=0; i<nItems ;i++)
    {
        cout << orders[i]->getItemCode() << " "
             << orders[i]->getName() << " "
             << orders[i]->getPrice() << endl;
        tot += orders[i]->getPrice();
    }
    cout << "Total " << tot << endl;
    cout << endl;
}

//destructor
Order::~Order()
{
    //dtor
}