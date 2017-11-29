package moteurEdition;

public class MoteurEditionImplementation implements MoteurEdition {

    private Buffer buffer;
    private PressePapier pressePapier;
    private Selection selection;

    public MoteurEditionImplementation(){
        this.buffer = new Buffer();
        this.pressePapier = new PressePapier();
        this.selection = new Selection();
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public PressePapier getPressePapier() {
        return pressePapier;
    }

    public Selection getSelection() {
        return selection;
    }

    /**
     * Implementation  of couper command
     */
    @Override
    public void couper() {

        if(selection.getFinSelection()!= selection.getDebutSelection())
        {
            int debut, fin;
            String texte = this.buffer.getZoneTexte();
            String chaine1, chaine2;
            if(this.selection.getDebutSelection() < this.selection.getFinSelection())
            {

                debut = this.selection.getDebutSelection();
                fin = this.selection.getFinSelection();
                chaine1 = texte.substring(0, debut);
                chaine2 = texte.substring(fin, texte.length());
                this.buffer.setZoneTexte(chaine1+chaine2);
                this.buffer.setCurseur(Math.abs(debut-fin));

            }
            else {
                fin = this.selection.getDebutSelection();
                debut = this.selection.getFinSelection();
                chaine1 = texte.substring(0, debut);
                chaine2 = texte.substring(fin, texte.length());
                this.buffer.setZoneTexte(chaine1+chaine2);
                this.buffer.setCurseur(Math.abs(debut-fin));
            }
            this.pressePapier.copier(texte.substring(debut,fin));
        }
    }

    /**
     * Implementation  of copier command
     */
    @Override
    public void copier() {
        if(selection.getFinSelection()!= selection.getDebutSelection())
        {
            int debut, fin;
            String texte = this.buffer.getZoneTexte();
            if(this.selection.getDebutSelection() < this.selection.getFinSelection())
            {
                debut = this.selection.getDebutSelection();
                fin = this.selection.getFinSelection();
                this.buffer.setCurseur(fin);
            }
            else {
                fin = this.selection.getDebutSelection();
                debut = this.selection.getFinSelection();
                this.buffer.setCurseur(fin);
            }
            this.pressePapier.copier(texte.substring(debut,fin));
        }
    }

    /**
     * Implementation  of coller command
     */
    @Override
    public void coller() {
        int curseurIntermediaire;
        String texteIntermediaire = this.buffer.getZoneTexte().substring(0,this.buffer.getCurseur());
        texteIntermediaire = texteIntermediaire.concat(this.pressePapier.coller()) ;
        curseurIntermediaire = texteIntermediaire.length();
        texteIntermediaire = texteIntermediaire.concat(this.buffer.getZoneTexte().substring(this.buffer.getCurseur(),this.buffer.getZoneTexte().length()));
        this.buffer.setZoneTexte(texteIntermediaire);
        this.buffer.setCurseur(curseurIntermediaire);

    }

    /**
     * Implementation  of InserterTexte command
     */
    @Override
    public void insererTexte(String text) {

        String texteIntermediaire = this.buffer.getZoneTexte().substring(0,this.buffer.getCurseur());
        int curseurIntermediaire;
        texteIntermediaire = texteIntermediaire.concat(text) ;
        curseurIntermediaire = texteIntermediaire.length();
        texteIntermediaire += this.buffer.getZoneTexte().substring(this.buffer.getCurseur(),this.buffer.getZoneTexte().length());
        this.buffer.setZoneTexte(texteIntermediaire);
        this.buffer.setCurseur(curseurIntermediaire);
    }

    /**
     * Implementation  of selectionnerTexte command
     */
    @Override
    public void selectionnerTexte(int debutStelection, int finSelection) {

        this.selection = new Selection();
        this.selection.setDebutSelection(debutStelection);
        this.selection.setFinSelection(finSelection);
        this.buffer.setCurseur(finSelection);
    }

    /**
     * Implementation  of effacer command
     */
    @Override
    public void effacer() {

        int curseur = this.buffer.getCurseur();
        if(curseur > 0)
        {
            String texteIntermediaire = this.buffer.getZoneTexte().substring(0,this.buffer.getCurseur());
            int curseurIntermediaire;
            texteIntermediaire = texteIntermediaire.substring(0, texteIntermediaire.length()-1);
            curseurIntermediaire = texteIntermediaire.length();
            texteIntermediaire = texteIntermediaire.concat(this.buffer.getZoneTexte().substring(this.buffer.getCurseur(),this.buffer.getZoneTexte().length())) ;
            this.buffer.setZoneTexte(texteIntermediaire);
            this.buffer.setCurseur(curseurIntermediaire);
        }
    }


}
