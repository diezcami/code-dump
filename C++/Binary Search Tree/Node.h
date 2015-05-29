#ifndef NODE_H
#define NODE_H

#include <string>

class Node {
	private: // 3
		std::string value;
		Node *left;
		Node *right;

	public: // 9
		Node(std::string val);
		~Node();
		void printValue ();
		std::string getValue ();
		Node* getLeft ();
		Node* getRight ();
		void setValue (std::string val);
		void setLeft (Node *child);
		void setRight (Node *child);
};

#endif