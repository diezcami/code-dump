#ifndef BSTREE_H
#define BSTREE_H

#include <string>
#include "Node.h"

class BSTree {
	private: // 2
		Node *root;
		int nodeCount;
		void traverse (Node *temp);
		void removeValue (std::string val, Node *temp);
		Node* removeHelper (std::string val, Node *temp, bool& isLeftChild);
		bool findValue (std::string val, Node *temp);
		void clearTree (Node *temp);


	public: // 7
		BSTree ();
		~BSTree ();
		int getNodeCount ();
		void traverse ();
		void insertValue (std::string val);
		void removeValue (std::string val);
		bool findValue (std::string val);
		void clearTree ();
};

#endif