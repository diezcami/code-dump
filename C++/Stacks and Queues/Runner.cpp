#include "Queue.h"
#include "Stack.h"
#include <iostream>
#include <string>


int main () { 
Queue stacky;
	stacky.push("hello");
	stacky.push("my");
	stacky.push("name");
	stacky.push("is");
	stacky.push("cami");

	stacky.traverse();
	stacky.pop();
	stacky.pop();
	stacky.pop();
	std::cout << std::endl;
	stacky.traverse();

	Node *foo = new Node ("Foo");
	Node *bar = new Node ("Bar");

	foo -> setNext (bar);
	foo -> printVal ();
	foo -> getNext () -> printVal ();

}