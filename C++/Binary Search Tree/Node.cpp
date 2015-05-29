#include "Node.h"
#include <iostream>
#include <string>

Node::Node (std::string val) :
value (val),
left (NULL),
right (NULL) {}

Node::~Node () {
	delete left;
	delete right;
	left = NULL;
	right = NULL;
}

void Node::printValue () {
	std::cout << value << std::endl;
}

std::string Node::getValue () {
	return value;
}

Node* Node::getLeft () {
	return left;
}

Node* Node::getRight () {
	return right;
}

void Node::setValue (std::string val) {
	value = val;
}

void Node::setLeft (Node *temp) {
	left = temp;
}

void Node::setRight (Node *temp) {
	right = temp;
}