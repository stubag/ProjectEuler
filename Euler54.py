import time
start_time = time.time()

#f = open("poker.txt", "r")
f = open("poker1.txt", "r")
#f = open("poker2.txt", "r")
playerOneWins = 0
playerTwoWins = 0

def convVal(num):
    if num == "T":
        return 10
    elif num == "J":
        return 11
    elif num == "Q":
        return 12
    elif num == "K":
        return 13
    elif num == "A":
        return 14
    else:
        return num

def splitHand(cards):
    nums = []
    suits = []
    for a in cards:
        nums.append(int(convVal(a[0])))
        suits.append(a[1])
    return [nums, suits];

def isPair(nums):
    twoPairVal = 0
    threePairVal = 0
    fourPairVal = 0
    count = 0
    for num in nums:
        if nums.count(num) == 2:
             if int(num) > twoPairVal:
                twoPairVal = num
        if nums.count(num) == 3:
            if int(num) > threePairVal:
                threePairVal = num
        if nums.count(num) == 4:
            if int(num) > fourPairVal:
                fourPairVal = num
    if fourPairVal > 0:
        return [[4], [fourPairVal], sorted(nums, reverse=True)]
    elif threePairVal > 0:
        return [[3], [threePairVal], sorted(nums, reverse=True)]
    elif twoPairVal > 0:
        return [[2], [twoPairVal], sorted(nums, reverse=True)]
    else:
        return False

def isTwoPair(nums):
    firstPair = 0
    secondPair = 0
    for num in nums:
        if nums.count(num) == 2 and firstPair == 0:
            firstPair = num
        if nums.count(num) == 2 and firstPair != 0 and secondPair == 0 and num != firstPair:
            secondPair = num
    if firstPair != 0 and secondPair != 0:
            pairVal = [firstPair, secondPair]
            pairVal = sorted(pairVal)
            return [[True], pairVal, sorted(nums, reverse=True)]
    else:
        return False

def isFlush(nums, suits):
    if suits.count(suits[0]) == 5:
        return [[True], sorted(nums, reverse=True)]
    else:
        return False
       

def isStraight(nums):
    range_list=list(range(min(nums), max(nums)+1))
    if range_list == sorted(nums):
        return [[True], sorted(nums, reverse=True)]
    else:
        return False

def isRoyalFlush(nums, suits):
    if (sorted(nums) == [10, 11, 12, 13, 14]) and (suits.count(suits[0]) == 5):
        return [['True'], sorted(nums, reverse=True)];
    else:
        return False
    
def highCard(nums):
    return [sorted(nums, reverse=True)]


def isStraightFlush(nums, suits):
    aStraight = isStraight(nums)
    aFlush = isFlush(nums, suits)
    if (aStraight != False) and (aFlush != False):
        if (aStraight[0][0] == True) and (aFlush[0][0] == True):
            return [[1], sorted(nums, reverse=True)]
    else:
        return False

def isFullHouse(nums):
    sortVal = sorted(nums)
    distinct  = list(set(nums))
    if (sortVal[0] == sortVal[1]) and (sortVal.count(sortVal[2]) == 3) and (sortVal[0] != sortVal[2]):
        return [[True], sorted(nums, reverse=True)]
    elif (sortVal[3] == sortVal[4]) and (sortVal.count(sortVal[0]) == 3) and (sortVal[0] != sortVal[3]):
        return [[True], sorted(nums, reverse=True)]
    else:
        return False
    


def playerHands(handNum, hand):
    split = splitHand(hand)
    royalFlush = isRoyalFlush(split[0], split[1])
    straightFlush = isStraightFlush(split[0], split[1])
    pairVal = isPair(split[0])
    fullHouse = isFullHouse(split[0])
    straight = isStraight(split[0])
    hCard = highCard(split[0])
    flush = isFlush(split[0], split[1])
    twoPair = isTwoPair(split[0])
    if royalFlush != False:
        return [[10] , ['Royal Flush']]
    elif straightFlush != False:
        return [[9], straightFlush[1], ['Straight Flush']]
    elif (pairVal != False) and (pairVal[0][0] == 4):
        return [[8], pairVal[1], pairVal[2], ['Four of A Kind']]
    elif fullHouse != False:
        return [[7], fullHouse[1], ['Full House']]
    elif flush != False:
        return [[6], flush[1], ['Flush']]
    elif straight != False:
        return [[5], straight[1], ['Straight']]
    elif (pairVal != False) and (pairVal[0][0] == 3):
        return [[4], pairVal[1], pairVal[2], ['Three of a Kind']]
    elif (twoPair != False):
        return [[3], pairVal[1], ['Two Pair']]
    elif (pairVal != False) and (pairVal[0][0] == 2):
         return [[2], pairVal[1], pairVal[2], ['Pair']]
    else:
        return [[1], [hCard], ['High Card']]

def determineWinner(playerOneHands, playerTwoHands):
    global playerOneWins, playerTwoWins
    if playerOneHands[0][0] > playerTwoHands[0][0]:
        #print('Player One Wins: ', playerOneHands)
        playerOneWins += 1
        return [[1], playerOneHands]
    elif playerTwoHands[0][0] > playerOneHands[0][0]:
        #print('Player Two Wins: ', playerTwoHands)
        playerTwoWins += 1
        return [[2], playerTwoHands]
    elif playerOneHands[0][0] == playerTwoHands[0][0]:
        i = 0
        if playerOneHands[0][0] in [2, 4, 8]:
            if playerOneHands[1][0] > playerTwoHands[1][0]:
                playerOneWins += 1
                #print('Player One Wins: ', playerOneHands)
                return[[1], playerOneHands]
            elif playerTwoHands[1][0] > playerOneHands[1][0]:
                playerTwoWins += 1
                #print('Player Two Wins: ', playerTwoHands)
                return[[1], playerTwoHands]
            else:
                while (i <= 4):
                    if playerOneHands[2][i] > playerTwoHands[2][i]:
                        playerOneWins +=1
                        #print('Player One Wins: ', playerOneHands)
                        i = 5
                        return[[1], playerOneHands]
                    elif playerTwoHands[2][i] > playerOneHands[2][i]:
                        playerTwoWins +=1
                        #print('Player Two Wins: ', playerTwoHands)
                        i = 5
                        return[[1], playerTwoHands]
                    else:
                        i += 1
        else:
            while (i <= 4):
                if playerOneHands[1][i] > playerTwoHands[1][i]:
                    playerOneWins +=1
                    #print('Player One Wins: ', playerOneHands)
                    i = 5
                    return[[1], playerOneHands]
                elif playerTwoHands[1][i] > playerOneHands[1][i]:
                    playerTwoWins +=1
                    #print('Player Two Wins: ', playerTwoHands)
                    i = 5
                    return[[1], playerTwoHands]
                else:
                    i += 1
            
            
            

handNum = 0
for x in f:
    playerOne = []
    playerTwo = []
    x = x.strip('\n')
    cards = x.split(' ')
    count = 0
    for c in cards:
        if count < 5:
            playerOne.append(c)
        else:
            playerTwo.append(c)
        count += 1
    handNum += 1
    playerOneHands = playerHands(handNum, playerOne)
    playerTwoHands = playerHands(handNum, playerTwo)
    #print('Hand Num: ', handNum, ' - Player One has: ', playerOneHands, ' -- Player Two has: ', playerTwoHands)
    winner = determineWinner(playerOneHands, playerTwoHands)
         

print('Player One Wins: ', playerOneWins, ' -- Player Two Wins: ', playerTwoWins)
print("--- %s seconds ---" % (time.time() - start_time))
