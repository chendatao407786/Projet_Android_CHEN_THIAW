# Projet_Android_CHEN_THIAW

Ce projet est réalisé dans le cadre de notre master 2 MBDS. 

Notre application gère les fonctionnalité suivantes:
  - Connexion / Inscription avec SQLite
  - Ajout de contact avec SQLite
  - Services REST demandé par le professeur à savoir:
      - Connexion au serveur baobab.tokidev.fr
      - Creation d'un nouvel user sur ce serveur
      - Envoyer un message à des contacts
      - FetchMessages consistant a recupérer et afficher les messages venant de serveur
      - Validate qui consiste a vérifier la validité du token de connexion et dans le cas contraire prendre le refresh token
  - Génération des clés RSA public/privées via KeyStore
  - Cryptage et décryptage de nos messages
  - Utilisation des sharedPreferences afin de sauvegarder nos données (token, RSA_Public/RSA_Private) ainsi que ceux de nos contacts (clés publics)
