README.txt

==============================
   UNM CS523 - HOMEWORK #3
  	 INDEPENDENT PROJECT
           4/27/15
cellularpandemic.wordpress.com
==============================
Brady Key - bradykey@gmail.com (UNMID: bradykey)
Elan Silverblatt-Buser - esilverblatt@gmail.com (UNMID: esilverblatt)

This assignment was written completely in Java. All code was written 
solely by Brady and Elan. No other code outside of the Java STD library was
used.

Rules about the game Pandemic were taken from the Pandemic Board Game 
rule book, which is owned by Z-Man Games.

Data were saved to .txt files and loaded into Plotly (www.plot.ly)
to create the figures used for the website and the presentation.

A flow chart was created using Gliffy.com.

Wordpress.org and its free themes were used for the website. Also, their
free hosting services were used to host the website.

***************************************************************************
This turn-in contains 5 main things:
1: README.txt - this file.
2: GENeticPANdemic.jar - the entire code for the assignment in an 
executable .jar format.
3: /Figures - a folder containing all of the Figures (and movie) described
below.
4. GENeticPANdemicKey-SilverblattPresentation.pdf - the slideshow of our 
presentation.
5. Website.txt - GENetic PANdemic website URL: geneticpandemic.wordpress.com

All code, both .class and .java files, is packaged into the 
GENeticPANdemic.jar. There is a single main(String[]) to be run from the
InfectionSimulator.java class. 

To run the simulator, you have two options: 
The turned in GENeticPANdemic.jar is a fully executable .jar. Meaning, 
you can run it from whichever path it lives by either double-clicking
the .jar if you are in Windows or running the following command from
the command line in linux -- 

>> java -jar GENeticPANdemic.jar

If the simulator is run this way, you will see 18 .txt files be created
in the directory in which the executable .jar was run. These files contain
all of the results and outputs from the simulation using the default 
parameters and the descriptions of each are described below.

========
Figure 1 - For 10 random paths on 10 different games, the total world infection
amount is printed out at each turn.
========
Fig1TotalWorldInfection0.txt
Fig1TotalWorldInfection1.txt
Fig1TotalWorldInfection2.txt
Fig1TotalWorldInfection3.txt
Fig1TotalWorldInfection4.txt
Fig1TotalWorldInfection5.txt
Fig1TotalWorldInfection6.txt
Fig1TotalWorldInfection7.txt
Fig1TotalWorldInfection8.txt
Fig1TotalWorldInfection9.txt

========
Figure 2 - The best fitness value at each generation is printed. The default
parameter allows 8 actions per turn.
========
Fig2BestFitnessPerGen8APT.txt

========
Figure 3 - The average infection level over the entire game of each city 
is printed for both the Key-Silverblatt Path as well as a random path.
========
Fig3AvgInfLvlPerCityKeySilverblattPath.txt
Fig3AvgInfLvlPerCityRandomPath.txt

=====
Movie - The state of the world at each turn, along with the 8 actions of
the player at that turn and the cities which are infected are printed.
=====
Fig4MovieWorldStateNoPlayer.txt
Fig4MovieWorldStateKeySilverblattPath.txt
Fig4MovieWorldStateRandomPath.txt

========
Figure 5 - The distribution of actions at each turn for both the 
Key-Silverblatt path as well as a random path are shown.
========
Fig5ActionDistKeySilverblattPath.txt
Fig5ActionDistRandomPath.txt

++++++++++++++++++

Since the previous option of running the simulation does not allow the 
grader to see the code, I would assume the following will be the method of
choice to run.

1) Open Eclipse and create a new Java Project by clicking "File" > "New"
> "Java Project..."

2) Give the project any name and click "Finish".

3) In the Package Explorer, expand the newly created project, right-click
on the "src" package and select "Import..."

4) Under "General", select "Archive File".

5) Select the GENeticPANdemic.jar in the "From archive file:" input box.

6) Make sure the top-level folder is selected (this is done by default)
and press "Finish".

7) The .java files can now be seen inside the /src/pandemic package.

8) Run the simulation by running the com.pandemic.simulator.InfectionSimulator.java
class.

*Like before, the 18 .txt files will be created after the main() completes.
However, these files will exist in the top-level of the created Java Project.

=================
JAR File Contents
=================

The GENeticPANdemic.jar contains 2 main sub-packages under com.pandemic and
a single DataCollection.java class that handles the output of the data found
by the simulation.

*******************
com.pandemic.cities
*******************
This package contains the designed class hierarchy for the connection of the world
through all of the 48 cities. The abstract City.java class represents a general
city with a "name", "infectionLevel" and list of "neighbors" (other Cities).

Each specific instance of a city extends this City.java abstract class
and hard-codes their neighbor cities. The neighbor cities are defined by how the 
Pandemic board game is set-up.

**********************
com.pandemic.simulator
**********************
This package contains the InfectionSimulator.java class which is the entry point
to the simulation. It also contains a few parent classes that help with the OO 
design used; Path.java, Turn.java, World.java.

SimVars.java is a static class containing all of the final variables used throughout
the simulation.

        ++++++++++++++++++++++++++++++
        com.pandemic.simulator.actions
        ++++++++++++++++++++++++++++++
        This sub-sub-package contains an abstract class Action.java that 
        generically allows for two sub-classes, MoveAction.java and 
        TreatDiseaseAction.java to extend it.

        +++++++++++++++++++++++++
        com.pandemic.simulator.GA
        +++++++++++++++++++++++++
        Simply contains a GAUtility.java class which is just a class containing
        public static utility/helper methods used throughout the simulator.


FOR MORE INFORMATION ABOUT THE CLASSES AND WHAT THEY DO, PLEASE CONSULT THE JAVADOC
AND INLINE COMMENTS.

Please don't hesitate to email either one of us if you have any questions at all.