#include "LinkedList.h"
#include <iostream>
#include <string>

LinkedList::LinkedList () {
	top = NULL;
}

LinkedList::~LinkedList() {
	while (top!=NULL) {
		Node *temp = top;
		delete temp;
		top = top -> getNext();
		temp = NULL;
	} // top = NULL
}

std::string LinkedList::peek () {
	if (top!=NULL)
		return top -> getVal();
	else
		return NULL;
}

void LinkedList::traverse () {
	if (top!=NULL) {
		Node *temp = top;
		while (temp!=NULL) {
			temp -> printVal();
			temp = temp -> getNext();
		}
		delete temp;
		temp = NULL;
	} else
		std::cout << "List is Empty" << std::endl;
}

