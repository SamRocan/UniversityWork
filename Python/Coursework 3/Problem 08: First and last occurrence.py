word = input()
length = len(word)
output = ""
outputPt2 = ""
#finds all occourences of f
for i in range(0, length) :
    if (word[i] == "f") and (output == ""):
      output+=str(i)+" "
    elif (word[i] == "f"):
      outputPt2 = " " + str(i)
      
outputFinal = output+outputPt2
#if no matches, returns -1
if outputFinal == "":
  outputFinal ="-1"
print(outputFinal)