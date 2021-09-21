/*
    Krithika Kannan
    KXK180046
    10.12 Restaurant Operations
    Menu.cpp
    5/6/2020
*/

//header files
#include "Menu.h" //menu header

//constructor
Menu::Menu(ifstream &finput)
{
    //initialize items
    int arrMax = 100;
    menupt = new MenuItem*[arrMax];

    //variables to store data
    nItems = 0;
    string code;
    string name;
    double price;
    
    //read in values
    while(finput >> code >> name >> price)
    {
        menupt[nItems] = new MenuItem(code, name, price); //create menu items
        nItems++; //increase item count
    }

}

//methods
/*
void Menu::addItem(MenuItem aItem)
{
    menupt[nItems++] = aItem;
}
*/

MenuItem* Menu::findItem(const string iCode)
{
    for(int i = 0; i < nItems; i++)
    {
        if(menupt[i]->getItemCode() == iCode)
        return menupt[i];
    }
    return NULL;
}

int Menu::findItemIndex(const string iCode)
{
    for(int i = 0; i < nItems; i++)
    {
        if(menupt[i]->getItemCode() == iCode)
        {
            return i;
        }
    }
    return -1;
}

//destructor
Menu::~Menu()
{
    //dtor
}