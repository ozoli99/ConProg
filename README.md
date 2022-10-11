# ConProg
Konkurrens programozás egyetemi tárgy egyszerű feladatai.

## Basics
### 1. Egyszerű Java osztály
Készíts egy osztályt Employee néven. Az Employee osztálynak két privát adattagja van, name (név) és salary (fizetés)! 
Készíts az osztályhoz nyilvános konstruktort, ami inicializálja ezt a két mezőt! Ezen kívül készíts lekérdező metódust mindkét mezőhöz, 
valamint egy olyan metódust, amely a fizetést egy adott százalékkal megemeli (paraméterként átadott lebegőpontos érték)!

Ehhez a feladathoz és a következőkhöz is készíts egy main függvénnyel rendelkező tesztelő osztályt! Fordítsd le és futtasd a kódot!

### 2. Absztrakt osztály és öröklődés
Tedd az Employee osztályt absztrakttá! Készíts két osztály, amely belőle származik le Manager és Subordinate (beosztott) néven! 
Tedd az Employee osztály salary mezőjének lekérdező metódusát absztrakttá, az eredeti működést meg tedd át egy ezt felülíró metódusba a Subordinate osztályban! 
A Manager osztály tároljon egy listát, amelyben Employee típusú elemek szerepelnek. 
Készíts metódusokat a Manager osztályba, amelyek Employee példányokat adnak hozzá illetve törölnek! 
Írd felül a getSalary() metódust a Manager osztályban is olyan módon, hogy a saját fizetéséhez adja hozzá a listájában szerplő összes Employee fizetésének 5%-át, 
és ezt az értéket adja vissza!

### 3. Interfész
Készíts egy interfészt SalariedEntity néven, amelynek egyetlen getSalary() metódusa van! 
Módosítsd az Employee osztályt, hogy megvalósítsa ezt az interfészt! 
Ezen kívül készíts egy az interfészt szintén megvalósító Subcontractor (alvállalkozó) osztályt is! 
Az alvállalkozóknak a nevük helyett az adószámát (long) tároljuk.

## ThreadBasics
### 1. Első szálak
Készíts egy programot, amely elindít két szálat: az egyik a 1, 2, 3, ... sorozatot írja ki a szabványos kimenetre, a másik pedig a -1, -2, -3, ... sorozatot

- Mindkét szál 100000 (százezer) lépést tegyen meg!
- Figyeld meg, hogy a két szál kimenete hogyan keveredik!

### 2. Szövegíró szál
Van egy tömbünk, ami különböző karakterláncokat tartalmaz. Készíts programot, amelyik mindegyik szöveggel indít egy szálat! 
Mindegyik szál a 1, 2, ... szövegeket írja ki a képernyőre!

### 3. Lassú szövegírás
Készíts egy fakePrintln metódust, amely átvegy egy karakterláncot és kiírja a szabványos kimenetre. 
A kiírás karakterenként történjen, a végére pedig egy újsor karakter kerüljön!

- Alakítsd át az előző programodat, hogy a fakePrintln segítségével írjon ki!
- Figyeld meg, hogy mennyiben különbözik a futása a korábbi változatétől!

## ThreadsAndSynchronization
### 1. Időzített várakozás
Indíts egy szálat, ami pozitív egészeket ír a kimenetre, mindegyik között pihen egy kicsit.

- A szál végigfutását a main szál várja meg és írja ki, ha ez megtörtént és azt is, hogy mennyi idő telt el összesen.
- A szál futása közben bizonyos időközönként a main szál írja ki, hogy a művelet még folyamatban és azt is, hogy mennyi idő telt el eddig.

### 2. Várakozás flag értékre
Indíts egy szálat, ami pozitív egészeket ír a kimenetre, mindegyik között pihen egy kicsit. 
Végül állítson át egy változóértéket (flag-et), amit a main szálból fogunk figyelni.

- A main szál explicit join helyett periodikusan ellenőrizze a flag-et, az ellenőrzések közben pihenjen meg egy kicsit. Ha a flag átbillent, írja ki, hogy vége.
- A megvalósítás legyen szálbiztos!

### 3. Szálbiztos számlálás
Indíts előre megadható számú szálat. Ezek mindegyike egyetlen közös long típusú változó értékét fogja növelni. Mindegyik szál ugyanannyiszor növeli 1-el az értéket.

- A fő szál várja be az összes szálat és írja ki, hogy mennyi lett a végső érték!
- A megvalósítás legyen szálbiztos!

## CollectionSynchronization
### 1. Unexpected exception
Demonstráld, hogy milyen hibalehetőséget okozhat, ha két szál párhuzamosan módosít egy listát! Utána javítsd meg.
Demonstráld, hogy milyen hibalehetőséget okozhat, ha egy listán iterálás közben egy párhuzamos szál módosítja a listát! Utána javítsd meg.

### 2. Szálbiztos verem
Készíts egy egyszerű verem implementációt. Írj többszálú kódot, amivel demonstrálható, hogy megsérthetők a típusinvariánsok párhuzamos műveletekkel! 
Végül tedd szálbiztossá a vermet és futtasd újra a "tesztet"!
