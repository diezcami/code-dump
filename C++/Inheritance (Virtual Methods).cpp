#include <iostream>
/*
	Manually Inherited Constructors
 */
class Shape {
	protected:
		int side;
	public:
		Shape (int s):
		side(s) {}

		virtual int get_area () {
			return side;
		}
};


class Triangle:public Shape {
	public:
		Triangle (int s):
		Shape(s) {}
		int get_area () {
			return side*side/2;
		}
};

class Square:public Shape {
	public:
		int get_area () {
			return side*side;
		}
};

int main () {
	Shape shapey(3);
	std::cout << shapey.get_area() << std::endl; // Virtual, but can still be called
	Triangle triangey(4);
	std::cout << triangey.get_area() << std::endl; // uses overriden method
}