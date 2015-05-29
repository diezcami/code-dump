#include "BSTree.h"
#include <iostream>
#include <string>

BSTree::BSTree () :
root (NULL),
nodeCount (0) {
}

BSTree::~BSTree () {
	clearTree(root);
}

int BSTree::getNodeCount () {
	return nodeCount;
}

void BSTree::traverse () {
	if (root == NULL) 
		std::cout << "The BSTree is empty. :(" << std::endl;
	else
		traverse (root);
}

void BSTree::traverse (Node *temp) {
	if (temp!=NULL) {
		traverse (temp -> getLeft());
		temp -> printValue();
		traverse (temp -> getRight());
	}
}

void BSTree::insertValue (std::string val) {
	Node *temp = new Node (val);

	if (root == NULL) {
		root = temp;
	} else {
		Node *pointer = root;
		while (pointer!=NULL) {
			if (val.compare(pointer -> getValue()) < 0) {
				if (pointer -> getLeft() == NULL) {
					pointer -> setLeft (temp);
					break;
				} else
					pointer = pointer -> getLeft();
			} else { 
				if (pointer -> getRight() == NULL) {
					pointer -> setRight (temp);
					break;
				} else
					pointer = pointer -> getRight();			
			}
		}
		pointer = NULL;
		delete pointer;
	}

	temp = NULL;
	delete temp;
	nodeCount++;
	std::cout << "Value " << val << " has been inserted!" << std::endl;
}

void BSTree::removeValue (std::string val) {
	if (root==NULL)
		std::cout << "The BSTree is empty - values cannot be deleted." <<std::endl;

}

void BSTree::removeValue (std::string val, Node *temp) {

	bool isLeftChild = false;
	Node* parentOfTarget = removeHelper (val, root, isLeftChild);
	Node* target = isLeftChild? parentOfTarget -> getLeft() : parentOfTarget -> getRight ();

	// Target is a Leaf
	if 


}

Node* BSTree::removeHelper (std::string val, Node *temp, bool& isLeftChild) {
	if (temp!=NULL) {
		if (temp -> getLeft() -> getValue() == val)
			isLeftChild = true;
			return temp;
		if (temp -> getRight() -> getValue() == val)
			isRightChild = false;
			return temp;
	}

	if (temp == root)
		return NULL;
}



bool BSTree::findValue (std::string val) {
	return findValue (val, root);
}

bool BSTree::findValue (std::string val, Node *temp) {
	if (temp!=NULL) {
		if (temp -> getLeft() != NULL)
			findValue (val, temp -> getLeft());
		if (temp -> getRight() != NULL)
			findValue (val, temp -> getRight());
		if (temp -> getValue () == val) {
			std::cout << "Value " << val << " has been found!" << std::endl;
			return true;
		}
	} else {
		std::cout << "The BSTree is empty - values cannot be found." << std::endl;
		return false;
	}

	if (temp==root)
		std::cout << "Value " << val << " has not been found." << std::endl;

	return false;
}

void BSTree::clearTree () {
	clearTree (root);
	nodeCount = 0;
	std::cout << "BSTree has successfully been cleared :(" << std::endl;
}

void BSTree::clearTree (Node *temp) {
	if (temp!=NULL) {
		clearTree (temp -> getLeft());
		clearTree (temp -> getRight());
		temp -> setRight (NULL);
		temp -> setLeft (NULL);
		delete temp;
		temp = NULL;
	}
}