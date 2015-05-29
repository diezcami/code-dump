#include "Queue.h"
#include <iostream>
#include <string>

Queue::Queue ():
LinkedList() {
	end = NULL;
}

void Queue::push (std::string value) {
	Node *node = new Node (value);
	if (top == NULL && end == NULL) {
		top = node;
		end = node;
	} else {
		end -> setNext (node);
		end = node;
	}
}


std::string Queue::pop () {
	if (end == NULL && top == NULL)
		return NULL;
	else {
		std::string temp = top -> getVal();
		top = top -> getNext();

		return temp;
	}
}
