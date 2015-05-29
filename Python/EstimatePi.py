#131356 Camille Diez
import math

def calculate_term(k):
    return ((-1)**k * math.factorial(6*k) * (13591409+545140134*k)) / (math.factorial(3*k) * math.factorial(k)**3 * 640320**(3*k + 1.5))
    
def estimate_pi(sen=1e-15):
    total=0
    i=0    
    while True:
        current = calculate_term(i)
        if abs(current)>=sen:
            total+=current
            i+=1
        else:
            break
                       
    return 1/(total*12)

temp = raw_input("Enter Sensitivity (Invalid input uses 1e-15 as the default sensitivity: ")
try:
    input = float(temp)
    print estimate_pi(input)
except: #No input
    print estimate_pi()