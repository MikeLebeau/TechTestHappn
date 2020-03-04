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

# Exemples
Étant donné le fichier de données en entrée suivant :

```
@id @lat @lon
id1 -48.6 -37.7
id2 -27.1 8.4
id3 6.6 -6.9
id4 -2.3 38.3
id5 6.8 -6.9
id6 -2.5 38.3
id7 0.1 -0.1
id8 -2.1 38.1
```

> Pour la question "Calculer le nombre de POIs d'une zone" (avec min_lat=
6.5 et min_lon= -7).

Pour l'appel suivant :  
**java com.happn.techtest.Main** --nbpoi '{"min_lat": 6.5, "min_lon": -7}'  
Le résultat (au format json) attendu est le suivant :  
```
{
    "value": 2
}
```
> Pour la question "Trouver les n zones les plus denses" (avec n= 2).

Pour l'appel suivant :  
**java com.happn.techtest.Main** --densest '{"n": 2}'
Le résultat attendu (au format json) est le suivant :
```
[
    {
        "min_lat": -2.5,
        "max_lat": -2,
        "min_lon": 38,
        "max_lon": 38.5
    },
    {
        "min_lat": 6.5,
        "max_lat": 7,
        "min_lon": -7,
        "max_lon": -6.5
    }
]
```

# Avancement

* [x] Initialisation du repo
* [ ] Ecriture des tests
* [ ] Implémentation du code