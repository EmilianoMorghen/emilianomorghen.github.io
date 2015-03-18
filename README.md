Museo 2.0
=====================

## Fase iniziale
Questo è il repo "master", non dovrà essere toccato direttamente ma solo tramite pull request che dovranno essere revisionate di volta in volta per evitare conflitti o problemi vari.

1. Forkate il progetto sul vostro profilo
2. Una volta forkato clonatelo sul vostro computer tramite il client che avete o `git clone <vostroprofilo>/<nomerepo>`
3. Entrate all'interno della cartella appena scaricata ed aggiungete un indirizzo remoto che chiameremo `upstream` che punterà al repo master; verrà usato per tenere aggiornato il vostro fork senza dover riforkare ogni volta. Da shell il comando è `git remote add upstream git@github.com:HyperionStyle/gestionaleImmobiliare.git`. In questo modo se dovrete aggiornare il repo dal vostro account basterà un `git pull origin master` se invece vorrete aggiornare il vostro fork dal repo principale vi basterà digitare `git pull upstream master` e il vostro repo sarà aggiornato all'ultima versione stable del progetto principale. (Per ulteriori info https://help.github.com/articles/configuring-a-remote-for-a-fork/)
4. Ogni volta che farete una nuova feature/sezione create un branch con un nome significativo.
5. Una volta completata, **testata**, etc. fate una pull request verso il repo originale.
6. Dopo di ciò aspettate che tutti i membri del team abbiano revisionato ed approvato tale pull request -nel frattempo continuate a lavorare ad altro, ricominciando- che verrà mergiata nel branch master da un utente che si occuperà di provvedere di togliere i possibili conflitti senza rompere nulla, tipo Me o Marco.

## Milestone
Dobbiamo decidere come dividere le varie fasi del progetto creando delle Milestone dello stesso, cioè la milestone della V.01, la milestone della V.02, etc. così da poter smistare le issues, le idee e le varie to-do in base alla milestone su cui stiamo lavorando. (Esempio: >Hey ragazzi, ma perché non mettiamo un cubo in home che gira? >Questa si può fare ma dopo, non è essenziale. >Ah ok la metto nella milestone V.03)

## Issues
Per ogni cazzata aprite Issues a palate mettendo le giuste label -così da poterle catalogare- e se è necessario assegnandola a qualche milestone e se è ancora più specifica a qualche utente. Le issues si trovano unicamente nel progetto originale e non nei vostri fork -altrimenti sai che casino-.

## Wiki
C'è la possibilità di stilare una documentazione direttamente su github per "spiegare" le nuove aggiunte agli altri membri del team. Questa cosa è una parte "ESSENZIALE" del progetto per poterci capire tutti senza TS e per poter lavorare in maniera decentralizzata. Lo so che è una rottura di palle ma va fatta, ad ogni roba aggiunta -mergiata nel repo originale- va scritta una paginetta di wiki con tutte le informazioni utili. Screenshot, spiegazioni, parametri, etc.

#CONTRIBUIRE
Leggetevi il file "CONTRIBUTING.md" lì sono scritte altre cose.

## Boh
Se avete domande o volete chiarimenti non c'è bisogno manco di dirlo: aprite una issues così chiariamo i dubbi a tutti :D
