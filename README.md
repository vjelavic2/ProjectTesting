Implementirani su sljedeći testni slučajevi:
1. BaseTest: Ovaj test slučaj provjerava osnovne funkcionalnosti sustava, poput uspješnog inicijaliziranja i pokretanja preglednika. Nakon toga, test pronalazi element tražilice na Google.com stranici te upisuje traženi tekst u tražilicu. Konačno, provjerava sadrži li prvi rezultat pretraživanja traženi tekst. U slučaju da se element poklapa sa traženim rezultatom, test se smatra uspješnim. Nakon završetka provjere, preglednik se zatvara kako bi se osigurala čistoća okruženja za sljedeće testove.
2. SearchTest: Ovaj test slučaj fokusira se na funkcionalnost pretraživanja unutar aplikacije. Prvo, test otvara preglednik i navigira na stranicu za pretraživanje. Zatim, test upisuje ključnu riječ "punjac" u polje za pretraživanje i pokreće pretragu. Nakon toga, test provjerava je li rezultat pretrage prikazan kao "punjac". U slučaju da se predmet koji je rezultat pretrage poklapa sa očekivanim rezultatom, test se smatra uspješnim. Nakon završetka provjere, preglednik se zatvara kako bi se osigurala čistoća okruženja za sljedeće testove.
3. NavTest: Ovaj test slučaj fokusira se na provjeru navigacijske funkcionalnosti unutar aplikacije. Početno, test otvara preglednik i navigira na početnu stranicu aplikacije. Zatim, test pronalazi navedeni navigacijski element, odnosno "Sport i oprema", te ga aktivira klikom. Zatim provjerava odgovara li rezultat dijelu naziva odabrane navigacijske trake.
4. AddToCartTest: Ovaj test slučaj provjerava funkcionalnost dodavanja proizvoda u košaricu unutar aplikacije. Početno, test otvara preglednik i pretražuje unutar aplikacije koristeći ključnu riječ "punjac". Nakon pronalaska rezultata pretrage, test odabire prvi pronađeni proizvod i dodaje ga u košaricu. Zatim, test provjerava je li cijena odabranog proizvoda u košarici jednaka očekivanoj cijeni. U slučaju da je cijena proizvoda u košarici jednaka traženoj cijeni, test se smatra uspješnim.
5. WishListTest: Ovaj test slučaj provjerava funkcionalnost dodavanja proizvoda na listu želja unutar aplikacije. Početno, test otvara preglednik i pretražuje unutar aplikacije koristeći ključnu riječ "punjac". Nakon pronalaska rezultata pretrage, test odabire prvi pronađeni proizvod i dodaje ga na listu želja. Zatim, test provjerava je li cijena odabranog proizvoda u košarici jednaka očekivanoj cijeni. U slučaju da je cijena proizvoda u košarici jednaka traženoj cijeni, test se smatra uspješnim.

Dodatno: TestNG.xml navode konfiguracije testova.
Korišteni alati: JAVA JDK, IntelliJ IDEA, ChromeDriver, Maven, TestNG.




