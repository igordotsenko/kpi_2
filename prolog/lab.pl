% room facts
room(kitchen).
room(office).
room(hall).
room('dinning room').
room(cellar).

% location facts
location(desk, office).
location(apple, kitchen).
location(flashlight, desk).
location('washing machine', cellar).
location(nani, 'washing machine').
location(broccoli, kitchen).
location(crackers, kitchen).
location(computer, office).
location(fridge, kitchen).
location(soup, fridge).
location(potato, soup).

% room connection facts
door(office, hall).
door(kitchen, office).
door(hall, 'dinning room').
door(kitchen, cellar).
door('dinning room', kitchen).

% edible facts
edible(apple).
edible(crackers).
tastes_yacky(broccoli).

% viewer location fact
here(cellar).

% connect all doors
connect(X,Y) :- door(X,Y).
connect(X,Y) :- door(Y,X).

% Exercise 1
% room(office). % true
% room(badroom). %false

% location(apple, cellar). % false
% location(apple, kitchen). % true
% location(potato, soup). % true
% location(potato, kitchen). % false

% Exercise 2
% room(X). % list all rooms
% location(X, kitchen). % list all stuff that is in the kitchen
% location(X, Y). % list all stuff in all rooms

% Exercise 3
% location(X, kitchen), edible(X). % Find edible that is in the kitchen

% Excercise 4
% room(R), door(R, kitchen), location(T, R). % all things in the all rooms next to the kitchen

% Excercise 5
% location(X, kitchen), write(X), write(" is in the kitchen"), nl, fail. % list all items that are in the kitchen

% Excercise 6.1
% where_food(FOOD, ROOM) :- room(ROOM), location(FOOD, ROOM), edible(FOOD). % Write all food in all rooms

% Excercise 6.2
where_food(FOOD, ROOM) :- 
	room(ROOM), location(FOOD, ROOM), edible(FOOD) ; 
	room(ROOM), location(FOOD, ROOM), tastes_yacky(FOOD). % Write all food in all rooms + broccoli

% Excercise 7
list_things(Place) :- room(Place), location(Thing, Place), tab(2), write(Thing), nl, fail. % list all things in the Place
list_things(_).

% Excercise 8
list_connections(Place) :- room(Place), connect(Place, X), tab(2), write(X), nl, fail. % list all connected to the Place rooms
list_connections(_).

% Excercise 9 
look :- 
	here(Place), 
	write("You are in the "), write(Place), nl,
	write("You can see:  "), nl,
	list_things(Place),
	write("You can go to"), nl,
	list_connections(Place).



