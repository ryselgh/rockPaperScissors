# Morra Cinese
#### Progetto per Byte-Code srl (Milano)
#
---
### Funzione
Il progetto modella il gioco della Morra Cinese.
In fase embrionale il programma aveva come avversario il computer, o più semplicemente veniva fatta una scelta casuale. Dato che non erano state date particolari limitazioni ho deciso di aggiungere anche la possibilità di sfidare un'altro giocatore reale, utilizzando la stessa console. Infine, siccome è un gioco molto rapido (soprattuto se giocato su un calcolatore) l'ho strutturato in 3 round, estendibili dallo sviluppatore, dove chi ha segnato più punti vince.

### Struttura
 Il gioco è suddiviso in quattro classi:
- **Scelta**, che modella una scelta
- **Risultato**, che modella un risultato rispetto al giocatore
- **Giocatore**, che modella un giocatore con il suo punteggio
- **Gioco**, che racchiude tutta la logica di gioco

*Scelta* e *Risultato*, dato che modellano un numero limitato di oggetti e noto a priori, utilizzano un
enum.

Di seguito il diagramma UML che mostra l'interazione fra le classi:
![UML Diagram](http://oi63.tinypic.com/21nk1lg.jpg)

### Testing
Sono stati effettuati test con JUnit, sia di unità che funzionali. Inoltre il codice è stato analizzato tramite Gradle con JaCoCo e SonarQube. I report sono disponibili in *build/reports*, di seguito alcuni screenshot:
![JaCoCo report](http://oi66.tinypic.com/igmafl.jpg)
![SonarQube report](http://oi68.tinypic.com/2ed88kj.jpg)

## Credits 
##### *Saverio Ruggieri*
Tempo medio di lavoro: ~24h
