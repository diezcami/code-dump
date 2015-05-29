#ifndef STACK_H
#define STACK_H

#include <string>
#include "LinkedList.h"

class Stack : public LinkedList {
	public:
		using LinkedList::LinkedList;
		virtual void push (std::string value);
		virtual std::string pop ();
};

#endif