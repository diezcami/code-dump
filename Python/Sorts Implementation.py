import random
#Binary Search Algorithms: Return index if found, -1 otherwise
def binary_searchR (A, key, start, end):
    if start>end: return -1   
    mid=(start+end)/2    
    if A[mid]==key: return mid
    elif A[mid]>key: #First Half
        return binary_searchR (A, key, start, mid-1)
    else: #Second Half
        return binary_searchR (A, key, mid+1, end) 
               
def binary_search (A, key):
    start=0
    end=len(A)-1
    while start<=end:
        mid=(start+end)/2
        if A[mid]==key: return mid
        elif A[mid]>key: #First Half
            end=mid-1
        else: #Second Half, A[mid]<key
            start=mid+1
    return -1
    
def selection_sort (A): #Finding the minimum
    for i in range(len(A)): #Supposedly up to n-2 (Second to the last array index)
        minimum=A[i] #Minimum Int
        minIndex=i #Assume i is the minimum
        j=i
        while (j<len(A)): #Finds minimum
            if A[j]<minimum:
                minimum=A[j]
                minIndex=j
            j+=1
        A[minIndex] = A[i] #Old number goes to minimum's old slot 
        A[i] = minimum       
    return A

def insertion_sort (A):
    i=1
    while (i<len(A)-1):
        temp=A[i] #In case swaps occur
        j=i
        while (j>=1 and temp<A[j-1]):
            A[j] = A[j-1]
            j-=1
        A[j] = temp 
        i+=1
        
def bubble_sort (A): 
    i=1
    while (i<len(A)): #From Start to End
        swapped=False
        j=len(A)-1;
        while (j>=i): #[i] [      j] From end to start up to i
            if A[j]<A[j-1]:
                temp=A[j]
                A[j]=A[j-1]
                A[j-1]=temp
                swapped = True
            j-=1
        if not swapped:
            break
        i+=1
    return A 

def quick_sortSO (A):
    if len(A) <= 1:
        return A
    return quick_sort([x for x in A[1:] if x<A[0]]) + [A[0]] + quick_sort([x for x in A[1:] if x>=A[0]])
        
def merge_split (A): # Return an array
    if len(A)<=1: return A
    mid = int(len(A)/2)
    print "Split"
    return merge_sort (A[:mid], A[mid:])

def merge_sort (A1, A2): # Return an array
    if len(A1)>1: return merge_split(A1)
    if len(A2)>1: return merge_split(A2)
    print "Merging " + str(A1) + " " + str(A2)
    total = len(A1) + len(A2)
    A = [0]*total #Array[total]
    i=0 #A1 Index
    j=0 #A2 Index
    h=0 #A Index
    while (h<total):
        if i>=len(A1): #Check if indices exceed lengths
            print "Case 1"
            A[h]=A2[j]
            j+=1
        elif j>=len(A2):
            print "Case 2"
            A[h]=A1[i]
            i+=1
        elif A1[i]<A2[j]: #Compare values
            print "Case 3"
            A[h] = A1[i]
            i+=1
        elif A1[i]>=A2[j]:
            print "Case 4"
            A[h] = A2[j]
            j+=1
        h+=1
    return A
                 
def bogo_sort (A, count):
    random.shuffle(A) #hehe
    count=1
    i=1
    while (i<len(A)):
        if A[i-1]>A[i]: #Not sorted
            random.shuffle(A)
            count+=1
            i=1
        else:
            i+=1
    print A
    print "Method calls: " + str(count)
                
cuckoo = [9, 3, 7, 1, 9, 8, 7, 3, 2, 1, 9, -13, -73, -12, -82]
lovebird = [7, 2, 3, 19, -34, 108, 29, 8, -9, 21]
print lovebird

newbird = merge_split (lovebird)
print newbird
