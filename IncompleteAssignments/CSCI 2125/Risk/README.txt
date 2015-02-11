README:

Risk Project
created by Scott Robertson
for CSCI 2120 at the University of New Orleans
12/9/2014

THIS GAME IS INCOMPLETE


DisplayGUI.java starts the game.
CommandPrompt prints out info to track progress (for the use of debugging, input validation, ect...)
Load and Save game options are currently unavailable.
Select New Game

NEW GAME SCREEN:  (Game State: 1)
Select any number of players (3-6)

PLAYER CREATION SCREEN: (Game State: 2)
Default player names and name of the game is entered
Type via keyboard the name of the game, and name of each player...if desired.  
Even null values are stored as empty strings.

WHO GOES FIRST SCREEN: (Game State: 3)
Each player rolls the dice, simulated by a random number generator and button click.
Start Setup button moves to the next screen, and also compares each dice roll, and organizes players in order.

TERRITORY INIT SCREEN:(Game State: 4)
This screen introduces the tabs, including the main game tab, the map stats tab, and the player stats tab.
Currently only a simple prompt displays part of the state (occupant and number of armies) of each territory on map stats.
Player stats displays each player's Risk Hand.
On the main screen:
Scroll through the drop menu and click on the territory to occupy.  
Selection itself is the event, no buttons needed.
This prints a prompt to the textfield, which territories the player occupies, 
Players can refer to the mapStats tab to choose their next territory.
After all territories are selected, the Armies init screen opens.
Textfield also prompts for invalid choices

ARMIES INIT SCREEN: (Game State: 5)
Choose which territory to add an army to.
Cycle through players until all players are out of armies.
Textfield displays which territory was chosen
And also prompts for invalid choices.
After all armies are placed, the main player turn screen opens.

PLAYER TURN SCREEN: (Game State: 10 )
Each turn begins displaying the options for each player: trade in cards, place armies, declare war, fortify position,pass dice.
Currently there is no order to these actions.  
Player can place armies only in territories they occupy by the same selection method of initializing territories and armies.
Player may start a war only if they have more than 1 army in at least 1 territory.

BATTLE INIT SCREEN: (Game State: 21)
Current player chooses which territories to initiate a battle with.

DICE INIT SCREEN: (Game State: 22)
After valid territories are selected, the attacker and defender choose the number of dice to roll.
options for the number of dice are given based on how many armies occupy the chosen territory.

BATTLE RESULT SCREEN:(Game State: 23)
Prompt displays the winner of the battle(s).
If a player assumes occupation of a territory, they are prompted and the map stats is updtated.
Prompt displays the dice roll(s) of each player for a reference.
The second text field displays the proper number of armies which can be placed.
Buttons are for another attack during the war, or to end the war.
Player cannot attack again if the current player does not occupy any territory with more than army.
Players can attack from multiple territories, into multiple territories, one battle at a time, during the sequence of a war, until they run out of territories with more than one army.
After ending a war, if the player occupied at least 1 new territory, they have the option to draw a card (i.e. draw card button is added)
Upon ending the war, they can pass the dice to the next player.
The prompt updates to notify the next player.
The second text field updates with the proper number of armies which can be placed.

This cycle of player turns continues until there is only one player left in the list. 

TO DO:

RiskGameEngine: save and load games via (gameName + "Data.txt") file (event, calendar, from lab 1? has .ser)

TerritoryInitScreen:
add a method to check for player's territories
add Continent if player has all its territories

BattleInitScreen: 
input validation

DiceInitScreen:
input validation

PlayerTurnScreen:
tradeInCardsButton = valid set/input validation;  display only if valid card set is available
number of additional armies calculation needs to be expanded for risk card sets

TabScreen:
hide view to view only current player's hands
run through battles to debug game

Player:  add fortifyPosition() implementation

RiskGameModel: try to see if methods of model can be used to implement only model as observer

RiskMap:
Map the pixel sets for the center of each territory on the map.
Add a JLabel at each territory to display the number of armies in the color of the player occupying the territory.  









