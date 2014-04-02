

public class YVMasm extends YVM {
	int i; /* i est utile à la numérotation des message dans la fonction ECRIRE("--")*/
	
	public YVMasm(){
		super();
		i=0;
	}
	
	public void finASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.fin();
		Ecriture.ecrireString(FichierYVM,"nop \nexitcode\nend debut\n");
	}
	
	public void debutASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.debut();
		Ecriture.ecrireString(FichierYVM,"extrn lirent:proc, ecrent:proc \n"+"extrn ecrbool:proc \nextrn ecrch:proc,ligsuiv:proc\n\n");
		Ecriture.ecrireString(FichierYVM,".model SMALL\n.586\n\n.CODE\ndebut:\n\tSTARTUPCODE\n\n");
	}
	
	public void nomFoncASM(String f){
		super.nomFonc(f);
	}

	
	public void ouvreprincASM(int x){
		Ecriture.ecrireString(FichierYVM,";");
		super.ouvBloc(x);
		Ecriture.ecrireString(FichierYVM,"mov bp,sp\nsub sp,");
		Ecriture.ecrireInt(FichierYVM,x);
		Ecriture.ecrireString(FichierYVM,"\n\n");
	}
	
	public void iconstASM(int val){
		Ecriture.ecrireString(FichierYVM,";");
		super.iconst(val);
		Ecriture.ecrireString(FichierYVM,"push word ptr "+val+"\n\n");
	}
	
	public void iloadASM(int offset){
		Ecriture.ecrireString(FichierYVM,";");
		super.iload(offset);
		Ecriture.ecrireString(FichierYVM,"push word ptr [bp");
		Ecriture.ecrireInt(FichierYVM,offset);
		Ecriture.ecrireString(FichierYVM,"]\n\n");
	}
	
	public void istoreASM(int offset){
		Ecriture.ecrireString(FichierYVM,";");
		super.istore(offset);
		Ecriture.ecrireString(FichierYVM,"pop ax \nmov word ptr [bp");
		Ecriture.ecrireInt(FichierYVM,offset);
		Ecriture.ecrireString(FichierYVM,"],ax\n\n");
	}
	
	public void op_binASM(int c){
		switch (c){
		case PLUS:{ 
				Ecriture.ecrireString(FichierYVM,";");
				super.op_bin(c);
				Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \nadd ax, bx \npush ax\n\n");
				break;
			}
		case MOINS:{ 
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \nsub ax, bx \npush ax\n\n");
				break;
			}
		case DIV:{ 
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \ncwd \nidiv bx\npush ax\n\n");
				break;
			}	
		case MUL:{ 
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \nimul bx\npush ax\n\n");
			break;
			}
		case OR:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			break;
			}
		case AND:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			break;
			}
		case INF:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \ncmp ax,bx \njge $+6 \npush -1 \njmp $+4 \npush 0 \n\n");
			break;
			}
		case INFEGAL:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx\npop ax\ncmp ax,bx\njg $+6\npush -1\njmp $+4\npush 0 \n\n");
			break;
			}
		case SUP:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx \npop ax \ncmp ax,bx \njge $+6 \npush -1 \njmp $+4 \npush 0 \n\n");
			break;
			}
		case SUPEGAL:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx\npop ax\ncmp ax,bx\nja $+6\npush -1\njmp $+4\npush 0 \n\n");
			break; 
			}
		case EGAL:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx\npop ax\ncmp ax,bx\njne $+6\npush -1\njmp $+4\npush 0 \n\n");
			break;
			}
		case DIFF:{
			Ecriture.ecrireString(FichierYVM,";");
			super.op_bin(c);
			Ecriture.ecrireString(FichierYVM,"pop bx\npop ax\ncmp ax,bx\nje $+6\npush -1\njmp $+4\npush 0 \n\n");
			break;
			}
		}
	}
	
	public void op_unASM(int c){
		switch(c){
			case INV:
				Ecriture.ecrireString(FichierYVM,";");
				super.op_unaire(c);
				Ecriture.ecrireString(FichierYVM,"mov bx, -1\npop ax \nimul bx\npush ax\n\n");
				break;
				
			case NOT:
				Ecriture.ecrireString(FichierYVM,";");
				super.op_unaire(c);
				Ecriture.ecrireString(FichierYVM,"pop ax\ncmp ax, 0\njne $+6\npush -1\njmp $+4push 0\n\n");
				break;
		}
		
	}
	
	public void ittqueASM(){
		super.ittque();
	}
	
	public void iffauxASM(int choix){
		Ecriture.ecrireString(FichierYVM,";");
		switch(choix){
			case ITERATION:
				super.iffaux(ITERATION);
				Ecriture.ecrireString(FichierYVM,"pop ax\ncmp ax,0\nje FAIT"+compteurIter+"\n\n");
				break;
			case CONDITION:
				super.iffaux(CONDITION);
				Ecriture.ecrireString(FichierYVM,"pop ax\ncmp ax,0\nje SINON"+compteurCond+"\n\n");
				break;	
		}
		
	}
	
	public void ifaitASM(){
		super.ifait();
	}
	
	public void isiASM(){
		super.isi();
	}
	
	public void isinonASM(){
		super.isinon();
	}
	
	public void ifsiASM(){
		super.ifsi();
	}
	
	public void fgotoASM(int choix){
		Ecriture.ecrireString(FichierYVM,";");
		switch(choix){
			case ITERATION:
				super.fgoto(ITERATION);
				Ecriture.ecrireString(FichierYVM,"jmp FAIRE"+indexIter+"\n\n");
				break;
			case CONDITION:
				super.fgoto(CONDITION);
				Ecriture.ecrireString(FichierYVM,"jmp FSI"+indexCond+"\n\n");
				break;
		}
		
	}
	
	/*!on  ne l'utilise pas dans itération*/
	public void ifequASM(String etiquette){
		Ecriture.ecrireString(FichierYVM,";");
		super.ifequ(etiquette);
		/*Ecriture.ecrireString(FichierYVM,"pop ax\ncmpax,0 jne "+etiquette+""+sommeIter+"\n\n");*/
	}
	
	public void fermerFicASM(){
		Ecriture.fermer(FichierYVM);
	}
	
	public void ecrireEntASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.ecrireEnt();
		Ecriture.ecrireString(FichierYVM,"call ecrent\n\n");
	}
	
	public void ecrireChaineASM(String c){
		Ecriture.ecrireString(FichierYVM,";");
		super.ecrireChaine(c);
		int end = c.length() - 1;
		String c1 = c.substring(1, end);
		Ecriture.ecrireString(FichierYVM,".DATA\nmess"+i+" DB \" "+c1+"$\" \n.CODE \nlea dx, mess"+i+"\npush dx\ncall ecrch\n\n");
		i++;
	}
	
	public void ecrireBoolASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.ecrireEnt();
		Ecriture.ecrireString(FichierYVM,"call ecrbool\n\n");
	}
	
	public void lireEntASM(int v){
		Ecriture.ecrireString(FichierYVM,";");
		super.lireEnt(v);
		Ecriture.ecrireString(FichierYVM,"lea dx,[bp"+v+"]\npush dx\ncall lirent\n\n");
	}
	
	public void alaligneASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.alaligne();
		Ecriture.ecrireString(FichierYVM,"call ligsuiv\n\n");
	}
	
	public void ouvblocASM(int local){
		Ecriture.ecrireString(FichierYVM,";");
		super.ouvBloc(local);
		Ecriture.ecrireString(FichierYVM,"enter "+local+",0\n");
	}
	
	public void fermeblocASM(int param){
		Ecriture.ecrireString(FichierYVM,";");
		super.fermebloc(param);
		Ecriture.ecrireString(FichierYVM,"leave\nret "+param+"\n");
	}
	
	public void ireturnASM(int offset){
		Ecriture.ecrireString(FichierYVM,";");
		super.ireturn(offset);
		Ecriture.ecrireString(FichierYVM,"pop ax\n mov [bp+"+offset+"],ax\n");
	}
	
	public void reserveRetourASM(){
		Ecriture.ecrireString(FichierYVM,";");
		super.reserveRetour();
		Ecriture.ecrireString(FichierYVM,"sub sp,2\n");
	}
	
	public void callASM(String name){
		Ecriture.ecrireString(FichierYVM,";");
		super.call(name);
		Ecriture.ecrireString(FichierYVM,"call "+name+"\n");
	}
}