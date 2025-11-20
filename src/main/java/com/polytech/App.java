package com.polytech;

import com.polytech.tp.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== DÉMONSTRATION DES DESIGN PATTERNS ===\n");
        
        // ========================================================================
        // EXERCICE 1 : PATTERN BUILDER
        // ========================================================================
        System.out.println("--- 1. PATTERN BUILDER ---");
        
        // Création fluide d'un cours avec le Builder
        Cours cours1 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .setSalle("D23")
                .setDate("Lundi 20/11/2024")
                .setHeureDebut("8h00")
                .setEstOptionnel(false)
                .setNiveau("2A")
                .setNecessiteProjecteur(true)
                .build();
        
        System.out.println("Cours créé : " + cours1.getDescription());
        System.out.println("Durée : " + cours1.getDuree() + "h\n");
        
        // ========================================================================
        // EXERCICE 2 : PATTERN DECORATOR
        // ========================================================================
        System.out.println("--- 2. PATTERN DECORATOR ---");
        
        // Cours de base
        ICours coursBase = new CoursBuilder()
                .setMatiere("Assurance Qualité Logiciel")
                .setEnseignant("Mr Omar")
                .setSalle("C15")
                .setDate("Mardi 21/11/2024")
                .setHeureDebut("10h00")
                .build();
        
        System.out.println("Cours de base : " + coursBase.getDescription());
        
        // Ajout de décoration "En ligne"
        ICours coursEnLigne = new CoursEnLigne(coursBase);
        System.out.println("Avec décoration : " + coursEnLigne.getDescription());
        
        // Ajout de décoration "Magistral"
        ICours coursMagistral = new CoursMagistral(coursBase);
        System.out.println("Avec décoration : " + coursMagistral.getDescription());
        
        // Combinaison de plusieurs décorations
        ICours coursEnLigneMagistral = new CoursMagistral(new CoursEnLigne(coursBase));
        System.out.println("Combinaison : " + coursEnLigneMagistral.getDescription());
        System.out.println();
        
        // ========================================================================
        // EXERCICE 3 : PATTERN OBSERVER
        // ========================================================================
        System.out.println("--- 3. PATTERN OBSERVER ---");
        
        // Création du gestionnaire (Subject)
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
        
        // Création des observateurs
        Etudiant etudiant1 = new Etudiant("Alice");
        Etudiant etudiant2 = new Etudiant("Bob");
        Responsable responsable = new Responsable("Dr. Martin");
        
        // Abonnement des observateurs
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(etudiant2);
        gestionnaire.attach(responsable);
        
        System.out.println("\n>> Ajout d'un nouveau cours :");
        gestionnaire.ajouterCours(coursEnLigne);
        
        System.out.println("\n>> Modification d'un cours :");
        gestionnaire.modifierCours(coursEnLigne, "Le cours d'Assurance Qualité est déplacé en salle D23");
        
        System.out.println("\n>> Changement dans l'emploi du temps :");
        gestionnaire.setChangement("Le cours de Lundi 8h00 est annulé");
        
        // Désabonnement d'un observateur
        System.out.println("\n>> Bob se désabonne :");
        gestionnaire.detach(etudiant2);
        
        System.out.println("\n>> Nouveau changement (Bob ne recevra pas la notification) :");
        gestionnaire.setChangement("Changement de salle : C15 -> C16");
        
        // ========================================================================
        // DÉMONSTRATION COMPLÈTE
        // ========================================================================
        System.out.println("\n\n--- DÉMONSTRATION COMPLÈTE ---");
        
        // Création d'un cours complet avec Builder
        ICours coursComplet = new CoursBuilder()
                .setMatiere("Intelligence Artificielle")
                .setEnseignant("Dr. Turing")
                .setSalle("Amphi A")
                .setDate("Mercredi 22/11/2024")
                .setHeureDebut("14h00")
                .setEstOptionnel(true)
                .setNiveau("3A")
                .setNecessiteProjecteur(true)
                .build();
        
        // Ajout de décorations multiples
        ICours coursDecore = new CoursMagistral(new CoursEnLigne(coursComplet));
        
        // Création d'un nouveau gestionnaire avec observateurs
        GestionnaireEmploiDuTemps gestionnaireIA = new GestionnaireEmploiDuTemps();
        gestionnaireIA.attach(new Etudiant("Charlie"));
        gestionnaireIA.attach(new Etudiant("Diana"));
        gestionnaireIA.attach(new Responsable("Prof. Lovelace"));
        
        // Ajout du cours décoré
        System.out.println("\nAjout du cours complet :");
        gestionnaireIA.ajouterCours(coursDecore);
        
        System.out.println("\n=== FIN DE LA DÉMONSTRATION ===");
    }
}