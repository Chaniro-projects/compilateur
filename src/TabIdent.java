import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent implements Constante{
	
	private HashMap<String,Ident> globaux;
	private HashMap<String,Ident> locaux;
	
	
	/**
	 * Le constructeur de TabIdent
	 *
	 *	@param	taille : le nombre d'identificateur à mettre dans la table
	 */
	public TabIdent(int taille) {
		globaux = new HashMap<String,Ident>(taille);
		setLocaux(new HashMap<String,Ident>(taille));
	}
	
	/**
	 * Accesseur du tableau d'identificateur
	 *
	 *	@param cle : la cle de l'Ident a trouver
	 *	@param ligne : la ligne de l'erreur
	 *	@param natureIdent : specifie si l'ident est un globaux ou un locaux
	 *	@return	l'Ident associe a la cle s'il existe, sinon message d'erreur
	 */
	public Ident chercheIdent(String cle,  int natureIdent, int ligne) {
		Ident ident = new Ident(cle, natureIdent);
		switch(natureIdent){
			case GLOBAUX:
				ident = globaux.get(cle);
				return ident;
			case LOCAUX:
				ident = getLocaux().get(cle);
				return ident;
		}

			System.out.println("\n erreur ligne : "+ligne+" chercheIdent() n'arrive pas à trouver l'identificateur de nom : "+cle+" car elle n'existe pas dans la table\n");
			return ident;
	}
	
	
	/**
	 * Test de l'existence de l'Ident 
	 *
	 *	@param	cle : la cle de l'identifiacateur
	 *	@param	natureIdent : specfie si l'ident est de nature globaux ou locaux
	 *	@param	ligne : la ligne de l'erreur
	 *	@return	vrai si l'Ident existe, faux sinon
	 */
	public boolean existeIdent(String cle, int natureIdent, int ligne) {
		switch(natureIdent){
			case GLOBAUX:
				return globaux.containsKey(cle);
			case LOCAUX:
				System.out.println(cle+" "+ligne+"\n");
				return getLocaux().containsKey(cle);
			default:
				System.out.println(" ERREUR existeIdent() : l'ident de nom: "+cle+" n'est dans aucune des tables de locaux ou globaux, ligne "+ligne+"\n");
				return false;
		}
		
	}
	
	
	/**
	 * La methode range l'Ident dans la table d'Ident 
	 *
	 *	@param	cle : la cle de l'identificateur
	 *	@param	valeur: l'Ident a stocker dans la tabIdent
	 *	@param	natureIdent: spécifie si l'ident est de nature locaux ou globaux
	 *	@see	Ident
	 */
	public void rangeIdent(String cle, Ident valeur, int natureIdent) {
		switch(natureIdent){
			case GLOBAUX:
				globaux.put(cle, valeur);
				break;
			case LOCAUX:
				getLocaux().put(cle,  valeur);
				break;	
		}
		
	}
	
	
	/**
	 * La methode compte le nombre de variable contenu dans la table
	 *
	 *	@return	le nombre de variable contenu dans la table des locaux
	 *	@see	Ident
	 */
	public int getNbVarLocal() {
		int nb = 0;
		
		for(String key : getLocaux().keySet())
			if(getLocaux().get(key).getOffset()<0)
				nb++;
		
		return nb;
	}
	
	public int getNbParam() {
		int nb = 0;
		
		for(String key : getLocaux().keySet())
			if(getLocaux().get(key).getOffset()>=4)
				nb++;
		
		return nb;
	}
	
	/**
	 * La methode compte le nombre de variable contenu dans la table des globaux
	 *
	 *	@return	le nombre de variable contenu dans la table
	 *	@see	Ident
	 */
	public int getNbVarGlobaux() {
		int nb = 0;
		
		for(String key : globaux.keySet())
			if(globaux.get(key) instanceof IdVar)
				nb++;
		
		return nb;
	}
	
	/**
	 * La methode qui affiche le contenu de la table
	 *
	 */
	public void affiche() {
		System.out.println("\n\nVoici la table des identificateurs : \nGlobaux\n{\n");
		for(Entry<String, Ident> e : globaux.entrySet()) {
			System.out.println(e.getKey() + " = " + e.getValue().natureId+ " resultat :"+e.getValue().resultat);
		}
		System.out.println("}\nLocaux\n");
		for(Entry<String, Ident> e : getLocaux().entrySet()) {
			System.out.println(e.getKey() + " = " + e.getValue().type+" "+e.getValue().offset);
		}
		System.out.println("}\n");
	}
	
	/**
	 * La methode rend le type d'une variable BOOLEEN ou ENTIER en local
	 *
	 *	@return	nom : le nom de la variable
	 *	
	 */
	public boolean typeVarLocaux(String nom){
		if (getLocaux().get(nom) instanceof IdVar){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * La methode rend le type d'une variable BOOLEEN ou ENTIER en global
	 *
	 *	@return	nom : le nom de la variable
	 *	
	 */
	public boolean typeVarGlobaux(String nom){
		if (globaux.get(nom) instanceof IdFonc){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * La methode rend le type de la constante BOOLEEN ou ENTIER en local
	 *
	 *	@return	nom : le nom de la constante
	 *	
	 */
	public boolean typeConstLocaux(String nom){
		if (getLocaux().get(nom) instanceof IdConst){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * Getter et setter de la table des variables locaux
	 *
	 *	
	 */
	public HashMap<String,Ident> getLocaux() {
		return locaux;
	}

	public void setLocaux(HashMap<String,Ident> locaux) {
		this.locaux = locaux;
	}
	
}