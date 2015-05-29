#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include <string>
#include "Node.h"

class LinkedList {
	protected:
		Node *top;

	public:
		LinkedList ();
		~LinkedList ();
		virtual void push (std::string value) = 0;
		virtual std::string pop () = 0;
		std::string peek ();
		void traverse ();
};


#endif