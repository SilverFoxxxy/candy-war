# CandyWar


Done: Classes
------------------------------------------------------------

TODO: More Classes)/ Singleton


Done: Activities
------------------------------------------------------------

overall: Activity classes to work with different game conditions (such as the fight itself, main menu etc.)

1: MainActivity owns every other one

2: StartActivity contains a "start" button

3: BoardActivity (now "TestBoardActivity" is actually working class)

TODO:

1: More Activities - firstly the big N * N army board, each cell of which contains a single smaller fight



Done: GUI
------------------------------------------------------------

overall: System to draw Elements which can be Buttons / Elements' Map may be changed in Activities

1: drawable Elements' Map provides different layers

2: ImageSource class stores all images needed for drawing

TODO:

1. use Point class instead of separated coords everywhere

2. make all inActivity coords depend on the Activity coords


Done: FightBoard (class Board)
------------------------------------------------------------

overall: here the Fight takes place

1. cells look like chocolate pieces - nice.

TODO:

1. make different types of cells so the units' behaviour depends on

2. make the BoardActivity able to move and change the size of the Board for better expirience
