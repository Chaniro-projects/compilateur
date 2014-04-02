import java.io.OutputStream;
import java.util.Stack;



public class YVM implements Constante{
	OutputStream FichierYVM ;
	public Stack<Integer> pileIter =new Stack<Integer>();
<<<<<<< HEAD
	public Stack<Integer> pileCond =new Stack<Integer>();
	int compteurIter = 0;
	int compteurCond = 0;
	int indexIter;
	int indexCond;
	
=======
	
	public Stack<Integer> pileSi = new Stack<Integer>();
	public int indexSi = 0;
>>>>>>> d1af652bc3fb8a7ad02ba0d0eb02e727b7cf2a31


	
	public YVM (){
		FichierYVM=Ecriture.ouvrir("YVM.asm");
		pileIter.push(0);
		pileCond.push(0);
	}
	
	public void debut(){
		Ecriture.ecrireString(FichierYVM,"entete"+"\n");
		
	}
	
	public void fin(){
		Ecriture.ecrireString(FichierYVM,"queue"+"\n");
		
	}
	
	public void nomFonc(String f){
		Ecriture.ecrireString(FichierYVM,f+" :\n");
	}
	
	public void ouvBloc(int variable){
		Ecriture.ecrireString(FichierYVM,"ouvBloc ");
		Ecriture.ecrireInt(FichierYVM, variable);	
		Ecriture.ecrireString(FichierYVM,"\n");
	}
	
	
	public void iconst(int val){
		Ecriture.ecrireString(FichierYVM,"iconst ");
		Ecriture.ecrireInt(FichierYVM, val);
		Ecriture.ecrireString(FichierYVM,"\n");
	}
	
	public void iload(int offset){
		Ecriture.ecrireString(FichierYVM,"iload ");
		Ecriture.ecrireInt(FichierYVM, offset);
		Ecriture.ecrireString(FichierYVM,"\n");
	}
	
	public void istore(int offset){
		Ecriture.ecrireString(FichierYVM,"istore ");
		Ecriture.ecrireInt(FichierYVM, offset);
		Ecriture.ecrireString(FichierYVM,"\n");
	}

	public void op_bin(int c){
		switch (c){
			case PLUS:{ 
					Ecriture.ecrireString(FichierYVM,"iadd \n");
					break;
				}
			case MOINS:{ 
					Ecriture.ecrireString(FichierYVM,"isub \n");
					break;
				}
			case DIV:{ 
					Ecriture.ecrireString(FichierYVM,"idiv \n");
					break;
				}	
			case MUL:{ 
				Ecriture.ecrireString(FichierYVM,"imul \n");
				break;
				}
			case OR:{
				Ecriture.ecrireString(FichierYVM,"ior \n");
				break;
				}
			case AND:{
				Ecriture.ecrireString(FichierYVM,"iand \n");
				break;
				}
			case INF:{
				Ecriture.ecrireString(FichierYVM,"iinf \n");
				break;
				}
			case INFEGAL:{
				Ecriture.ecrireString(FichierYVM,"iinfegal \n");
				break;
				}
			case SUP:{
				Ecriture.ecrireString(FichierYVM,"isup \n");
				break;
				}
			case SUPEGAL:{
				Ecriture.ecrireString(FichierYVM,"isupegal \n");
				break;
				}
			case EGAL:{
				Ecriture.ecrireString(FichierYVM,"iegal \n");
				break;
				}
			case DIFF:{
				Ecriture.ecrireString(FichierYVM,"idiff \n");
				break;
				}
		}
	}

		public void op_unaire(int c){
			//yvmasm.op_unaireASM(c);
			switch (c){
			case INV:
					Ecriture.ecrireString(FichierYVM,"ineg \n");
					break;
					
			case NOT:
				Ecriture.ecrireString(FichierYVM,"inot \n");
				break;
				
			}
		}
		
		public void ittque(){
			compteurIter++;
			pileIter.push(compteurIter);
			Ecriture.ecrireString(FichierYVM,"FAIRE"+compteurIter+" :\n");
			
		}
		
		public void isi(){
			compteurCond++;
			pileCond.push(compteurCond);
		}
		
		public void iffaux(int choix){
			switch(choix){
				case ITERATION:
					Ecriture.ecrireString(FichierYVM,"iffaux FAIT"+compteurIter+"\n");
					break;
				case CONDITION:
					Ecriture.ecrireString(FichierYVM,"iffaux SINON"+compteurCond+"\n");
					break;
					
			}
			
		}
		
		public void ifait(){
			Ecriture.ecrireString(FichierYVM,"FAIT"+indexIter+":\n");
		}
		
<<<<<<< HEAD
		public void ifsi(){
			Ecriture.ecrireString(FichierYVM,"FSI"+indexCond+":\n");
		}
		
		public void isinon(){
			Ecriture.ecrireString(FichierYVM,"SINON"+indexCond+":\n");
=======
		/*l'it�ration n'utilise que iffaux*/
		public void iffaux(){
			int s=0;
			for(int i=0; i<pileIter.size(); i++){
				s+=pileIter.get(i);
			}
			Ecriture.ecrireString(FichierYVM,"iffaux FAIT"+s+"\n");
		}
		
		public void isi() {
			indexSi++;
			pileSi.add(indexSi);
		}
		
		/*!*/
		public void ifequ(String c){
			Ecriture.ecrireString(FichierYVM,"ifequ "+c+"\n");
>>>>>>> d1af652bc3fb8a7ad02ba0d0eb02e727b7cf2a31
		}
		
		public void fgoto(int choix){
			switch(choix){
				case ITERATION:
					indexIter=pileIter.pop();
					Ecriture.ecrireString(FichierYVM,"goto FAIRE"+indexIter+"\n");
					break;
				case CONDITION:
					indexCond=pileCond.pop();
					Ecriture.ecrireString(FichierYVM,"goto FSI"+indexCond+"\n");
					break;	
			}
			
		}
		

		
		
		public void ifequ(String c){
			Ecriture.ecrireString(FichierYVM,"ifequ "+c+"\n");
		}

		public void fermerFic(){
			Ecriture.fermer(FichierYVM);
		}
		
		public void ecrireEnt(){
			Ecriture.ecrireString(FichierYVM,"ecrireEnt\n");
		}
		
		public void ecrireChaine(String c){
			Ecriture.ecrireString(FichierYVM,"ecrireChaine "+c+" \n");
		}
		
		public void ecrireBool(){
			Ecriture.ecrireString(FichierYVM,"ecrireBool\n");
		}
		
		public void lireEnt(int v){
			Ecriture.ecrireString(FichierYVM,"lireEnt "+v+"\n");
		}
		
		public void alaligne(){
			Ecriture.ecrireString(FichierYVM,"aLaLigne\n");
		}
		
		public void op_un(String c){
			switch(c){
				case "INV":
					Ecriture.ecrireString(FichierYVM,"ineg \n");
					break;
					
				case "NOT":
					Ecriture.ecrireString(FichierYVM,"inot \n");
					break;
			}
			
		}
		
		
		public void fermebloc(int param){
			Ecriture.ecrireString(FichierYVM,"fermebloc "+param+"\n");
		}
		
		public void ireturn(int offset){
			Ecriture.ecrireString(FichierYVM,"ireturn "+offset+"\n");
		}
		
		public void reserveRetour(){
			Ecriture.ecrireString(FichierYVM,"reserveRetour \n");
		}
		
		public void call(String name){
			Ecriture.ecrireString(FichierYVM,"call "+name+"\n");
		}
}


