class Matrix:
# ASSUME ALL OPERATION METHODS ACCEPT OTHER MATRIX INSTANCES AS PARAMETERS
# Basic Methods
    def __init__ (self, raw_input):
        # init
        self.body = []
    
        # Accepts Input
        if isinstance(raw_input, basestring):# Checks if it's in the '1 2; 3 4' format
            if raw_input.strip() == '' or raw_input.strip() ==';':
                self.body = [[]]
            else:
                input = raw_input.split (';') #Output: ['1 2', '3 4']
                for str in input:
                    str.strip()
                    temp_str = str.split (',') #Output: ['1', '2'] and ['3', '4']
                    temp_int = []
                    for x in temp_str:
                        temp_int.append(int(x)) #Output: [1, 2] and [3, 4]
                    self.body.append (temp_int)
                
        else: #Returns an actual matrix
            self.body = raw_input
            
        # Defines other attributes
        self.num_rows = len(self.body)
        if self.num_rows>0:
            self.num_cols = len(self.body[0]) #Assumes appropriate input
        else:
            self.num_cols = 0                    
    
    def get (self, i, j):
        return self.body[i][j]
        
    def set (self, i, j, value):
        self.body[i][j] = value
    
    def rows (self):
        return self.num_rows

    def cols (self):
        return self.num_cols

    def row (self, i):
        return self.body[i]

    def col (self, j):
        temp = []
        for row in self.body:
            temp.append(row[j])
        return temp

# Other Methods
    def equals (self, other):
        if other.rows()!=self.rows() or other.cols()!=self.cols():
            return False
    
        temp_other = []
        for x in range(other.rows()):
            temp_other.append (other.row(x))
            
        for row_a, row_b in zip(self.body, temp_other):
            for x, y in zip (row_a, row_b):
                if x!=y:
                    return False
        return True


    def is_square(self):
        return self.rows() == self.cols()
        
    def is_upper_triangular(self):
        if not self.is_square():
            return False
    
        count = 0
        for row in self.body:
            for x in range (0, count):
                if row[x]!= 0:
                    return False
            count += 1
        return True
        
    def is_lower_triangular(self):
        if not self.is_square():
            return False
            
        count = 1
        for row in self.body:
            for x in range (count, self.cols()):
                if row[x]!= 0:
                    return False
            count += 1
        return True
        
                
# Operation Methods
    def plus (self, other): #FIX ERROR HANDLING
        if other.rows()!=self.rows() or other.cols()!=self.cols():
            raise Exception('MatrixAdditionError')
            
        temp_body = []
    
        # Make other loopable
        temp_other = []
        for x in range(other.rows()):
            temp_other.append (other.row(x))
    
        # Actual Adding        
        for row_a, row_b in zip (self.body, temp_other):
            temp_row = []
            for x, y in zip (row_a, row_b):
                temp_row.append(x+y)
            temp_body.append (temp_row)
        return Matrix(temp_body)
        
    def negative(self):
        temp_body = []
        for row in self.body:
            row = map (lambda x: x*-1, row)
            temp_body.append(row)
        return Matrix(temp_body)
                
    def transpose(self):
        temp_body = []        
        for x in range(self.cols()):
            temp_body.append (self.col(x))          
        return Matrix(temp_body)
                
    def mult(self, other): #FIX ERROR HANDLING, FIX LIFE
        if self.cols() != other.rows():
            raise Exception('MatrixMultiplicationError')
    
        temp_body = []
    
        # Transpose other
        temp_other = []
        for x in range(other.cols()):
            temp_other.append (other.col(x))
    
        # Matrix End Result =  body.num_rows x other.num_cols
        for row_a in self.body:
            temp_row = []
            for row_b in temp_other:
                total = 0
                for x, y in zip (row_a, row_b):
                    total += x*y
                temp_row.append (total)
            temp_body.append (temp_row)
        
        return Matrix(temp_body)   
                    
    def scalar_mult(self, num):
        temp_body=[]
        for row in self.body:
            row = map (lambda x: x*num, row)
            temp_body.append(row)
        return Matrix(temp_body)
           
class Eye (Matrix):
#n x n identity matrix
    def __init__ (self, n):
        body = []
        for x in range(n):
            body.append([0]*n)
            
        count = 0;
        for row in body:
            row[count] = 1
            count+=1
        
        Matrix.__init__(self, body)  
    
    def mult(self, other):
       return other
   
class Zero (Matrix):
    def __init__ (self, m, n):
        body = []
        for x in range(m):
            body.append([0]*n)

        Matrix.__init__(self, body)
    
    def plus (self, other):
       return other