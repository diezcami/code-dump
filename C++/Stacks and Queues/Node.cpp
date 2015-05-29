#include "Node.h"
#include <iostream>
#include <string>


Node::Node (std::string val) :
value(val) {
	next = NULL;
}

Node::~Node () {
	delete next;
	next = NULL;
}

void Node::setNext (Node *node) {
	next = node;
}

Node* Node::getNext () {
	return next;
}

void Node::printVal () {
	std::cout << value << std::endl;
}

std::string Node::getVal () {
	return value;
}