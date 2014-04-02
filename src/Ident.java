import java.util.ArrayList;



public class Ident {
	
	public String nom;
	public int natureId;
	/**idConst*/
	public int val;
	public int type;
	/**idVar*/
	public int offset;
	/**idFonc*/
	public int resultat;
	public ArrayList<Integer> param = new ArrayList<Integer>();
	
	
	/**
	 * Créer un ident 
	 * @param n le nom de l'ident
	 * @param t specifie si l'ident est un identificateur est global ou local
	 */
	public Ident(String n, int t){
		this.nom=n;
		this.natureId = t;
	}

	/**
	 * Retourne la nature de l'identificateur: globl ou local
	 */
	public int getNatureId(){
		return natureId;
	}
	
	/**
	 * Modifie la nature de l'identificateur
	 * @param newType specifie si l'ident est un identificateur est global ou local
	 */
	public void setNatureId(int newType){
		this.natureId=newType;
	}
	
	/**
	 * Retourne le nom de l'identificateur
	 */
	public String getNom(){
		return nom;
	}
	
	/**
	 * Modifie le nom de l'identificateur
	 * @param newName le nom de l'identificateur
	 */
	public void setNom(String newName){
		this.nom=newName;
	}
	
	/**
	 * Retourne le type de l'identificateur
	 */
	public int getType(){
		return type;
	}
	
	/**
	 * Modifie le type d'un identificateur de Constante
	 * @param newType le type de l'ident
	 */
	public void setType(int newType){
		this.type=newType;
	}

	/**
	 * Retourne la valeur de l'identificateur
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * Modifie la valeur de l'identificateur
	 * @param v la valeur de la constante
	 */
	public void setVal(int v){
		this.val=v;
	}

	public int getOffset(){
		return offset;
	}
	
	public void setOffset(int v){
		this.offset=v;
	}
	
	public int getResultat(){
		return resultat;
	}
	
	public void setResultat(int r){
		this.resultat=r;
	}
	
	public void setParam(int p){
		param.add(p);
	}
	
	/**
	 * Retourne le dernier élément de la liste des parametres de la fonction
	 */
	public int getParam(int i){
		return param.get(i);
	}
	
	public int getTailleTabParam(){
		return param.size();
	}



}
	
	
	
