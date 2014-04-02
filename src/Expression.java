import java.util.Stack;



public class Expression implements Constante{
	
	Stack<Integer> pileOperande= new Stack<Integer>();
	Stack<Integer> pileOperateur= new Stack<Integer>();
	
		public Expression(){
			
		}
	
		/**
		 * Empiler une operande dans la pile des operandes
		 * @param val valeur de l'operande
		 */
		public void empileOperande(int val ){
			pileOperande.push(val);
		}
		
		/**
		 * Empiler un operateur dans la pile des operateurs
		 * @param op l'operateur a empiler
		 */	
		public void empileOperateur(int op ){
			pileOperateur.push(op);
		}
		
		/**
		 * Evaluation de l'expression
		 */
		public void  evaluationExpr(int beginLine){
			int op2=0;
			
			int op=pileOperateur.pop();
			int op1=pileOperande.pop();
			
			
			if (!pileOperande.empty()){
				op2=pileOperande.pop();
			}else{
				System.out.println("Erreur expression pile vide !\n");
			}
			
			/*System.out.println(" op1 : "+op1+"op :"+op+" op2 : "+op2+"\n");*/
			
			switch (op){
				case PLUS:
					if(op1==INT && op2==INT) {
						empileOperande(INT);
					   	Yaka.yvmasm.op_binASM(PLUS);
					}else{
						if (op1==ERREUR){
						empileOperande(ERREUR);
						}else{
							empileOperande(ERREUR);
							System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
						}
						
					}
					break;
					
				case MOINS:
					if(op1==INT && op2==INT) {
						empileOperande(INT);
					   	Yaka.yvmasm.op_binASM(MOINS);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case MUL:
					if(op1==INT && op2==INT) {
						empileOperande(INT);
					   	Yaka.yvmasm.op_binASM(MUL);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case DIV:
					if(op1==INT && op2==INT) {
						empileOperande(INT);
					   	Yaka.yvmasm.op_binASM(DIV);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case INF:
					if(op1==INT && op2==INT) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(INF);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case SUP:
					if(op1==INT && op2==INT) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(SUP);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case INFEGAL:
					if(op1==INT && op2==INT) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(INFEGAL);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case SUPEGAL:
					if(op1==INT && op2==INT) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(SUPEGAL);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type int\n");
							}
					}
					break;
				case EGAL:
					if((op1!= ERREUR || op2 != ERREUR) && op1 == op2) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(EGAL);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de même type\n");
							}
						
					}
					break;
				case DIFF:
					if((op1!= ERREUR || op2 != ERREUR) && op1 == op2) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(DIFF);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de même type\n");
							}
					}
					break;
				case AND:
					if(op1==BOOL && op2==BOOL) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(AND);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type BOOL\n");
							}
						
					}
					break;
				case OR:
					if(op1==BOOL && op2==BOOL) {
						empileOperande(BOOL);
					   	Yaka.yvmasm.op_binASM(OR);
					}else{
						if (op1==ERREUR){
							empileOperande(ERREUR);
							}else{
								empileOperande(ERREUR);
								System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de type BOOL\n");
							}
					}
					break;
				case AFFECT:
					if(op1==INT && op2 == INT){
						empileOperande(INT);
					}else {
						if(op1==BOOL && op2 == BOOL){
							empileOperande(BOOL);
						}else{
							if (op2==ERREUR){
								empileOperande(ERREUR);
								}else{
									empileOperande(ERREUR);
									System.out.println("Erreur ligne "+beginLine+" les 2 opérateurs doivent être de même type\n");
								}
							
						}
					}
					break;
			
			}


		}
		
		public void evaluerExprUn(int beginLine){
			int op=pileOperateur.pop();
			int op1=pileOperande.pop();
			
			
			if (pileOperande.empty()){
				System.out.println("Erreur expression pile vide !\n");
			}
			
			switch(op){
				case INV:
					if(op1==INT){
						empileOperande(INT);
						Yaka.yvmasm.op_unASM(INV);
					}else{
						empileOperande(ERREUR);
						System.out.println("ERREUR ligne :"+beginLine+" l'opérateur doit être de type int\n");
					}
					break;
					
				case NOT:
					if(op1==BOOL){
						empileOperande(BOOL);
						Yaka.yvmasm.op_unASM(NOT);
					}else{
						empileOperande(ERREUR);
						System.out.println("ERREUR ligne :"+beginLine+" l'opérateur doit être de type BOOL\n");
					}
					break;
			
			}
			
		}
		
		public void evaluationReturnFonc(String fonction, int beginLine){
			int op1=pileOperande.pop();
			IdFonc f = (IdFonc) Yaka.tabIdent.chercheIdent(fonction, Constante.GLOBAUX, beginLine);
			
			if(op1!=f.getResultat()){
				switch(op1){
					case BOOL:
						System.out.println(" Erreur fonction :"+f.getNom()+" la fonction doit retourner un resultat de type : BOOL. ERREUR LIGNE :"+beginLine+"\n");
						empileOperande(ERREUR);
						break;
					case INT:
						System.out.println(" Erreur fonction :"+f.getNom()+" la fonction doit retourner un resultat de type : INT. ERREUR LIGNE :"+beginLine+"\n");
						empileOperande(ERREUR);
						break;
				}
			}else{
				switch(op1){
					case INT:
						empileOperande(INT);
						break;
					case BOOL:
						empileOperande(BOOL);
						break;
				}
			}
		}
		
		public void controleParametre(String nameFonc, int type, int cpt, int ligne){
			int op = pileOperande.pop();
			Ident id = Yaka.tabIdent.chercheIdent(nameFonc, Constante.GLOBAUX, ligne); 

			if(op!=id.getParam(cpt)){
				switch (op){
					case BOOL:
						System.out.println(" Le "+cpt+"eme parametre de la fonction "+nameFonc+"doit etre de type BOOLEEN. ERREUR ligne:"+ligne+"\n");
						break;
					case INT:
						System.out.println(" Le "+cpt+"eme parametre de la fonction "+nameFonc+"doit etre de type ENTIER. ERREUR ligne:"+ligne+"\n");
						break;
				}
				
			}
		}
		
		public void evaluationNbParam(String nameFonc,int cpt, int ligne){
			Ident id = Yaka.tabIdent.chercheIdent(nameFonc, Constante.GLOBAUX, ligne); 
			if(cpt != id.getTailleTabParam()){
				System.out.println("Le nombre de parametre dans la fonction "+nameFonc+" doit etre egale a "+cpt+" ERREUR ligne:"+ligne+"\n");
			}
		}
		
		
		

}