package hanafi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class tp_cs {

	public static void main(String[] args) {
		String [] tab = null ;
		Scanner sc=null;
		try {
			sc = new Scanner (new File ("C:\\Users\\abdou\\Desktop\\in.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
     	PrintWriter p=null;
		try {
			p = new PrintWriter (new File ("C:\\Users\\abdou\\Desktop\\out.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		String line;
		while (sc.hasNextLine()){
			line = sc.nextLine();
			tab=line.split("");
		//boucle de saisir les lettres en tableau	 
	    for (int i=0;i<(tab.length) ;i++){//boucle pour trouver les cs
		switch(tab[i]){
		case "<":
			switch (tab[i+1]){
			case "=":
				p.println("(<=,cs)");
			i=i+1;
			break;
			default: p.println("(<, cs)");
			}
			break;
		case ">":
			switch (tab[i+1]){
			case ("=") :
				p.println("(>=,cs)");
			i=i+1;
			break;
			default : p.println("(>, cs)");
			}
			break;
		case "=":
			switch(tab[i+1]){
			case ("!"):
				p.println("(=!,cs)");
			i=i+1;
			break;
			default:
			p.println("(=, cs)");
			}
		case "b":
			switch (tab[i+1]){
			case "e":
			switch (tab[i+2]){
			case "g":
				switch (tab[i+3]){
				case "i":
					switch (tab[i+4]){
					case "n":
						switch (tab[i+5]){
						case " ":
						p.println("(begin,mc)");
						}
					}
				}
			}
			}
			break;
		case "i":
			switch (tab[i+1]){
			case "f":
				switch (tab[i+2]){
				case " ":
					p.println("(if,mc)");
				}
			}
			break;
		case "e":
			switch (tab[i+1]){
			case "l":
				switch (tab[i+2]){
				case "s":
					switch (tab[i+3]){
					case "e":
						p.println("(else,mc)");
					}
				}
			}
			break;
		}
	}
}
        
	
p.close();

	}

}
