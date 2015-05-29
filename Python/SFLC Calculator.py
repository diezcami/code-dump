from math import log10, floor

def cami ():
    print ""
    print "Hello, welcome to Cami's LC Range Calculator!"    
    print_menu()
    
    num = int(raw_input ("Enter your key: "))
    options = { # Switch/Case Alternative
        0 : multiply, 
        1 : divide,
        2 : volume,
        3 : density,
        4 : byebye
    }   
    print ""
    
    options[num]()
    
# Prints out the menu   
def print_menu ():
    print " [0]: L1 * L2"
    print " [1]: L1 / L2"
    print " [2]: Calculate Volume (LWH) or L1^3"
    print " [3]: Calculate Density"
    print " [4]: Exit Program"            

# Main Functions      
def multiply ():
    # Receiving Input
    print "<<< START OF L1 * L2 FUNCTION >>>"
    l1 = float(raw_input("Enter L1: "))
    l1_lc = float (raw_input("Enter the Lowest Count of L1: "))
    l2 = float(raw_input("Enter L2: "))
    l2_lc = float(raw_input("Enter the Lowest Count of L2: "))
    sf = min(len(str(l1))-1, len(str(l2))-1)
    sf_lc = min(len(str(l1_lc))-2, len(str(l2_lc))-2)
    print ">> SOLUTION"
    
    # Percent Value for L1
    l1_p = l1_lc / l1
    print "L1: Converting to RE: " + str(l1_lc) + " / " + str(l1) + " = " + str(l1_p)
    l1_p *= 100
    print "L1: Taking Percent Form: " + str(l1) + " +- " + str(l1_p) + "%"
    
    # Percent Value for L2
    l2_p = l2_lc / l2
    print "L2: Converting to RE: " + str(l2_lc) + " / " + str(l2) + " = " + str(l2_p)
    l2_p *= 100
    print "L2: Taking Percent Form: " + str(l2) + " +- " + str(l2_p) + "%"
    
    # Adding l1_lc% and l2_lc%:
    final_p = l1_p + l2_p
    final_l = l1 * l2
    print ">> ANSWERS (DOUBLE CHECK SFs)"
    print "l1_lc% + L2C%: " + str(final_p)+ "%"
    print "*** L1 * L2: " + str(final_l) + " +- " + str(final_p)+ "%"
            
    print "<<< END OF L1 * L2 FUNCTION >>>"
    ask_again()
    
def divide():
    # Receiving Input
    print "<<< START OF L1 / L2 FUNCTION >>>"
    l1 = float(raw_input("Enter L1: "))
    l1_lc = float (raw_input("Enter the Lowest Count of L1: "))
    l2 = float(raw_input("Enter L2: "))
    l2_lc = float(raw_input("Enter the Lowest Count of L2: "))
    sf = min(len(str(l1))-1, len(str(l2))-1)
    sf_lc = min(len(str(l1_lc))-2, len(str(l2_lc))-2)
    
    print ">> SOLUTION"
    
    # Percent Value for L1
    l1_p = l1_lc / l1
    print "L1: Converting to RE: " + str(l1_lc) + " / " + str(l1) + " = " + str(l1_p)
    l1_p *= 100
    print "L1: Taking Percent Form: " + str(l1) + " +- " + str(l1_p) + "%"
    
    # Percent Value for L2
    l2_p = l2_lc / l2
    print "L2: Converting to RE: " + str(l2_lc) + " / " + str(l2) + " = " + str(l2_p)
    l2_p *= 100
    print "L2: Taking Percent Form: " + str(l2) + " +- " + str(l2_p) + "%"
    
    # Adding l1_lc% and l2_lc%:
    final_p = l1_p + l2_p
    final_l = l1 / l2, sf
    print ">> ANSWERS (DOUBLE CHECK SFs)"
    print "l1_lc% + L2C%: " + str(final_p)+ "%"
    print "*** L1 / L2: " + str(final_l) + " +- " + str(final_p)+ "%"
            
    print "<<< END OF L1 / L2 FUNCTION >>>"
    ask_again()
    
def volume():
    # Receiving Input
    print "<<< START OF VOLUME/ L^3 FUNCTION >>>"
    length = float(raw_input("Enter Length: "))
    length_lc = float (raw_input("Enter the Lowest Count of Length: "))
    width = float(raw_input("Enter Width: "))
    width_lc = float(raw_input("Enter the Lowest Count of Width: "))
    height = float(raw_input("Enter Height: "))
    height_lc = float(raw_input("Enter the Lowest Count of Height: "))    
    sf = min(len(str(length))-1, min(len(str(height))-1, len(str(width))-1))
    sf_lc = min(len(str(length_lc))-2, min(len(str(height_lc))-2, len(str(width_lc))-2))
    print ">> SOLUTION"
    
    # Percent Value for Length
    length_p = length_lc / length
    print "Length: Converting to RE: " + str(length_lc) + " / " + str(length) + " = " + str(length_p)
    length_p *= 100
    print "Length: Taking Percent Form: " + str(length) + " +- " + str(length_p) + "%"

    # Percent Value for Width
    width_p = width_lc / width
    print "Width: Converting to RE: " + str(width_lc) + " / " + str(width) + " = " + str(width_p)
    width_p *= 100
    print "Width: Taking Percent Form: " + str(width) + " +- " + str(width_p) + "%"
 
    # Percent Value for Height
    height_p = height_lc / height
    print "Height: Converting to RE: " + str(height_lc) + " / " + str(height) + " = " + str(height_p)
    height_p *= 100
    print "Height: Taking Percent Form: " + str(height) + " +- " + str(height_p) + "%"
      
    
    # Adding l1_lc% and l2_lc%:
    final_p = length_p + width_p + height_p
    final_l = length * width * height
    print ">> ANSWERS (DOUBLE CHECK SFs)"
    print "Length LC% + Width LC% + Height LC%: " + str(final_p)+ "%"
    print "*** LWH: " + str(final_l) + " +- " + str(final_p)+ "%"
            
    print "<<< END OF VOLUME / L^3 FUNCTION >>>"
    ask_again()
    
def density():
    print "<<< START OF DENSITY FUNCTION >>>"
    mass = float(raw_input("Enter Mass: "))
    mass_lc = float (raw_input("Enter the Lowest Count of Mass: "))
    volume = float(raw_input("Enter Volume: "))
    volume_p = float(raw_input("Enter the Lowest Count of Volume (IN %): "))
    sf = min(len(str(mass))-1, len(str(volume))-1)
    print ">> SOLUTION"
    
    # Percent Value for L1
    mass_p = mass_lc / mass
    print "Mass: Converting to RE: " + str(mass_lc) + " / " + str(mass) + " = " + str(mass_p)
    mass_p *= 100
    print "Mass: Taking Percent Form: " + str(mass) + " +- " + str(mass_p) + "%"
    
    
    # Adding l1_lc% and l2_lc%:
    final_p = mass_p + volume_p
    final_l = mass / volume
    print ">> ANSWERS (DOUBLE CHECK SFs)"
    print "Volume LC% + Mass LC%: " + str(final_p)+ "%"
    print "*** Density (M/V): " + str(final_l) + " +- " + str(final_p)+ "%"
            
    print "<<< END OF L1 / L2 FUNCTION >>>"
    ask_again()

# Misc Functions  
def sig(num, sf=2): #Default 2 SF
    return round(num, sf-int(floor(log10(num)))-1)
def ask_again():
    ans = raw_input("Would you like to perform another operation? (Y/N): ")
    if ans.lower()=="y": cami()
    else: byebye()   
def byebye():
    print "Bye!"

# BOOM
cami()