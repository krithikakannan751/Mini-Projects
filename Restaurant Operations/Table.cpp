/*
    Krithika Kannan
    KXK180046
    10.12 Restaurant Operations
    Table.cpp 
    5/6/2020
*/

//header files
#include "Table.h" //table header

//constructor
Table::Table(int tableid, int maxseats)
{
    tableNum = tableid;
    mSeats = maxseats;
    nPeople = 0;
    status = IDLE;
    order = NULL;
}

//get methods
int Table::getTableId()
{
    return tableNum;
}

int Table::getMaxSeats()
{
    return mSeats;
}

int Table::getNumPeople()
{
    return nPeople;
}

TableStatus Table::getStatus()
{
    return status;
}

Order* Table::getOrder()
{
    return order;
}

//status method
void Table::pSeated(int numPeople)
{
    if(status == IDLE)
    {
        if(numPeople <= mSeats)
        {
            status = SEATED;
            nPeople = numPeople;
            cout << "Party of " << nPeople << " assigned to Table " << tableNum << endl;
        }
        else
        {
            cout << "Sorry, max " << mSeats << " seats in Table " << tableNum << "!" << endl;
        }
    }
    else
    {
        cout << "Table " << tableNum << " is already occupied!" << endl;
    }
}

void Table::pOrdered(string items, Menu *menu)
{
    if(status == SEATED)
    {
        order = new Order(items, menu);
        cout << order->getNItems() <<" items ordered for Table " << tableNum << endl;
        status = ORDERED;
    }
    else
    {
        cout << "Party is not seated!" << endl;
    }
}

void Table::pServed()
{
    if(status == ORDERED)
    {
        status = SERVED;
        cout<<"Food served in table " << tableNum << endl;
    }
    else
    {
         cout << "Order not placed at Table " << tableNum << " yet!" << endl;
    }
}

void Table::pCheckout()
{
    if(status == SERVED)
    {
        cout << "Table " << tableNum << " is closed. Here is the bill." << endl;
        cout << endl;
        cout << "Receipt Table #" << tableNum << " Party " << nPeople << endl;
        order->printO();

        delete order;
        nPeople = 0;
        order = NULL;
        status = IDLE;
    }
    else
    {
        cout << "Food not served for Table " << tableNum << " yet!" << endl;
    }
}

//other methods
void Table::addItems(string items,Menu *menu)
{
    int itemsO = order->addItem(items, menu);
    cout << itemsO << " additional items ordered for Table " << tableNum << endl;
    status = ORDERED;
}

//destructor
Table::~Table()
{
    //dtor
}