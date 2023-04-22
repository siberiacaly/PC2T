# Projekt
Představte si, že vytváříte program pro správu seznamu filmů. Každý film má název, režiséra, rok
vydání, seznam herců a hodnocení diváků (skládá se z bodového hodnocení a případně slovního
komentáře). Existují dva druhy filmů:
- a) Hrané filmy – tyto filmy mají seznam herců a bodové hodnocení diváků se vyjadřuje pomocí
počtu hvězdiček od 1 do 5.
- b) Animované filmy – tyto filmy mají místo seznamu herců několik animátorů a bodové
hodnocení diváků se vyjadřuje pomocí kladného čísla od 1 do 10. Navíc obsahují
doporučený věk diváka.
# Program
- A) Přidání nového filmu – uživatel vybere druh filmu, zadá název, režiséra, rok vydání a případně
seznam herců nebo animátorů. Pokud jde o animovaný film, uživatel zadá kromě názvu, režiséra a roku
vydání také doporučený věk diváka.
- B) Upravení filmu – uživatel vybere film podle názvu a může provést úpravu názvu, režiséra, roku
vydání, seznamu herců nebo animátorů a v případě animovaných filmů i doporučený věk diváků.
- C) Smazání filmu – uživatel vybere film podle názvu a smaže ho ze seznamu.
- D) Přidání hodnocení danému filmu – bodové hodnocení dle druhu filmu, slovní hodnocení volitelně
- E) Výpis filmů – uživatel může nechat vypsat všechny filmy, přičemž se zobrazí název, režisér, rok vydání
a seznam herců nebo animátorů a v případě animovaného filmu doporučený věk diváků.
- F) Vyhledání filmu – uživatel zadá název filmu a zobrazí se mu informace o něm (název, režisér, rok
vydání, seznam herců nebo animátorů a hodnocení diváků). Přičemž hodnocení diváků bude seřazeno
sestupně dle bodového hodnocení.
- G) Výpis herců nebo animátorů, kteří se podíleli na více než jednom filmu – uživatel dostane seznam
herců nebo animátorů, kteří se podíleli na více než jednom filmu a u každého z nich se zobrazí seznam
filmů, na kterých se podíleli.
- H) Výpis všech filmů, které obsahují konkrétního herce nebo animátora – uživatel zadá jméno herce
nebo animátora a zobrazí se mu seznam filmů, ve kterých hrál nebo na kterých se podílel.
- I) Uložení informace o vybraném filmu (dle jeho názvu) do souboru.
- J) Načtení všech informací o daném filmu ze souboru (soubor obsahuje vždy jeden film)
- K) Při ukončení programu se uloží veškeré informace do SQL databáze.
- L) Při spuštění programu se veškeré informace načtou z SQL databáze.
