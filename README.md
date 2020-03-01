# Test technique **HAPPN**

- Commencé le 01/03/2020

# Exercice
À partir d'un fichier d'entrée fourni (fichier au format TSV contenant des points
d'intérêts (POIs) caractérisés par: id, lat, lon), on veut calculer le nombre de
POIs d'une zone et trouver les N zones les plus denses (ie. les zones contenant
le plus de POIs).

Pour simplifier l'exercice, on considèrera que le monde est une grille allant de
**-90 a 90** et de **-180 a 180** par incréments de **0,5**. Une zone est donc une case
de la grille. Par exemple: Paris est dans la zone [(49, 2), (48.5, 2.5)].
Intégrer ce code dans un CLI (command line interface). En bonus, vous pourrez
intégrer ce code dans un web-service (REST). La rédaction de test unitaires est
plus que vivement encouragée.

# Avancement

* [ ] Initialisation du repo
* [ ] Ecriture des tests
* [ ] Implémentation du code