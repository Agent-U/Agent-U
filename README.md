# Collaborateurs
* Mohamed CHABANE
* Youcef BRAHIMI
* Nassim ARAB

---
# AgentU 
![](https://i.imgur.com/PHCMlWQ.jpg)


___
## Description du projet 

AgentU est une application web qui permet de gérer le contact entre un accueil d'une residence et les residents (gestion de courrier, gestion des rendez vous, gestion des evenements, gestion de la liste des agents et la lsite des étudiants).

___
## Lancement du projet (en local)

1. Récuperer le dépot.
2. Se placer à la racine du projet.
3. Lancer la commande `mvn spring-boot:run`

**[Il faut avoir un acces au serveur webtp de l'université de Lille pour utiliser la BDD. Donc l'utilisation du VPN étudiant est requis pour un accès depuis l'extérieur du campus.]**

___
## Accès (sur Heroku)
- Api : `https://agentu.herokuapp.com/[NomRessource]/`

[NomRessource] = etudiants || agents || incidents || rendezVous || evenements;

___
## Base de données 
Notre base de données est composée de cinq tables





![](https://i.imgur.com/ML2jKs1.png)

---

### Etudiant

* Représente l'ensemble des étudiants ayant un logement dans la résidence. 


| Attribute | Type |Description |
|-----------|------|-------------|
|id         | integer | L'id de l'étudiant. |
|ine         | integer | L'ine de l'étudiant. |
|nom        | string | Le nom de l'étudiant. |
|prenom        | string | Le prénom de l'étudiant. |
|mail        | string | L'adresse mail de l'étudiant. |
|motDePasse        | string | Le mot de passe de l'étudiant.      |
|petiteEnveloppe        | integer  | Nombre de petite enveloppe.            |
|grandeEnveloppe        | integer  | Nombre de grande enveloppe.  |
|avisPassage        | integer  | Nombre d'avis de passage.           |
|colis       | integer  | Nombre de colis.          |
|datePetiteEnveloppe       | date | La date de dernier petite enveloppe réçu. |
|dateGrandeEnveloppe        | date | La date de dernier grande enveloppe réçu.      |
|dateAvisPassage        | date  | La date de dernier avis de passage réçu.            |
|dateColis        | date  | La date de dernier colis réçu.  |
|chambre        | string  | Le bloc avec le numéro de la chambre.           |


### Agent

* Représente l'équipe du staff de la résidence.

| Attribute | Type |Description |
|-----------|------|-------------|
|id         | integer | Un identifient unique.     |
|nom | string | Nom de l'agent. |
|prenom        | String | Prenom de l'agent. |
|rendezVous       | RendezVous [] | liste des rendez-vous proposés par l'agent.  |


### RendezVous

* Représente l'ensemble des rendez-vous proposés par les agents pour les étudiants.

| Attribute | Type |Description |
|-----------|------|-------------|
|id         | integer | Un identifient unique.     |
|motif | string | Motif du rendez-vous. |
|date        | datetime | Date et heure du rendez-vous. |
|disponible       | boolean | Le rendez vous est disponible pour un étudiant ou non.  |
|etudiant        | Etudiant | L'étudiant qui réserve le rendez-vous.|
|agent       | Agent | L'agent qui propose le rendez-vous. |


### Incident

* Représente l'ensemble des incidetns signalés par les étudiants.

| Attribute | Type |Description |
|-----------|------|-------------|
|id         | integer | A unique id.     |
|motif      | string | Motif de l'incident. |
|description| string | Information sur l'incident  |
|date        | datetime | Date de déclaration de l'incidnet|
|lieu       | string | Lieu de l'incident |
|etat       | smallInt | l'état de l'incident |
|etuidant_id| integer | l'étudiant qui a déclaré l'incident |

### Evenement

* Représente l'ensemble des évènements dans le campus.


| Attribute | Type |Description |
|-----------|------|-------------|
|id         | integer | L'id de l'évenement. |
|titre        | string | Le titre l'évenement. |
|image_url        | string | Le lien vers l'image de l'évenement. |
|detail        | string | Détail de l'évenement. |

___
## Les méthodes basique de l'API

## Methode GET

|Endpoint| Description |Parameter | Parameter type | Returned Resource  Type |
|--------|-------------|----------|----------------|-------------------------|
| /etudiants | Récupérer la liste des étudiants. | - | - | Etudiant []        |
| /agents   | Récupérer la liste des agents.   | - | - | Agent []        |
| /agents/isClose/   | Récupérer si l'accueil est fermé.   | - | - | Booléan        |
| /agents/switch/   | Changer l'état puis récupérer si l'accueil est fermé.   | - | - | Booléan        |
| /evenemets     | Récupérer la liste des évenements. | - | - | Evenemet []    |
| /rendezVous | Récupérer la liste des rendez-vous. | - | - | RendezVous [] |
| /incidents | Récupérer la liste des incidents. | - | - | Incident [] |
| /etudiants/{id:int} | Récupérer l'étudiants avec l'id. |id | int | Etudiant|
| /agents/{id:int} | Récupérer l'agent avec l'id.  |id| int| Agent|
| /evenemets/{id:int}      |  Récupérer l'évenement avec l'id. |id| int| Evenemet|
| /rendezVous/{id:int}    | Récupérer le rendez-vous avec l'id.  |id | int | RendezVous |
| /incidents/{id:int}          | Récupérer l'incident' avec l'id.  |id | int | Incident|


## Methode POST

|Endpoint| Description |Parameter | Parameter type | Returned Resource  Type |
|--------|-------------|----------|----------------|-------------------------|
| /etudiants | Ajouter l'étudiant. | etudiant | Etudiant | Etudiant      |
| /agents   | Ajouter l'agent.   | agent | Agent | Agent        |
| /evenemets     | Ajouter l'évenement. | evenemet | Evenemet | Evenemet    |
| /rendezVous | Ajouter le rendezVous. | rendezVous | RendezVous | RendezVous |
| /incidents | Ajouter l'incident. | incident | Incident | Incident |

## Methode PUT

|Endpoint| Description |Parameter | Parameter type | Returned Resource  Type |
|--------|-------------|----------|----------------|-------------------------|
| /etudiants/{id:int} | Modifier l'étudiant. | etudiant | Etudiant | Etudiant      |
| /agents/{id:int}   | Modifier l'agent.   | agent | Agent | Agent        |
| /evenemets/{id:int}     | Modifier l'évenement. | evenemet | Evenemet | Evenemet    |
| /rendezVous/{id:int} | Modifier le rendezVous. | rendezVous | RendezVous | RendezVous |
| /incidents/{id:int} | Modifier l'incident. | incident | Incident | Incident |

## Methode Delete

|Endpoint| Description |Parameter | Parameter type | Returned Resource  Type |
|--------|-------------|----------|----------------|-------------------------|
| /etudiants/{id:int} | Supprimer l'étudiant avec l'id. | etudiant | Etudiant | -      |
| /agents/{id:int}   | Supprimer l'agent avec l'id.   | agent | Agent |    -        |
| /evenemets/{id:int}     | Supprimer l'évenement avec l'id. | evenemet | Evenemet | -    |
| /rendezVous/{id:int} | Supprimer le rendezVous avec l'id. | rendezVous | RendezVous | - |
| /incidents/{id:int} | Supprimer l'incident avec l'id. | incident | Incident | - |

___


### Exemple de réponse Methode `GET /agents/` : 

```
[
  {
    "id": 4,
    "nom": "Mohamed",
    "prenom": "chabane",
    "rendezVous": [
      {
        "id": 4,
        "date": "2021-02-19T01:00:00.000+00:00",
        "motif": "changement de chambre",
        "disponible": false,
        "etudiant": {
          "ine": "qsfds",
          "nom": "brhm",
          "prenom": "Youcef",
          "mail": "NC@gmail.com",
          "motDePasse": "Norris-Chuck-qsfds",
          "petiteEnveloppe": 0,
          "grandeEnveloppe": 0,
          "avisPassage": 0,
          "colis": 0,
          "datePetiteEnveloppe": "2021-02-16T10:59:19.011+00:00",
          "dateGrandeEnveloppe": "2021-02-16T10:59:19.011+00:00",
          "dateAvisPassage": "2021-02-16T10:59:19.011+00:00",
          "dateColis": "2021-02-16T10:59:19.011+00:00",
          "chambre": "X001",
          "incidents": [
            {
              "id": 0,
              "date": "2021-02-16T00:00:00.000+00:00",
              "motif": "[URGENT] Fuite d'eau dans la cuisine collective",
              "lieu": "batiment U",
              "description": "tryteetry",
              "imageUrl": "logo.png",
              "etat": 1
            }
          ]
        }
      }
    ]
  },
  {
    "id": 5,
    "nom": "ARAB",
    "prenom": "Nassim",
    "rendezVous": []
  }
]
```

### Exemple de réponse Methode `GET /agents/isClose/` : 

```
{
  "close": true
}
```

### Exemple de réponse Methode `GET /agents/switch/` : 

```
{
  "close": false
}

```

### Exemple de réponse Methode `GET /etudiants/` : 

```
[
  {
    "ine": "1123956",
    "nom": "Mohamed",
    "prenom": "Bouchouch",
    "mail": "mb@yahoo.fr",
    "motDePasse": "Mohamed-Bouchouch-1123956",
    "petiteEnveloppe": 0,
    "grandeEnveloppe": 2,
    "avisPassage": 0,
    "colis": 0,
    "datePetiteEnveloppe": null,
    "dateGrandeEnveloppe": "2021-02-09T09:14:36.169+00:00",
    "dateAvisPassage": null,
    "dateColis": null,
    "chambre": "R006",
    "incidents": [],
    "rendezVous": []
  },
  {
    "ine": "1195367",
    "nom": "julien",
    "prenom": "dupont",
    "mail": "jd@gmail.com",
    "motDePasse": "julien-dupont-1195367",
    "petiteEnveloppe": 2,
    "grandeEnveloppe": 0,
    "avisPassage": 1,
    "colis": 0,
    "datePetiteEnveloppe": "2021-02-09T09:14:37.301+00:00",
    "dateGrandeEnveloppe": null,
    "dateAvisPassage": "2021-02-09T09:14:37.301+00:00",
    "dateColis": null,
    "chambre": "B013",
    "incidents": [],
    "rendezVous": []
  },
  {
    "ine": "464",
    "nom": "arab",
    "prenom": "nassim",
    "mail": "mm@gmail.com",
    "motDePasse": "arab-nassim-464",
    "petiteEnveloppe": 0,
    "grandeEnveloppe": 0,
    "avisPassage": 0,
    "colis": 0,
    "datePetiteEnveloppe": null,
    "dateGrandeEnveloppe": null,
    "dateAvisPassage": null,
    "dateColis": null,
    "chambre": "fsdgsfd",
    "incidents": [],
    "rendezVous": []
  },
  {
    "ine": "254",
    "nom": "nn",
    "prenom": "pp",
    "mail": "fgds",
    "motDePasse": "nn-pp-254",
    "petiteEnveloppe": 0,
    "grandeEnveloppe": 0,
    "avisPassage": 0,
    "colis": 0,
    "datePetiteEnveloppe": null,
    "dateGrandeEnveloppe": null,
    "dateAvisPassage": null,
    "dateColis": null,
    "chambre": "6",
    "incidents": [],
    "rendezVous": []
  },
  {
    "ine": "qsfds",
    "nom": "brhm",
    "prenom": "Youcef",
    "mail": "NC@gmail.com",
    "motDePasse": "Norris-Chuck-qsfds",
    "petiteEnveloppe": 0,
    "grandeEnveloppe": 0,
    "avisPassage": 0,
    "colis": 0,
    "datePetiteEnveloppe": "2021-02-16T10:59:19.011+00:00",
    "dateGrandeEnveloppe": "2021-02-16T10:59:19.011+00:00",
    "dateAvisPassage": "2021-02-16T10:59:19.011+00:00",
    "dateColis": "2021-02-16T10:59:19.011+00:00",
    "chambre": "X001",
    "incidents": [
      {
        "id": 0,
        "date": "2021-02-16T00:00:00.000+00:00",
        "motif": "[URGENT] Fuite d'eau dans la cuisine collective",
        "lieu": "batiment U",
        "description": "tryteetry",
        "imageUrl": "logo.png",
        "etat": 1
      }
    ],
    "rendezVous": [
      {
        "id": 4,
        "date": "2021-02-19T01:00:00.000+00:00",
        "motif": "changement de chambre",
        "disponible": false,
        "agent": {
          "id": 4,
          "nom": "Mohamed",
          "prenom": "chabane"
        }
      }
    ]
  }
]
```


### Exemple de réponse Methode `GET /incidents/` : 

```
[
  {
    "id": 0,
    "date": "2021-02-16T00:00:00.000+00:00",
    "motif": "[URGENT] Fuite d'eau dans la cuisine collective",
    "lieu": "batiment U",
    "description": "tryteetry",
    "imageUrl": "logo.png",
    "etat": 1,
    "etudiant": {
      "ine": "qsfds",
      "nom": "brhm",
      "prenom": "Youcef",
      "mail": "NC@gmail.com",
      "motDePasse": "Norris-Chuck-qsfds",
      "petiteEnveloppe": 0,
      "grandeEnveloppe": 0,
      "avisPassage": 0,
      "colis": 0,
      "datePetiteEnveloppe": "2021-02-16T10:59:19.011+00:00",
      "dateGrandeEnveloppe": "2021-02-16T10:59:19.011+00:00",
      "dateAvisPassage": "2021-02-16T10:59:19.011+00:00",
      "dateColis": "2021-02-16T10:59:19.011+00:00",
      "chambre": "X001",
      "rendezVous": [
        {
          "id": 4,
          "date": "2021-02-19T01:00:00.000+00:00",
          "motif": "changement de chambre",
          "disponible": false,
          "agent": {
            "id": 4,
            "nom": "Mohamed",
            "prenom": "chabane"
          }
        }
      ]
    }
  }
]
```


### Exemple de réponse Methode `GET /rendezVous/` : 

```
[
  {
    "id": 4,
    "date": "2021-02-19T01:00:00.000+00:00",
    "motif": "changement de chambre",
    "disponible": false,
    "agent": {
      "id": 4,
      "nom": "Mohamed",
      "prenom": "chabane"
    },
    "etudiant": {
      "ine": "qsfds",
      "nom": "brhm",
      "prenom": "Youcef",
      "mail": "NC@gmail.com",
      "motDePasse": "Norris-Chuck-qsfds",
      "petiteEnveloppe": 0,
      "grandeEnveloppe": 0,
      "avisPassage": 0,
      "colis": 0,
      "datePetiteEnveloppe": "2021-02-16T10:59:19.011+00:00",
      "dateGrandeEnveloppe": "2021-02-16T10:59:19.011+00:00",
      "dateAvisPassage": "2021-02-16T10:59:19.011+00:00",
      "dateColis": "2021-02-16T10:59:19.011+00:00",
      "chambre": "X001",
      "incidents": [
        {
          "id": 0,
          "date": "2021-02-16T00:00:00.000+00:00",
          "motif": "[URGENT] Fuite d'eau dans la cuisine collective",
          "lieu": "batiment U",
          "description": "tryteetry",
          "imageUrl": "logo.png",
          "etat": 1
        }
      ]
    }
  }
]
```


### Exemple de réponse Methode `GET /evenement/` : 

```
[
  {
    "id": 1,
    "titre": "Repas à 1 euro dans tous les RU !",
    "image_url": "logo.png",
    "detail": "Les RU proposent des repas à 1 euro pour tous les etudiants (boursiers et non boursiers)"
  },
  {
    "id": 3,
    "titre": "saint valentin",
    "image_url": "logo.png",
    "detail": ""
  }
]
```
