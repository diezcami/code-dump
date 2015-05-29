_f = [-1] * 101

def top_down (k): #Memo
    if _f[k]!=-1: #Already in cache
        return _f[k]
    if k==0 or k==1: #End
        _f[k]=1
    if k>=2:  #Recurse values when they're not in the cache
        _f[k] = top_down(k-1) + top_down(k-2)
    return _f[k] #For the l

def bottom_up (k): #Dynamic
    _f[0]=1
    _f[1]=1   
    for x in range (2, k+1): #from 2 to k
        _f[x] = _f[x-1] + _f[x-2]
    return _f[k]

try:
    k = int(raw_input ("Enter an index (0-100) to retrieve from the fibonacci array: "))
    if k>=0 and k<=100:
        key = raw_input ("Enter 0 for topdown, 1 for bottom-up: ")
        if key=="0":
            print ("Top Down: " + str(top_down(k)))
       
        elif key=="1":
            print ("Bottom-Up: " + str(bottom_up(k)))
    
        else:
            print "Key must be 1 or 2"
    else:
        print "K is not in range"
except:
    print "Input cannot be parsed"