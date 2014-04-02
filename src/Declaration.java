import java.util.ArrayList;
import java.util.HashMap;



public class Declaration implements Constante{
	
	/**offset compte l'offset des variables*/
	public static int offset;

	/**On stocke le rang du parametre*/
	public static int rang;
	
	/**Le nombre de parametre de la fonction*/
	public static int nbParams;
	
	/**Un tableau contenant le nom des parametres d'un fonction donnée*/
	public static ArrayList<String> paramsName;
	
	/**nomFonction permet de memoriser le nom de la fonction*/
	public static String nomFonction;

	public Declaration(){}
	
	/**
	 * Declaration d'un IdConst de type A = 2
	 * @param nom Nom de la constante
	 * @param val valeur de la constante
	 * @param type Type de la constante a declarer
	 * @param natureIdent specifie si l'ident est en local ou en global
	 * @param ligne affichage de la ligne en cas d'erreur
	 */
	public static void addConstFromValue(String nom, int val, int type, int natureIdent, int ligne) {
		IdConst ident = new IdConst(nom, natureIdent, type);
		ident.setVal(val);
		System.out.println("ADDCONSTFROMVALUE\n");
		if(Yaka.tabIdent.existeIdent(nom, natureIdent, ligne)){
			System.out.println("\n attention la constante : "+ nom +" a déjà été initialisée\n ligne : "+ligne+"\n");
		}else{
			Yaka.tabIdent.rangeIdent(nom, ident, natureIdent);
		}
	}
	
	/**
	 * Declaration de IdConst de type A = B
	 * @param name Nom de la constante
	 * @param type Type de la constante a declarer
	 * @param Const idConst à affecter
	 * @param natureIdent specifie le type de l'ident s'il est en global ou en local
	 * @param ligne affichage de la ligne en cas d'erreur
	 */
	public static void addConstFromIdent(String name,String Const,int natureIdent, int ligne){
		System.out.println("ADDCONSTFROMIDENT\n");
		if(!Yaka.tabIdent.existeIdent(Const, natureIdent, ligne)){
			System.out.println("La constante :"+Const+" n'existe pas. Erreur ligne : "+ligne+"\n");
		}else{
				int type = Yaka.tabIdent.chercheIdent(Const, natureIdent, ligne).getType();
				IdConst ident = new IdConst(name, natureIdent, type);
				ident.setVal(Yaka.tabIdent.chercheIdent(Const, natureIdent, ligne).getVal());
				Yaka.tabIdent.rangeIdent(name, ident, natureIdent);
			}
	}

	/**
	 * Declaration de IdConst de type A = VRAI
	 * @param name Nom de la constante
	 * @param type Type de la constante a declarer
	 * @param val valeur à affecter
	 * @param natureIdent specifie la nature de l'ident si il est local ou global
	 */
	public static void addConstFromBoolean(String name,int val,int type, int natureIdent) {
		IdConst ident = new IdConst(name,natureIdent, type);
		ident.setVal(val);
		Yaka.tabIdent.rangeIdent(name, ident, natureIdent);
	}
	
	/**
	 * Declaration des variables ex: VAR ENTIER c1,c2
	 * @param name Nom de la constante
	 * @param type Type de la constante a declarer
	 * @param natureIdent specifie le type de l'ident s'il est en local ou en global
	 */
	public static void addVariable(String name,int type, int natureIdent) {
		IdVar ident = new IdVar(name, natureIdent, type);
		ident.setOffset(offset);
		Yaka.tabIdent.rangeIdent(name, ident, natureIdent);
		offset -= 2;
	}
	
	/**
	 * La methode rend l'offset de la variable
	 * @param name Nom de la variable
	 */
	public static int returnOffset(String name, int ligne, int natureIdent){
		System.out.println("RETURNOFFSET\n");
		if(!Yaka.tabIdent.existeIdent(name, natureIdent, ligne)){
			return 0;
		}else{
			return Yaka.tabIdent.chercheIdent(name, natureIdent, ligne).getOffset();
		}
	}
	
	/**
	 * La methode permet d'ajouter une fonction dans la table des globaux
	 * @param name le nom de la fonction
	 * @param resultat le type du resultat
	 * @param ligne ligne de l'erreur 
	 */
	public static void addFonction(String name, int result, int ligne){
		System.out.println("ADDFONCTION\n");
		if(Yaka.tabIdent.existeIdent(name, Constante.GLOBAUX, ligne)){
			System.out.println("\n attention la constante : "+ name +" a déjà été initialisée\n ligne : "+ligne+"\n");
		}else{
			IdFonc ident = new IdFonc(name, GLOBAUX, result);
			Yaka.tabIdent.rangeIdent(name, ident, Constante.GLOBAUX);
			Yaka.tabIdent.setLocaux(new HashMap<String,Ident>(100));
			nomFonction = name;
			offset=-2;
			nbParams=0;
			rang = 1;
			paramsName = new ArrayList<String>();
		}
		
		
	}
	
	/**
	 * La methode permet d'ajouter un parametre dans la table des locaux
	 * @param name le nom du parametre
	 * @param type bool ou int
	 * @param ligne ligne de l'erreur 
	 */
	public static void addFonctionParam(String name,int type, int ligne) {
		System.out.println("ADDFONCTIONPARAM\n");
		if(Yaka.tabIdent.existeIdent(name, Constante.LOCAUX, ligne)){
			System.out.println("\n attention la constante : "+ name +" a déjà été initialisée\n ligne : "+ligne+"\n");
		}else{
			
			IdVar ident = new IdVar(name, Constante.LOCAUX, type);
			/** on stocke d'abord le rang à la place de l'offset pour le modifer après*/
			ident.setOffset(rang);
			Yaka.tabIdent.rangeIdent(name, ident, Constante.LOCAUX);
			paramsName.add(name);
			rang++;
			/**on ajoute le type dans la liste des type de IdFonc*/
			Yaka.tabIdent.chercheIdent(nomFonction, GLOBAUX, ligne).setParam(type);

		}
		
	}

	/**
	 * La methode permet de calculer l'offSet des parametres
	 * @param ligne ligne de l'erreur 
	 */
	public static void calculOffsetParam(int ligne) {
		nbParams=paramsName.size();
		
		for(int i = 0; i<nbParams; i++) {
			Yaka.tabIdent.chercheIdent(paramsName.get(i), LOCAUX, 0).setOffset(paramsName.size()*2+4-((i+1)*2));
		}
	}
	
	
	
}
	
	
	

