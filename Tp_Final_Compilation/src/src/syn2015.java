package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class syn2015 {
	static String [] tab;
	public static int i=0;
	static PrintWriter p=null;
	public static void avencer(){
		i++;
	}
	
	public static void programme(){
		if (tab[i].equals("programme")){
			avencer();
			if (tab[i].equals("id")){
				avencer();
				if (tab[i].equals(";")){
					avencer();
					p.println("<programmealgo>::=<nom>;");
					
				}else {
					p.println("erreur  ';' attentdu ");
					avencer();
				}
			}else {
				p.println("erreur 'nom de  programme' attentdu  ");
				avencer();
			}
		}else {
			p.println("erreur 'programme' attentdu ");
			avencer();
			}
	
		if (tab[i].equals("const")){
			avencer();
		cons();
		
		}
		if (tab[i].equals("var")){
			avencer();
			groupevar();	
		}
		
		
	corps();
		
	}// procedure programme
	
	public static void corps(){
		if (tab[i].equals("debut")){
			avencer();
		}else{
			p.println("Erreur 'debut' De programme principale attentdu");
		}
		while (tab[i].equals(".")==false&&(i<tab.length-1)){
		
			switch(tab[i]){
		
		
		case "si":
			avencer();
			si();
			break;
		case "tantque":
			avencer();
			tq();
			break;
		case "id":
			
			aff();
			break;
		default:
			avencer();
			if (i<tab.length){
			p.println("Erreur '"+tab[i]+"'Ne doit pas existe ici");
			}
		}
	  }
	}
	public static void cons(){
		while (tab[i].equals("id")){
			if (tab[i].equals("id")&&tab[i+1].equals("opl")){
				
					if (tab[i+2].equals("num")||tab[i+2].equals("id")){
						if (tab[i+3].equals(";")){
							p.println("<PartieConstante::=<nom>=<Constante>;");
							avencer();//=
							avencer();//id
							avencer();//;
							avencer();//new
						}
					}
				
			}else{
		if (tab[i].equals("id")){
			avencer();
			if (tab[i].equals("opl")){
				avencer();
				if (tab[i].equals("num")||tab[i].equals("id")){
					avencer();
					if (tab[i].equals(";")){
						avencer();
						//id=id||num;
						
					}else{
						p.println("Erreur ';' attentdu a la partie des constants");
						avencer();
					}
					
					
				}else{
					p.println("Erreur 'Constante' attentdu a la partie des constants");
					avencer();
				}
			
				}else{
				p.println("Erreur '=' attentdu a la partie des constans ");
				avencer();
			}
		}else{
			p.println("erreur 'identificateur'  attentdu a la partie des constants ");
			avencer();
				}
		
			}
		}
	}
	
	public static void groupevar(){
		while(tab[i].equals("debut")==false && (i<tab.length-1)){
			if (tab[i].equals("id")){
				avencer();
			}else {
				p.println("Erreur 'identificateur' attentdu a la partie des variables");
				avencer();
			}
			while (tab[i].equals(",")&&(i<tab.length-1)){
				if (tab[i].equals(",")){
					avencer();
					if (tab[i].equals("id")){
						avencer();
					}else{
						p.println("Erreur 'identificateur' attentdu a la partie des variables");
						avencer();
					}
					
				}else{
					p.println("Erreur ',' attentdu a la partie des variables");
					avencer();
				}
				
			}
			if (tab[i].equals(":")){
				avencer();
				if (tab[i].equals("entier")||tab[i].equals("réel")){
					avencer();
					if (tab[i].equals(";")){
						avencer();
						p.println("Groupe Variable ::=<nom>{,<nom>}:<nomType>;");
						
						
					}else{
						p.println("Erreur ';' attentdu a la partie des variables");
						avencer();
					}
					
					
				}else {
					p.println("Erreur 'Nom_Type' attentdu a la partie des variables ");
					avencer();
				}
				
			}else{
				p.println("Erreur ':' attentdu a la partie des variables");
				avencer();
			}
		}
		p.println("<PartieDéfinitionVariable>::=Var<Définition Variable>{<Définition Variable>}");
		
	}
	
	
	
	public static void si(){
		if (tab[i].equals("(")){
			avencer();
			cond();
			if (tab[i].equals(")")){
				avencer();
				if (tab[i].equals("alors")){
					avencer();
					if (tab[i].equals("debut")){
						instrcomp();
						p.println("<InstructionSi>::=Si <Condition> alors <Instruction> [sinon <Instruction>]");
						}else {
							inst();
							p.println("<InstructionSi>::=Si <Condition> alors <Instruction> [sinon <Instruction>]");
						}
					
					
					
					
					
				}else {
					p.println("Erreur 'alors' attentdu");
					
				}
			}else{
				p.println("Erreur ')' Attetndu");
			}
			
			
			if (tab[i].equals("sinon")){
				avencer();
				inst();
				p.println("<InstructionSi>::=Si <Condition> alors <Instruction> [sinon <Instruction>]");
			}
			if (tab[i].equals("fin")){
				avencer();
			}else{
				p.println("Erreur 'fin' attetndu");
			}
			
		}
		else {
			cond();
			
			if (tab[i].equals("alors")){
				avencer();
				if (tab[i].equals("debut")){
					instrcomp();
					}else {
						inst();
						p.println("<InstructionSi>::=Si <Condition> alors <Instruction> [sinon <Instruction>]");
					}
				
				if (tab[i].equals("sinon")){
					avencer();
					inst();
					p.println("<InstructionSi>::=Si <Condition> alors <Instruction> [sinon <Instruction>]");
				}	
				
				
			}else {
				p.println("Erreur 'alors' attentdu");
				
			}
			
			if (tab[i].equals("fin")){
				avencer();
			}else{
				p.println("Erreur 'fin' attetndu");
			}
			
			
		}
	}
	public static void tq(){
		if (tab[i].equals("(")){
			avencer();
			cond();
			if (tab[i].equals(")")){
				avencer();
				if (tab[i].equals("faire")){
					avencer();
					if (tab[i].equals("debut")){
						instrcomp();
						}else {
							inst();
						}
					
							
				}else {
					p.println("Erreur 'faire' attentdu");
					
				}
					
			}else{
				p.println("Erreur ')' Attetndu");
			}
			
			
						
			p.println("<InstructionTq>::=tantque (<Condition>) faire <Instruction> ");
		}
		else {
			cond();
			
			if (tab[i].equals("faire")){
				avencer();
				if (tab[i].equals("debut")){
					instrcomp();
					}else {
						inst();
					}
				}else {
				p.println("Erreur 'faire' attentdu");
					}
			
			p.println("<InstructionTq>::=tantque <Condition> faire <Instruction> ");
			
		}
		
	}
	public static void aff(){
		if (tab[i].equals("id")&&tab[i+1].equals(":=")){
			avencer();avencer();
			exp();
			p.println("<InstructionAffectation>::=<nom>:=<Expression>");
		}else {
			p.println("Erreur 'affectation' attentdu");
			avencer();
		}
		
	}
	public static void cond(){
		if (tab[i].equals("non")){
			avencer();
			exp();
			if (tab[i].equals("opl")){
				avencer();
				exp();
				p.println("<Condition>::=non <Condition>");
			}else{
				p.println("Erreur 'Operateur Logique '  attentdu a cette Condition ");
			}
		}else {		
		exp();
		if (tab[i].equals("opl")){
			avencer();
			exp();
			p.println("<Condition>::=<Expression><OperateurLogique><Expression>");
		}else{
			p.println("Erreur 'Operateur Logique '  attentdu a cette Condition ");
		}
		if (tab[i].equals("et")){
			avencer();
			exp();
			if (tab[i].equals("opl")){
				avencer();
				exp();
				p.println("<Condition>::=<Condition> et <Condition>");
			}else{
				p.println("Erreur 'Operateur Logique '  attentdu a cette Condition ");
			}
		}else if (tab[i].equals("ou")){
			avencer();
			exp();
			if (tab[i].equals("opl")){
				avencer();
				exp();
				p.println("<Condition>::=<Condition> ou <Condition>");
			}else{
				p.println("Erreur 'Operateur Logique '  attentdu a cette Condition ");
			}
		}
		
		}
		
	}
	public static void exp(){
		if (tab[i].equals("id")&&tab[i+1].equals("opa")&&tab[i+2].equals("id")){
			avencer();avencer();avencer();
			p.println("<Expression>::=<Expression><OperateurArithmétique><Expression>");
		}else if (tab[i].equals("(")&&tab[i+1].equals("id")&&tab[i+1].equals("opa")&&tab[i+1].equals("id")&&tab[i+1].equals(")")){
			avencer();avencer();avencer();avencer();avencer();
			p.println("<Expression>::=(Expression)");
		}else if (tab[i].equals("id")){
			avencer();
			p.println("<Expression>::=<Nom>");
		}else if (tab[i].equals("num")){
			avencer();
			p.println("<Expression::=<Nombre>");
		}else{
			p.println("Erreur 'expression' attentdu a cette Instruction ");
			
		}
		
	}
	
	public static void instrcomp(){
		if (tab[i].equals("debut")){
			avencer();
			inst();
			while(tab[i].equals(";")){
				avencer();
				inst();
			}
			
			if (tab[i].equals("fin")){
				avencer();
				
			}else {
				p.println("Erreur 'fin' attentdu a la partie des instructions ");
				avencer();
			}
			
			
			
			
		}else {
			p.println("Erreur 'debut' attentdu a la partie des instructions ");
			avencer();
		}
		
		
	
	}
	
	public static void inst(){
	if (tab[i].equals("si")){
		si();
		
	}else if (tab[i].equals("tantque")){
		tq();
	}else if (tab[i].equals("id")&&tab[i+1].equals(":=")){
		aff();
		
	}else if (tab[i].equals("id")&&tab[i+1].equals("opl")){
		//comparer
	}
		
		
	}
	public static void main(String[] args) {
	Scanner sc=null;
	String line;
	
	try {
		sc = new Scanner (new File ("C:\\Users\\abdou\\Desktop\\temp.txt"));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
	try {
		p= new PrintWriter (new File ("C:\\Users\\abdou\\Desktop\\regle.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	line = sc.nextLine();
	tab=line.split(" ");
	
	programme();
	
	p.close();
	
	
	
	}

}
