package Vgarden.demo.model;

public class Views {

    public static class Common {}

    // Commande views
    public static class CommandeWithCommandeProduits extends Common {}
    
    public static class CommandeWithUtilisateur extends Common {}
    
    public static class TerrainWithPlantes extends Common{}
    
    public static class UtilisateurWithTerrains extends Common{}
    
    
    
    public static class Plantes extends Common{}
        
    	public static class PlantesWithTerrain extends Plantes{}
    
    public static class Terrain extends Common{}
    
    	public static class TerrainWithUtilisateur extends Terrain{}
}
