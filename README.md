## Mobilno naročanje


Implementirajte aplikacijo za mobilno naročanje kave, ki bo poskrbela, da ne boste na poti na faks
nikoli več v vrsti čakali na vaše jutranje poživilo. Aplikacija naj uporabnikom omogoča naročilo kave v
poljubni kavarni ob poti. Mobilna aplikacija bo nato s pomočjo lokalizacijskih storitev nekaj minut
pred prihodom v kavarno oddala naročilo, tako da bo kava do vašega prihoda pripravljena. Uporabnik
naj ima možnost naročilo plačati z mobilno aplikacijo ali ob prevzemu.


Predlagane entitete:
+ Uporabnik
    + Ime
    + Priimek
    + Uporabniško ime
    + E-mail
    + Lokacija
+ Napitek
    + Vrsta
    + Velikost
    + Čas priprave
+ Kavarna
    + Naziv
    + Lokacija
+ Naročilo
    + Seznam izdelkov
    + Skupen čas priprave
    + Status naročila
    + Status plačila


**Fizični podatkovni model ustvarite v podatkovni bazi PostgreSQL, pri čemer uporabite orodje
pgAdmin4, ki je nameščeno v virtualnem stroju. Število tabel, ki jih boste uporabljali, naj bo med 4
in 6, med njimi pa naj bodo smiselne relacije.**   
Pri zasnovi podatkovnega modela upoštevajte tudi, ali se lahko podatki v prihodnosti spremenijo ali
ne. Primer: sprememba naslova stranke ne sme vplivati na zapis naročniške pogodbe.
