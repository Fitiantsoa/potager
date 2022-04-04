package Vgarden.demo.model;

public enum CommandeStatut {
    EN_ATTENTE("En attente"), EN_COURS("En cours"), TERMINE("Terminé");

    private String statut;

    private CommandeStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }
}
