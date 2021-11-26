Curtis Klomegan  
Arthur Lalande-Marchand  

# Rapport TP2 : Des Servlets à la notion de service Web

#### Ressource: https://github.com/barais/JaxRSOpenAPI
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;https://hackmd.diverse-team.fr/s/rJKt4lSND#TPs

## Remarque

Pour récupérer le travail effectué par notre binôme, vous pouvez télécharger le projet sur la branche `main` sur le github: https://github.com/ArthurLM35/JaxRSOpenAPI
Pour la réalisation et les tests du tp, votre machine devra avoir à disposition une base de données HSQLDB. De plus, pour ne pas qu'un utilisateur externe rencontre des complications pendant l'import de notre projet, nous avons décidé d'utiliser Maven.
  
## Compte-rendu

Pour rappel, le but du TP était la réalisation d'une application pour la prise de rendez-vous entre un client et un professionnel.  
Pour cela, nous avons décider d'avoir trois entités pour représenter cette action. Notre première entité, *User*, représente la création d'un utilisateur. Elle possède plusieurs atributs: l'attribut *id*, clef primaire de notre entité, l'attribut *name*, l'attribut *mail* puis l'attribut *mdp*. La deuxième entité nommée *Worker*. Elle hérite de la classe User. Elle permet de différencier si un utilisateur est un client ou un professionnel. Pour cela, elle possède un attribut *job* qui fait réference à son travail. Notre dernière entité correspond à un rendez-vous. Elle s'apelle *Appointment*. Grâce à ses 5 attributs: l'attribut *id*, clef primaire de notre classe, l'attribut *date*, l'attibut *lenght*, l'attribut *us* qui correponds à un User (notre client), l'attribut *work* qui corresponds à un Worker (notre professionnel) puis un attribut *description*. Les getters et les setters ont été généré.   
Il faut maitenant définir les methodes HTTP pour notre projet. Pour rappel, ces méthodes sont *GET*, *POST*, *PUT*, *PATCH*, *DELETE*, etc.  
Nos méthodes sont définies dans les classes suivantes : AppointmentResource, UserResource et WorkerResource. Des méthodes sont identiques aux trois, par exemple, pour les GET, nous avons la fonction *getAll()* qui permet d'afficher tout les elements d'une entité. Nous avons la recherche unique grâce à l'ID ou le travail avec *getAppointmentById*, *getWorkerById*, *getWorkerByJob* ou *getUserById*. Nous avons la possibilité de lister les rendez-vous par Id ou par nom avec *getlistId* et *getlistName*.  
Passons au POST avec la fonction pour ajouter un nouveau element *addRDV*, *addUser* ou *addWorker* où les deux dernieres verifient que l'adresse mail ne soit pas deja dans notre base de données pour effectuer l'inscription d'un nouveau utilisateur. 
Pour finir, nous avons les DELETE avec la possibilité de supprimer soit un element d'une entité ou toute les données d'une entité avec les fonctions *deleteAppointment*, *deleteUser* et *deleteWorker* ou *deleteAll*.

### Test pour notre TP

#### &nbsp;&nbsp;&nbsp;&nbsp; Tester notre base de donnée

Tout d'abord, il faut lancer notre application. Pour ce faire, aller dans le fichier de votre projet. Deux fichiers sont à executer pour que votre base de donnée soit active: `run-hsqldb-server` puis `show-hsqldb`. Pour un utilisateur windows, il faut executer les fichiers de type .bat alors que pour linux les .sh. Après avoir finir la tâche précedente, un menu de lancement se lance. Il faut changer le type en sélectionnant `HSQL Database Engine Server`.  
Notre classe *JpaTest* permet de fournir une base de données simple mais assez complète pour pouvoir faire des requètes. Dans le menu déroulant *command*, vous avez à disposition la liste des commandes à appliquer sur notre base. Le cadre en haut permet d'écrire nos requêtes. Après l'avoir écrit, cliqué sur *execute* pour qu'elle soit afficher dans notre database.

#### &nbsp;&nbsp;&nbsp;&nbsp; Tester sur notre localhost

Pour afficher notre base de donnée sur localhost, il faut tout d'abord que HSQLDB soit lancé. Puis sur eclipse, lancer le `run as` de votre classe *RestServer.java*. Vous pouvez maintenant ouvrir sur votre navigateur le lien de votre local host [http://localhost:8080/](http://localhost:8080/) en ajoutant après la barre oblique les informations necessaire cité dans la partie *compte-rendu*. Par exemple: http://localhost:8080/user/1 qui afficher la personne (user) qui a pour id 1.  
Cependant, seul les fonctions de type GET peuvent être appliquer sur notre localhost. Si vous voulez executer des requetes de type differents, vous pouvez utiliser *Postman*. L'application de requete est cependant differentes que pour GET. Il faut aussi écrire la requete que nous voulons executer, par exemple avec localhost:8080/user/add, puis ajouter nos elements dans le body: `{"id":null,"name":"Pierre Paul","mail":"arthur.lalande@wanadoo.fr","mdp":"adfgvd"}`. Tout les elements a mettre dans le body sont en commentaire dans notre code.

Voici des exemples pour GET:  
  
&nbsp;&nbsp;&nbsp;&nbsp;[http://localhost:8080/user/1](http://localhost:8080/user/1)  
&nbsp;&nbsp;&nbsp;&nbsp;[http://localhost:8080/user/all](http://localhost:8080/user/all)  
&nbsp;&nbsp;&nbsp;&nbsp;[http://localhost:8080/worker/all](http://localhost:8080/worker/all)  
&nbsp;&nbsp;&nbsp;&nbsp;[http://localhost:8080/appointment/all](http://localhost:8080/)  
&nbsp;&nbsp;&nbsp;&nbsp;[http://localhost:8080/appointment/listIdName/Curtis%20Klomegan](http://localhost:8080/appointment/listIdName/Curtis%20Klomegan)  

## Conclusion
