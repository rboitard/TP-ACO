package Model;

public class CommandeEnregistrable {

    private String Contenu;
    private String typeCommande;


    public CommandeEnregistrable() {
        Contenu = "";
        this.typeCommande = "";
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu, String typeCommande) {
        Contenu = contenu;
        this.typeCommande = typeCommande;
    }

    public String getTypeCommande() {
        return typeCommande;
    }


    @Override
    public String toString() {
        return "CommandeEnregistrable{" +
                "Contenu='" + Contenu + '\'' +
                ", typeCommande='" + typeCommande + '\'' +
                '}';
    }
}
