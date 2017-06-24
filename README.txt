Author: 
Christian Agbayani Serrano

How to set up Dig Dug:
1. Get the java files and put them into an empty Android Studio project.
2. Add the icons to the game by using the "New -> Image Asset" option on the drawable folder in project view. Name each icon with the name
   it comes with (Ex: If you're adding digdug.png as the image asset, name the image asset "digdug" and make sure it's a launcher icon).
3. Change the name of the package on each java file to match your own package name.
4. Run the app to start the game.

How to play Dig Dug:
-You need to click on something for the characters to move on the screen.
-Move Dig Dug by pressing the direction you want to move in on the directional pad at the bottom left corner of the screen.
-To wait in place, click anywhere on the screen that isn't on the directional pad or the red button.
-Inflate monsters in front of Dig Dug by pressing the red button at the bottom right corner of the screen. Monsters inflate in 4 stages before exploding, so you need to press the red button multiple times in a relatively quick succession to effectively inflate monsters.
-Rocks fall immediately after Dig Dug moves out of the way after the dirt from underneath them is dug out, killing any characters beneath them.
-Dig Dug, monsters, and rocks move at the same speed at 1 square per click.
-Fire and Dig Dug's inflator appear instantly, but fire is effective for 2 spaces while the inflator is effective for 3 spaces. 
-Monsters can be killed either by inflation or falling rocks.
-Dig Dug can be killed either by contact with a monster, being burned by the dragon, or falling rocks.
-The dragon breathes fire occasionally at set intervals.

Disclaimers:
-The program isn't truly multithreaded since user input is required even when the user doesn't move or inflate with Dig Dug.
-The program lacks real-time animation so that the user can move or inflate with more precision.
-The icons for the characters in the game don't rotate or flip to show changes in direction, but their methods are dependent on the direction last moved in.
-The use of the inflator may rarely cause the application to terminate.
-Rocks won't break upon landing, so they can be reused.
-DigDug is removed from the screen to indicate his death, but the player can still move Dig Dug again and cause him to reappear.
-Normal monsters can't be inflated properly, as they treat Dig Dug's inflator as an obstacle, but the dragon inflates properly.
-The game can't be officially beaten even if all monsters are dead, and you can't officially lose if Dig Dug is killed.
-Monsters occassionally ignore Dig Dug's inflator.
