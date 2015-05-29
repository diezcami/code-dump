#ifndef NODE_H
#define NODE_H

#include <string>

class Node {
	private:
		// Meh
		std::string value;
		Node *next;

	public:
		Node (std::string val);
		~Node();

		void setNext (Node *node);
		Node* getNext ();

		void printVal ();
		std::string getVal ();
};


#endif