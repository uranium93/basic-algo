package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lex2015 {

	public static void main(String[] args) {
	
		String [] tab = null ;
		String [] tab1=null;
		String [] tabs=null;
		Scanner sc=null;
		String c = "";
		
		try {
			sc = new Scanner (new File ("C:\\Users\\abdou\\Desktop\\in.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
     	PrintWriter p=null;
		try {
			 p = new PrintWriter (new File ("C:\\Users\\abdou\\Desktop\\jeton.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		PrintWriter q=null;
		try {
			 q = new PrintWriter (new File ("C:\\Users\\abdou\\Desktop\\temp.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line;
		
		while (sc.hasNextLine()){
			line = sc.nextLine();
			tab=line.split(" ");	
			for(int i=0; i<tab.length;i++){
				switch(tab[i]){
				case "programme":
					p.println("(programme,mc)");
					q.print("programme ");
					break;
				case "const":
					p.println("(const,mc)");
					q.print("const ");
					break;
				case "var":
					p.println("(var,mc)");
					q.print("var ");
					break;
				case "debut":
					p.println("(debut,mc)");
					q.print("debut ");
					break;
				case "fin":
					p.println("(fin,mc)");
					q.print("fin ");
					break;
				case ("fin;"):
					p.println("(fin,mc)");
					q.print("fin ");
					p.println("(;,cs)");
					q.print("; ");
					break;
				case ("fin."):
					p.println("(fin,mc");
					q.print("fin ");
					p.println("(.,cs)");
					q.print(". ");
					break;
				case "si":
					p.println("(si,mc)");
					q.print("si ");
					break;
				case "alors":
					p.println("(alors,mc)");
					q.print("alors ");
					break;
				case"sinon":
					p.println("(sinon,mc)");
					q.print("sinon ");
					break;
				case "tantque":
					p.println("(tantque,mc)");
					q.print("tantque ");
					break;
				case "faire":
					p.println("(faire,mc)");
					q.print("faire ");
					break;
				case "ou":
					p.println("(ou,mc)");
					q.print("ou ");
					break;
				case "et":
					p.println("(et,mc)");
					q.print("et ");
					break;
				case "entier":
					p.println("(entier,mc)");
					q.print("entier ");
					break;
				case "réel":
					p.println("(réel,mc)");
					q.print("réel ");
					break;
				case "=":
					p.println("(=,cs)");
					q.print("opl ");
					break;
				case "<":
					p.println("(<,cs)");
					q.print("opl ");
					break;
				case ">":
					p.println("(>,cs)");
					q.print("opl ");
					break;
				case ":=":
					p.println("(:=,cs)");
					q.print(":= ");
					break;
				case "=>":
					p.println("(=>,cs)");
					q.print("opl ");
					break;
				case "=<":
					p.println("(=<,cs)");
					q.print("opl ");
					break;
				case "<>":
					p.println("(<>,cs)");
					q.print("opl ");
					break;
				case "==":
					p.println("(==,cs)");
					q.print("opl ");
					break;
				case "+":
					p.println("(+,cs)");
					q.print("opa ");
					break;
				case "*":
					p.println("(*,cs)");
					q.print("opa ");
					break;
				case "/":
					p.println("(/,cs)");
					q.print("opa ");
					break;
				default :
					
						tab1=tab[i].split("");	
						for(int y=0; y<tab1.length;y++){

						switch(tab1[y]){
						case "<":
							if(tab1[y+1].equals("=")){
								p.println( ("(<=,cs)"));
								q.print("opl ");
								y=y+1;
							}else if (tab1[y+1].equals(">")){
								p.println("(<>,cs)");
								q.print("opl ");
								
								y=y+1;
							}
							else {
								p.println("(<,cs)");
								q.print("opl ");
							
							}
							break;
						case ">":
							if(tab1[y+1].equals("=")){
								p.println(("(>=,cs)"));
								q.print("opl ");
								
								y=y+1;
							}else {
								p.println("(>,cs)");
								q.print("opl ");
								
							}
							break;
						case "=":
							p.println("(=,cs)");
							q.print("opl ");
							
							break;
						case ":":
								if (i<tab.length-1){
									if (tab[i+1].equals("=")){
										p.println("(:=,cs)");
										q.print(":= ");
										y=y+1;
									}
								}
								else{
								p.println("(:,cs)");
								q.print(": ");
								}
							break;
						case ";":
							p.println("(;,cs)");
							q.print("; ");
							break;
						case ",":
							p.println("(,,cs)");
							q.print(", ");
						break;
						case " ":
							break;
						case "(":
							p.println("((,cs)");
							q.print("( ");
							break;
						case ")":
							p.println("(),cs)");
							q.print(") ");
							break;
						case "+":
							p.println("(+,cs)");
							q.print("opa ");
							break;
						case "-":
							p.println("(-,cs)");
							q.print("opa ");
							break;
						case "*":
							p.println("(*,cs)");
							q.print("opa ");
							break;
						case "/":
							p.println("(/,cs)");
							q.print("opa ");
							break;
						case "e":if(y+5<=tab1.length)
							switch (tab1[y+1]){
							case "n":
								if (tab1[y+2].equals("t")){
									if (tab1[y+3].equals("i")){
										if (tab1[y+4].equals("e")){
											if (tab1[y+5].equals("r")){
												p.println("(entier,cs)");
												q.print("entier ");
												y=y+5;
											}
										}
									}
								}
								break;
						}else{
							c=c+"e";
						}
							break;
						case "r":
							if(y+3<=tab1.length){
							if (tab1[y+1].equals("é")){
								if (tab1[y+2].equals("e")){
									if (tab1[y+3].equals("l")){
										p.println("(réel,cs)");
										q.print("réel ");
										y=y+3;
									}
								}
							}
							}else{
								c=c+"r";
							}
							break;
						default:
							c=c+tab1[y];
							if ((y+1)<tab1.length){
							if (tab1[y+1].equals(",")||tab1[y+1].equals(".")||tab1[y+1].equals(";")||tab1[y+1].equals(" ")||tab1[y+1].equals("<")||tab1[y+1].equals(">")||tab1[y+1].equals("=")||tab1[y+1].equals(" ")||tab1[y+1].equals("+")||tab1[y+1].equals("-")||tab1[y+1].equals("*")||tab1[y+1].equals("/")||tab1[y+1].equals(":")||tab1[y+1].equals("(")||tab1[y+1].equals(")")){
							if (c.matches("[0-9]+")){
								p.println("("+c+",number)");
								q.print("num ");
								c="";
							}else if (c.matches("[a-zA-Z]+([0-9]*[a-zA-Z]*)*")){
									p.println("("+c+",id");	
									q.print("id ");
									c="";
								}
							else   {
								p.println("("+c+",erreur)");
								c="";
								
							}
							}
							
								
								
							}else{
								if (c.matches("[0-9]+")){
									p.println("("+c+",number)");
									q.print("num ");
									c="";
								}else if (c.matches("[a-zA-Z]+([0-9]*[a-zA-Z]*)*")){
									p.println("("+c+",id");	
									q.print("id ");
									c="";
								}
							else   {
								p.println("("+c+",erreur)");
								c="";
								
							}
								
							}
							break;
						
						
						
						
						}//fin switch
						}//fin for
						
						
					
					
				}	
				}
		}
		p.close();
		q.close();
		
		
	}
}

