#include "BSTree.h"
#include <iostream>
#include <string>

int main () {
	BSTree tree;
	tree.traverse();
	tree.insertValue("Cat");
	tree.insertValue("Dog");
	tree.insertValue("Apple");
	tree.insertValue("Bear");
	tree.traverse();
	std::cout << std::endl;

	tree.insertValue ("Flag");
	tree.insertValue ("Giraffe");
	tree.traverse();
	std::cout << std::endl;

	tree.removeValue ("Dog");
	tree.removeValue ("Big Cat");
	tree.traverse();
	
	tree.removeValue ("Dog");
	tree.removeValue ("Flag");
	tree.removeValue ("Giraffe");
	tree.removeValue ("Bear");

	tree.traverse();
}