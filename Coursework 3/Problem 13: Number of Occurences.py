inp = input()
count = 0
wordList = inp.split()
#print(wordList)
dictList = {}
for word in wordList:
    if word in dictList:
        dictList[word] += 1
        print(str(dictList[word]) + " ", end ="")
    else:
        dictList[word] = count
        print(str(dictList[word]) + " ", end="")

