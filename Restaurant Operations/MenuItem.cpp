/*
    Krithika Kannan
    KXK180046
    10.12 Restaurant Operations
    MenuItem.cpp 
    5/6/2020
*/

//header files
#include "MenuItem.h" //menu item header

//constructor
MenuItem::MenuItem(string itemCode, string name, double price)
{
	this->itemCode = itemCode;
	this->name = name;
	this->price = price;
}

//get methods
string MenuItem::getItemCode()
{
	return itemCode;
}
string MenuItem::getName()
{
	return name;
}
double MenuItem::getPrice() 
{
	return price;
}

//set methods
void MenuItem::setItemCode(string itemCode)
{
    this->itemCode =itemCode;
}
void MenuItem::setName(string name)
{
    this->name = name;
}
void MenuItem::setPrice(double price)
{
    this->price = price;
}

//destructor
MenuItem::~MenuItem()
{
    //dtor
}