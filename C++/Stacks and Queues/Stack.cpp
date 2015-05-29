#include "Stack.h"
#include <iostream>
#include <string>

void Stack::push (std::string value) {
	Node *node = new Node (value);
	if (top==NULL) 
		top = node;
	else {
		node -> setNext(top);
		top = node;
	}
	node = NULL;
	delete node; // precaution
}


std::string Stack::pop () {
	if (top!=NULL) {
		std::string temp = top -> getVal();
		top = top -> getNext();

		return temp; 
	} else
		return NULL;
}
