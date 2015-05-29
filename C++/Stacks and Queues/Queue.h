#ifndef QUEUE_H
#define QUEUE_H

#include <string>
#include "LinkedList.h"

class Queue : public LinkedList {
	private:
		Node *end;

	public:
		Queue();
		virtual void push (std::string value);
		virtual std::string pop ();
};

#endif