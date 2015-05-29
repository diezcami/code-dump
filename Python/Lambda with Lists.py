def binary_search (wordlist, word):
    start=0
    end=len(wordlist)-1
    while start<=end:
        mid=(start+end)/2
        if wordlist[mid]==word: return True
        elif wordlist[mid]>word: #First Half
            end=mid-1
        else: #Second Half, A[mid]<key
            start=mid+1
    return False

def truncate_by_length(wordlist, min, max=0):
    if max==0:
        return filter (lambda word: len(word)>=min, wordlist)
    return filter (lambda word: len(word)>=min and len(word)<=max, wordlist)

def counts_by_length(wordlist):
    nums = map (lambda word: len(word), wordlist)
    return map(lambda x: (len(filter(lambda num: num==x, nums))), xrange(max(nums)+1))

#Assumption: No Duplicates
def list_reverse_pairs(wordlist):    
    def add (output, word):
        return output + [word] + [word[::-1]]
    return reduce (add, filter (lambda word: word[::-1] in wordlist[wordlist.index(word):] and word[::-1]!=word, wordlist), [])
    