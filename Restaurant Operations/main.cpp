/*
    Krithika Kannan
    KXK180046
    10.12 Restaurant Operations
    main.cpp 
    5/6/2020
*/

//files
#include "Menu.h"
#include "MenuItem.h"
#include "Order.h"
#include "Table.h"

//header files
#include <iostream> //for cin/cout
#include <fstream> //for ifstream

using namespace std;

//constant global variables
const int arrMax = 100;

//global variables
Table *tables[arrMax];
int numTables = 0;

//Prototype
int getTableIndex(int tableN);

/*
    The Restaurant Operations program manages tables at a restaurant by keeping track of the number of 
    people allowed to sit at a table, the orders taken at a table, and the total bill of the table.
*/
int main()
{
    //reads text file
    string temp;
    ifstream finput("config.txt");
    getline(finput, temp);
    int tableNum;
    int maxSeats;
    while(finput >> tableNum >> maxSeats)
    {
        tables[numTables] = new Table(tableNum, maxSeats);
        numTables++;
    }
    finput.clear();
    getline(finput, temp);
    Menu *menu = new Menu(finput);

    //User input
    while(true)
    {
        string in;
        getline(cin, in);
        istringstream istr(in);
        int tablenum;
        if(istr >> tablenum)
        {
            int tableIndex = getTableIndex(tablenum);
            if(tableIndex == -1)
            {
                cout << "Table does not exist!" << endl;
            }
            char op;
            istr >> op;
            if(op == 'P')
            {
                int party;
                istr >> party;
                if(tables[tableIndex]->getStatus() == IDLE)
                {
                    tables[tableIndex]->pSeated(party);
                }
                else
                {
                    cout << "Table " << tablenum << " already occupied!" << endl;
                }
            }
            if(op == 'O')
            {
                string orderString = "";
                string tempS;
                while(istr >> tempS)
                {
                    orderString = orderString + " " + tempS;
                }
                if(tables[tableIndex]->getStatus() == SEATED)
                {
                    tables[tableIndex]->pOrdered(orderString, menu);
                }
                else if(tables[tableIndex]->getStatus() == SERVED)
                {
                    tables[tableIndex]->addItems(orderString, menu);
                }
            }
            if(op == 'S')
            {
                tables[tableIndex]->pServed();
            }
            if(op == 'C')
            {
                tables[tableIndex]->pCheckout();
            }
        }
        else
        {
            cout << "Cannot be read as number, closing program" << endl;
            break;
        }
    }
    return 0;
}

//methods
int getTableIndex(int tableN)
{
    for(int i = 0; i < numTables; i++)
    {
        if(tables[i]->getTableId() == tableN)
        {
            return i;
        }
    }
    return -1;
}