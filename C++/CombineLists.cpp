#include <iostream>
#include <vector>

void combine (char* foo, char* bar, char *foobar, int size_foo, int size_bar, int size_foobar);

int main () {
	char foo[5] = {'1', '2', '3', '4', '5'};
	char bar[3] = {'a', 'b', 'c'};
	char foobar[sizeof(foo)+sizeof(bar)];
	combine (foo, bar, foobar, sizeof(foo), sizeof(bar), sizeof(foobar));
	for (int i=0; i<sizeof(foobar); i++) 
		std::cout << foobar[i] << " ";
	std::cout << std::endl;
}

void combine (char *foo, char *bar, char *foobar, int size_foo, int size_bar, int size_foobar) {
	int minsize = std::min(size_foo, size_bar);	

	for (int i=0; i<minsize; i++) {
		foobar[2*i] = foo[i];
		foobar[(2*i)+1] = bar[i];
	}

	int fb_index = minsize*2;
	if (size_foo > minsize) {
		while (fb_index < size_foobar) {
			foobar [fb_index++] = foo [minsize++];
		}
	} else if (size_bar > minsize) {
		while (fb_index < size_foobar)  {
			foobar [fb_index++] = bar [minsize++];
		}
	}
}