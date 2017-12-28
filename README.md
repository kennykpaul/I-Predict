# I-Predict
This is a simple android apk which I created to manage a prediction game played at my office.

Apart from the android apk there are scripts which needs to be run in Google app scripts environment. I have not included these google scripts,
if you want to view those you can ask and I will share.

Game details
============
This is a prediction game based on the the Indian Premier League cricket tournament which is played every year in India. The entire season 
consists of 56 games(C(8,2)) played between 2 teams out of a pool of 8 teams to decide the top 4 teams. The winner is decided from playoffs
among these 4 teams which includes two qualifiers, one eliminator, and one final match.

The participants of our prediction game has to choose the match winner and the man of the match for the game played on a particular day.
Now the collection of the match day's responses of each participant is handled by our android apk which forwards it to a google response sheet.
In addition to this the apk displays the current scorecard and also displays history of all the previous predictions made by all participants in the game(so that others can derive
some pattern from previous successful predictions and take an intelligent choice the next day).

The brain behind the prediction game are the google scripts which keeps track of all the responses sent by the apk. The google scripts
consists of scripts like scoresheet calculator and response sheet updation.

Things I could improve
=====================

* I made a limit to the number of people who can participate but this can be removed in later revisions.
* The winner and man of the match could be automatically pulled from feeds and updated in sheets.




