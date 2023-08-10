package Practica;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Practica {
	
	static char let;
	static char let2;
	static Scanner sc = new Scanner(System.in);
	//MATRICES ENTRADAS POR CONSOLA
	static double matrizA[][];
	static double matrizB[][];
	//MATRIZ DE LETRAS
	static double mCadena[][];
	//MATRICES DE ENCRIPTAR
	static double mM[][];
	static double mS[][];
	//MATRICES DE DESENCRIPTAR
	static double mM2[][];
	static double mR[][];
	static double mT[][];
	
	public static void main(String[] args) {
		menu();		
	}
	

	
	public static void prueba2() {
	
	System.out.print("Ingrese una cadena de texto: ");
	String cadena = sc.nextLine();
	System.out.println("");
	
	
	//VALIDAR SI EL TAMAÑO ES MULTIPLO DE 3 ============================================================
	if(cadena.length()%3 != 0) {
		String espacio=" ";
		System.out.println("El largo no es multiplo de 3: " +cadena.length());
		while(cadena.length()%3 != 0) {
			cadena += espacio;
		}
		System.out.println("Nuevo tamaño: " +cadena.length());
			
	}else{
		System.out.println("El largo de la cadena es multiplo de 3: "+ cadena.length());
	}	
	System.out.println("");
	
	String[] cTam = new String[cadena.length()];
	
	
	//CAMBIO DE LETRAS POR NUMEROS ============================================================
	for(int i=0; i<cadena.length(); i++) {
		let = cadena.charAt(i);
		cTam[i]=Character.toString(let);

	switch(cTam[i].charAt(0)) {
		case 'a':
			cTam[i] = "0";	
			break;
		case 'A':
			cTam[i] ="0";
			break;
		case 'b':							
			cTam[i] = "1";;
			break;
		case 'B':
			cTam[i] = "1";
			break;
		case 'c':
			cTam[i] = "2";
		case 'C':
			cTam[i] = "2";
			break;
		case 'd':
			cTam[i] = "3";
			break;
		case 'D':
			cTam[i] = "3";
		case 'e':
			cTam[i] = "4";
			break;
		case 'E':
			cTam[i] = "4";
			break;
		case 'f':
			cTam[i] = "5";
			break;
		case 'F':
			cTam[i] = "5";
			break;
		case 'g':
			cTam[i] = "6";
			break;
		case 'G':
			cTam[i] = "6";
			break;
		case'h':
			cTam[i] = "7";
			break;
		case 'H':
			cTam[i] = "7";
			break;
		case 'i':
			cTam[i] = "8";
			break;
		case 'I':
			cTam[i] = "8";
			break;
		case 'j':
			cTam[i] = "9";
			break;
		case 'J':
			cTam[i] = "9";
			break;
		case 'k':
			cTam[i] = "10";
			break;
		case 'K':
			cTam[i] = "10";
			break;
		case 'l':
			cTam[i] = "11";
			break;
		case 'L':
			cTam[i] = "11";
			break;
		case 'm':
			cTam[i] = "12";
			break;
		case 'M':
			cTam[i] = "12";
			break;
		case 'n':
			cTam[i] = "13";
			break;
		case 'N':
			cTam[i] = "13";
			break;
		case 'ñ':
			cTam[i] = "14";
			break;
		case 'Ñ':
			cTam[i] = "14";
			break;
		case 'o':
			cTam[i] = "15";
			break;
		case 'O':
			cTam[i] = "15";	
			break;
		case 'p':
			cTam[i] ="16";
			break;
		case 'P':							
			cTam[i] = "16";;
			break;
		case 'q':
			cTam[i] = "17";
			break;
		case 'Q':
			cTam[i] = "17";
		case 'r':
			cTam[i] = "18";
			break;
		case 'R':
			cTam[i] = "18";
			break;
		case 's':
			cTam[i] = "19";
		case 'S':
			cTam[i] = "19";
			break;
		case 't':
			cTam[i] = "20";
			break;
		case 'T':
			cTam[i] = "20";
			break;
		case 'u':
			cTam[i] = "21";
			break;
		case 'U':
			cTam[i] = "21";
			break;
		case 'v':
			cTam[i] = "22";
			break;
		case'V':
			cTam[i] = "22";
			break;
		case 'w':
			cTam[i] = "23";
			break;
		case 'W':
			cTam[i] = "23";
			break;
		case 'x':
			cTam[i] = "24";
			break;
		case 'X':
			cTam[i] = "24";
			break;
		case 'y':
			cTam[i] = "25";
			break;
		case 'Y':
			cTam[i] = "25";
			break;
		case 'z':
			cTam[i] = "26";
			break;
		case 'Z':
			cTam[i] = "26";
			break;
		case ' ':
			cTam[i] = "27";
			break;
		default:
			cTam[i] = "27";
			break;	
		}	
	}
	
	
	//DE VECTOR A MATRIZ CON LETRAS CAMBIADAS ============================================================
	int col = cadena.length()/3;
	mCadena= new double [3][col];
	
	int aux1=0;
	for(int i=0; i<col; i++) {
		for(int j=0; j<3; j++) {
			mCadena[j][i] = Double.parseDouble(cTam[aux1++]);
		}
	}
		
	for(int i=0; i<3; i++) {
		for(int j=0; j<col; j++) {		
			System.out.print("["+mCadena[i][j]+"]");
		}
		System.out.println(" ");
	}
	
	System.out.println("");
	System.out.println("");
	
	
	//INGRESAR MATRIZ "A" POR CONSOLA ============================================================
	try {
    System.out.print("Ingrese ruta de la MATRIZ A: ");
    String ruta = sc.next();
    File archivo = new File(ruta);
    Scanner reader = new Scanner(archivo);
    String data="";
    while(reader.hasNextLine()) {
            data += reader.nextLine()+"\n";
        }
	
    String filas [] = data.split("\n");
	
    String aux[]=filas[0].split(",");
	
    matrizA = new double[filas.length][aux.length];
	
        for(int i =0; i<filas.length;i++) {
            aux=filas[i].split(",");
                for(int j=0;j<aux.length;j++) {
                    matrizA[i][j]=Double.parseDouble(aux[j]);
                }
        }

	System.out.println("");		
	System.out.println("La MATRIZ A es:");
	for(int i=0; i<filas.length; i++) {
		for(int j=0; j<aux.length; j++) {
			System.out.print("["+matrizA[i][j]+"]");
		}
		System.out.println("");
	}
	
	
	//INGRESAR MATRIZ "B" POR CONSOLA ============================================================
    System.out.println("");
	System.out.print("Ingrese ruta de la MATRIZ B: ");
    String ruta1 = sc.next();
    File archivo1 = new File(ruta1);
    Scanner reader1 = new Scanner(archivo1);
    String data1="";
        while(reader1.hasNextLine()) {
            data1 += reader1.nextLine()+"\n";
        }
	
    String filas1 [] = data1.split("\n");
	
    String ax1[]=filas1[0].split(",");
	
    matrizB = new double[filas1.length][ax1.length];
	
        for(int i =0; i<filas1.length;i++) {
            ax1=filas1[i].split(",");
                for(int j=0;j<ax1.length;j++) {
                    matrizB[i][j]=Double.parseDouble(ax1[j]);
                }     
        }
       
    System.out.println("");		
    System.out.println("La MATRIZ B es:");
    for(int i=0; i<filas.length; i++) {
    	for(int j=0; j<ax1.length; j++) {
    			System.out.print("["+matrizB[i][j]+"]");
    	}
    		System.out.println("");
    }
    
	
	//MULTIPLICAR MATRICES A*M ============================================================
	int fl=filas.length;
	int cl=col;
	mM= new double [fl][cl];
	
    for(int i=0;i<filas.length;i++){
    	for(int j=0;j<col;j++){
    			for(int h=0;h<aux.length;h++){
    				mM[i][j]+=matrizA[i][h]*mCadena[h][j];
    			}
    	}
    }
    
    System.out.println("");
    System.out.println("La MATRIZ A*M es:");
	for(int i=0; i<fl; i++) {
		for(int j=0; j<cl; j++) {
			System.out.print("["+mM[i][j]+"]");
		}
		System.out.println("");
	}
	
	

	//SUMAR MATRICES MATRICES (A*M)+B ============================================================
	int flm=filas.length;
	int clm=col;
	mS= new double [flm][clm];
	
    for (int i = 0; i < mM.length; i++) {
        for (int j = 0; j < mM[0].length; j++) {
            mS[i][j]= mM[i][j] + matrizB[i][j];
        }
    }
	
    System.out.println("");
    System.out.println("La MATRIZ ENCRIPTADA es:");
	for(int i=0; i<flm; i++) {
		for(int j=0; j<clm; j++) {
			System.out.print("["+Math.round(mS[i][j])+"]");
		}
		System.out.println("");
	}
	
	System.out.println("");
	
	
	//INVERSA MATRIZ A ============================================================
	double dC11 = ((-1)*(-1))*((matrizA [1][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[1][2]));
	double dC21 = ((-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[0][2]));
	double dC31 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[1][2])-(matrizA[1][1])*(matrizA[0][2]));
	//DETERMINANTE
	double detMA =matrizA[0][0]*(dC11)+matrizA[1][0]*(dC21)+matrizA[2][0]*(dC31);
	
	System.out.println("");
	if(detMA != 0) {
		System.out.println("El determinante de MATRIZ A es: " + detMA);

		double dC12 = ((-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[1][2]));
		double dC22 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[0][2]));
		double dC32 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][2])-(matrizA[1][0])*(matrizA[0][2]));
		double dC13 = ((-1)*(-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[1][1]));
		double dC23 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[0][1]));
		double dC33 = ((-1)*(-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][1])-(matrizA[1][0])*(matrizA[0][1]));
		
		//MATRIZ INVERSA
		double [][]cf =new double [3][3];
		cf[0][0]=dC11/detMA;	cf[0][1]=dC12/detMA;	cf[0][2]=dC13/detMA;
		cf[1][0]=dC21/detMA;	cf[1][1]=dC22/detMA;	cf[1][2]=dC23/detMA;
		cf[2][0]=dC31/detMA;	cf[2][1]=dC32/detMA;	cf[2][2]=dC33/detMA;
		
		
		mT = new double [3][3];
		
		for(int i=0; i<cf.length; i++) {
			for(int j=0; j<cf[0].length; j++) {
				mT[j][i]=cf[i][j];
			}
		}
		
		System.out.println("");
		System.out.println("La MATRIZ INVERSA A es:");
		for(int i=0; i<mT.length; i++) {
			for(int j=0; j<mT.length; j++) {
				System.out.print("["+mT[i][j]+"]");
			}
			System.out.println("");
		}	
		
	}else {
		System.out.println("No tiene inversa, el determinante es: " + detMA);
	}
	
	
	
	//RESTA MATRICES (C - B) ============================================================
	int flm3=filas.length;
	int clm3=col;
	mR= new double [flm3][clm];
	
    for (int i = 0; i < mS.length; i++) {
        for (int j = 0; j < mS[0].length; j++) {
            mR[i][j]= mS[i][j] - matrizB[i][j];
        }
    }
	
    System.out.println("");
    System.out.println("La MATRIZ (C-B) es:");
	for(int i=0; i<flm3; i++) {
		for(int j=0; j<clm3; j++) {
			System.out.print("["+mR[i][j]+"]");
		}
		System.out.println("");
	}
	
	
	//MULTIPLICAR MATRICES (C-B)*(A^-1) ============================================================
	int fl2=filas.length;
	int cl2=col;
	mM2= new double [fl2][cl2];
	
    for(int i=0;i<filas.length;i++){
    	for(int j=0;j<col;j++){
    			for(int h=0;h<aux.length;h++){
    				mM2[i][j]+=mT[i][h]*mR[h][j];
    			}
    	}
    }
    
    System.out.println("");
    System.out.println("La MATRIZ DESENCRIPTADA es:");
	for(int i=0; i<fl2; i++) {
		for(int j=0; j<cl2; j++) {
			System.out.print("["+Math.round(mM2[i][j])+"]");
		}
		System.out.println("");
	}
	
	
	//MATRIZ A VECTOR ============================================================
	int []vn = new int[cadena.length()];
	int co=0;
	for(int i = 0; i<cl2; i++) {
	    for(int j = 0; j < fl2; j++) {
	            vn[co] = (int)Math.round(mM2[j][i]); 
	            co++;
	    }
	}
	
	String[] v = new String[vn.length];
	int cont=0;
	for(int i = 0; i<vn.length; i++) {
	    v[cont] = String.valueOf(vn[i]); 
	    cont++; 
	}

	
	//NUMEROS A LETRAS ============================================================
	for(int i=0; i<cadena.length(); i++) {

	switch(v[i]) {
		case "0":
			v[i] = "a";	
			break;
		case "1":
			v[i] ="b";
			break;
		case "2":							
			v[i] = "c";;
			break;
		case "3":
			v[i] = "d";
			break;
		case "4":
			v[i] = "e";
			break;
		case "5":
			v[i] = "f";
			break;
		case "6":
			v[i] = "g";
			break;
		case "7":
			v[i] = "h";
			break;
		case "8":
			v[i] = "i";
			break;
		case "9":
			v[i] = "j";
			break;
		case "10":
			v[i] = "k";
			break;
		case "11":
			v[i] = "l";
			break;
		case "12":
			v[i] = "m";
			break;
		case "13":
			v[i] = "n";
			break;
		case "14":
			v[i] = "ñ";
			break;
		case "15":
			v[i] = "o";
			break;
		case "16":
			v[i] = "p";
			break;
		case "17":
			v[i] = "q";
			break;
		case "18":
			v[i] = "r";
			break;
		case "19":
			v[i] = "s";
			break;
		case "20":
			v[i] = "t";
			break;
		case "21":
			v[i] = "u";
			break;
		case "22":
			v[i] = "v";
			break;
		case "23":
			v[i] = "w";
			break;
		case "24":
			v[i] = "x";
			break;
		case "25":
			v[i] = "y";
			break;
		case "26":
			v[i] = "z";
			break;
		case "27":
			v[i] = " ";
			break;
		}	
	}
	
	System.out.println("");
	System.out.println("");
	System.out.print("Texto descifrado: ");
	for(int i=0; i<v.length; i++) {
		System.out.print(v[i]);
	}
	
	System.out.println("");

	reader.close();
	reader1.close();
	
	}catch(Exception e){
		System.out.println("Error: " +e);
	}
	
	
}

	public static void inversaM() {
	
	try {
		//CARGA DE MATRIZ
        System.out.print("Ingrese ruta de la MATRIZ A: ");
        String ruta = sc.next();
        File archivo = new File(ruta);
        Scanner reader = new Scanner(archivo);
        String data="";
	while(reader.hasNextLine()) {
                data += reader.nextLine()+"\n";
            }
		
        String filas [] = data.split("\n");
		
        String aux[]=filas[0].split(",");
		
        matrizA = new double[filas.length][aux.length];
		
            for(int i =0; i<filas.length;i++) {
                aux=filas[i].split(",");
                    for(int j=0;j<aux.length;j++) {
                        matrizA[i][j]=Double.parseDouble(aux[j]);
		}
	}

		System.out.println("");		
		System.out.println("La MATRIZ A es:");
		for(int i=0; i<matrizA.length; i++) {
			for(int j=0; j<matrizA.length; j++) {
				System.out.print("["+matrizA[i][j]+"]");
			}
			System.out.println("");
		}
		
		System.out.println("");
		
		double dC11 = ((-1)*(-1))*((matrizA [1][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[1][2]));
		double dC21 = ((-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[0][2]));
		double dC31 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[1][2])-(matrizA[1][1])*(matrizA[0][2]));
		//DETERMINANTE
		double detMA =matrizA[0][0]*(dC11)+matrizA[1][0]*(dC21)+matrizA[2][0]*(dC31);
		
		if(detMA != 0) {
			System.out.println("El determinante es: " + detMA);
			System.out.println("");

			double dC12 = ((-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[1][2]));
			double dC22 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[0][2]));
			double dC32 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][2])-(matrizA[1][0])*(matrizA[0][2]));
			double dC13 = ((-1)*(-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[1][1]));
			double dC23 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[0][1]));
			double dC33 = ((-1)*(-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][1])-(matrizA[1][0])*(matrizA[0][1]));
			
			//MATRIZ INVERSA
			double [][]cf =new double [3][3];
			cf[0][0]=dC11/detMA;	cf[0][1]=dC12/detMA;	cf[0][2]=dC13/detMA;
			cf[1][0]=dC21/detMA;	cf[1][1]=dC22/detMA;	cf[1][2]=dC23/detMA;
			cf[2][0]=dC31/detMA;	cf[2][1]=dC32/detMA;	cf[2][2]=dC33/detMA;
			
			System.out.println("La matriz inversa es:");
			for(int i=0; i<cf.length; i++) {
				for(int j=0; j<cf.length; j++) {
					System.out.print("["+cf[j][i]+"]");
				}
				System.out.println("");
			}	
			
		}else {
			System.out.println("No tiene inversa");
			System.out.println("El determinante es: " + detMA);
		}
		
		reader.close();
		
	}catch(Exception e){
		System.out.println("Error: " + e);
	}
		
		
	}
	
	
	//=====================================================
	//MENU PRINCIPAL
	public static void menu() {	
	boolean salida=false;
	int op=0;
	System.out.println("------------------------MENU------------------------");
		while(salida==false) {
			System.out.println("1. Encriptar");
			System.out.println("2. Desencriptar");
			System.out.println("3. Ataque con texto claro");
			System.out.println("4. Generar reportes");
			System.out.println("5. Salida");
			System.out.println("");
			System.out.print("Seleccione una opcion: ");
			op=sc.nextInt();
			String salto=sc.nextLine();
			
			switch(op) {
			case 1:
				encriptar();
				System.out.println("");
				break;
			
			case 2:
				desencriptar();
				System.out.println("");
				break;
				
			case 3:
				ataque();
				System.out.println("");
				break;
				
			case 4:
				reporte();
				System.out.println("");
				break;
				
			case 5:
				System.out.println("");
				System.out.println("SALIDA");
				salida=true;
				break;
			}	
			
		}
	}
	
	
	//=====================================================
	//MENU ENCRIPTAR
	public static void encriptar() {
		System.out.println("");
		System.out.println("------------------------ENCRIPTAR------------------------");
		try {
			
			System.out.print("Ingrese una cadena de texto: ");
			String cadena = sc.nextLine();
			System.out.println("");
			
			
			//VALIDAR SI EL TAMAÑO ES MULTIPLO DE 3 ============================================================
			if(cadena.length()%3 != 0) {
				String espacio=" ";
				while(cadena.length()%3 != 0) {
					cadena += espacio;
				}	
			}else{
				
			}	
			System.out.println("");
			
			String[] cTam = new String[cadena.length()];
			
			
			//CAMBIO DE LETRAS POR NUMEROS ============================================================
			for(int i=0; i<cadena.length(); i++) {
				let = cadena.charAt(i);
				cTam[i]=Character.toString(let);

			switch(cTam[i].charAt(0)) {
				case 'a':
					cTam[i] = "0";	
					break;
				case 'A':
					cTam[i] ="0";
					break;
				case 'b':							
					cTam[i] = "1";;
					break;
				case 'B':
					cTam[i] = "1";
					break;
				case 'c':
					cTam[i] = "2";
				case 'C':
					cTam[i] = "2";
					break;
				case 'd':
					cTam[i] = "3";
					break;
				case 'D':
					cTam[i] = "3";
				case 'e':
					cTam[i] = "4";
					break;
				case 'E':
					cTam[i] = "4";
					break;
				case 'f':
					cTam[i] = "5";
					break;
				case 'F':
					cTam[i] = "5";
					break;
				case 'g':
					cTam[i] = "6";
					break;
				case 'G':
					cTam[i] = "6";
					break;
				case'h':
					cTam[i] = "7";
					break;
				case 'H':
					cTam[i] = "7";
					break;
				case 'i':
					cTam[i] = "8";
					break;
				case 'I':
					cTam[i] = "8";
					break;
				case 'j':
					cTam[i] = "9";
					break;
				case 'J':
					cTam[i] = "9";
					break;
				case 'k':
					cTam[i] = "10";
					break;
				case 'K':
					cTam[i] = "10";
					break;
				case 'l':
					cTam[i] = "11";
					break;
				case 'L':
					cTam[i] = "11";
					break;
				case 'm':
					cTam[i] = "12";
					break;
				case 'M':
					cTam[i] = "12";
					break;
				case 'n':
					cTam[i] = "13";
					break;
				case 'N':
					cTam[i] = "13";
					break;
				case 'ñ':
					cTam[i] = "14";
					break;
				case 'Ñ':
					cTam[i] = "14";
					break;
				case 'o':
					cTam[i] = "15";
					break;
				case 'O':
					cTam[i] = "15";	
					break;
				case 'p':
					cTam[i] ="16";
					break;
				case 'P':							
					cTam[i] = "16";;
					break;
				case 'q':
					cTam[i] = "17";
					break;
				case 'Q':
					cTam[i] = "17";
				case 'r':
					cTam[i] = "18";
					break;
				case 'R':
					cTam[i] = "18";
					break;
				case 's':
					cTam[i] = "19";
				case 'S':
					cTam[i] = "19";
					break;
				case 't':
					cTam[i] = "20";
					break;
				case 'T':
					cTam[i] = "20";
					break;
				case 'u':
					cTam[i] = "21";
					break;
				case 'U':
					cTam[i] = "21";
					break;
				case 'v':
					cTam[i] = "22";
					break;
				case'V':
					cTam[i] = "22";
					break;
				case 'w':
					cTam[i] = "23";
					break;
				case 'W':
					cTam[i] = "23";
					break;
				case 'x':
					cTam[i] = "24";
					break;
				case 'X':
					cTam[i] = "24";
					break;
				case 'y':
					cTam[i] = "25";
					break;
				case 'Y':
					cTam[i] = "25";
					break;
				case 'z':
					cTam[i] = "26";
					break;
				case 'Z':
					cTam[i] = "26";
					break;
				case ' ':
					cTam[i] = "27";
					break;
				default:
					cTam[i] = "27";
					break;	
				}	
			}
			
			
			//DE VECTOR A MATRIZ CON LETRAS CAMBIADAS ============================================================
			int col = cadena.length()/3;
			mCadena= new double [3][col];
			
			int aux1=0;
			for(int i=0; i<col; i++) {
				for(int j=0; j<3; j++) {
					mCadena[j][i] = Double.parseDouble(cTam[aux1++]);
				}
			}

			
			//INGRESAR MATRIZ "A" POR CONSOLA ============================================================
		    System.out.print("Ingrese ruta de la MATRIZ A: ");
		    String ruta = sc.next();
		    File archivo = new File(ruta);
		    Scanner reader = new Scanner(archivo);
		    String data="";
		    while(reader.hasNextLine()) {
		            data += reader.nextLine()+"\n";
		        }
			
		    String filas [] = data.split("\n");
			
		    String aux[]=filas[0].split(",");
			
		    matrizA = new double[filas.length][aux.length];
			
		        for(int i =0; i<filas.length;i++) {
		            aux=filas[i].split(",");
		                for(int j=0;j<aux.length;j++) {
		                    matrizA[i][j]=Double.parseDouble(aux[j]);
		                }
		        }

		        
			//INGRESAR MATRIZ "B" POR CONSOLA ============================================================
		    System.out.println("");
			System.out.print("Ingrese ruta de la MATRIZ B: ");
		    String ruta1 = sc.next();
		    File archivo1 = new File(ruta1);
		    Scanner reader1 = new Scanner(archivo1);
		    String data1="";
		        while(reader1.hasNextLine()) {
		            data1 += reader1.nextLine()+"\n";
		        }
			
		    String filas1 [] = data1.split("\n");
			
		    String ax1[]=filas1[0].split(",");
			
		    matrizB = new double[filas1.length][ax1.length];
			
		        for(int i =0; i<filas1.length;i++) {
		            ax1=filas1[i].split(",");
		                for(int j=0;j<ax1.length;j++) {
		                    matrizB[i][j]=Double.parseDouble(ax1[j]);
		                }     
		        }
		       
		        
			//MULTIPLICAR MATRICES A*M ============================================================
			int fl=filas.length;
			int cl=col;
			mM= new double [fl][cl];
			
		    for(int i=0;i<filas.length;i++){
		    	for(int j=0;j<col;j++){
		    			for(int h=0;h<aux.length;h++){
		    				mM[i][j]+=matrizA[i][h]*mCadena[h][j];
		    			}
		    	}
		    }
		    
		    
			//SUMAR MATRICES MATRICES (A*M)+B || MATRIZ ENCRIPTADA  ============================================================
			int flm=filas.length;
			int clm=col;
			mS= new double [flm][clm];
			
		    for (int i = 0; i < mM.length; i++) {
		        for (int j = 0; j < mM[0].length; j++) {
		            mS[i][j]= mM[i][j] + matrizB[i][j];
		        }
		    }
			
		    
			//MATRIZ A VECTOR PARA MOSTRAR 
			int []vn1 = new int[cadena.length()];
			int co1=0;
			for(int i = 0; i<clm; i++) {
			    for(int j = 0; j < flm; j++) {
			            vn1[co1] = (int)Math.round(mS[j][i]); 
			            co1++;
			    }
			}
			
			System.out.println("");
			System.out.println("MENSAJE ENCRIPTADO: ");
			for(int i=0; i<vn1.length; i++){
				System.out.print(vn1[i]+" ");
			}
			
			System.out.println("");
			System.out.println("");
			
			reader.close();
			reader1.close();
			
		}catch(Exception e) {
			System.out.println("Error: " +e);
		}
		
	}

	
	//=====================================================
	//DESENCRIPTAR
	public static void desencriptar() {
		System.out.println("");
		System.out.println("------------------------DESENCRIPTAR------------------------");
		try {
			

			System.out.print("Ingrese una cadena de texto: ");
			String cadena = sc.nextLine();
			System.out.println("");
			
			
			//VALIDAR SI EL TAMAÑO ES MULTIPLO DE 3 ============================================================
			if(cadena.length()%3 != 0) {
				String espacio=" ";

				while(cadena.length()%3 != 0) {
					cadena += espacio;
				}
					
			}else{
				
			}	
			System.out.println("");
			
			String[] cTam = new String[cadena.length()];
			
			
			//CAMBIO DE LETRAS POR NUMEROS ============================================================
			for(int i=0; i<cadena.length(); i++) {
				let = cadena.charAt(i);
				cTam[i]=Character.toString(let);

			switch(cTam[i].charAt(0)) {
				case 'a':
					cTam[i] = "0";	
					break;
				case 'A':
					cTam[i] ="0";
					break;
				case 'b':							
					cTam[i] = "1";;
					break;
				case 'B':
					cTam[i] = "1";
					break;
				case 'c':
					cTam[i] = "2";
					break;
				case 'C':
					cTam[i] = "2";
					break;
				case 'd':
					cTam[i] = "3";
					break;
				case 'D':
					cTam[i] = "3";
					break;
				case 'e':
					cTam[i] = "4";
					break;
				case 'E':
					cTam[i] = "4";
					break;
				case 'f':
					cTam[i] = "5";
					break;
				case 'F':
					cTam[i] = "5";
					break;
				case 'g':
					cTam[i] = "6";
					break;
				case 'G':
					cTam[i] = "6";
					break;
				case'h':
					cTam[i] = "7";
					break;
				case 'H':
					cTam[i] = "7";
					break;
				case 'i':
					cTam[i] = "8";
					break;
				case 'I':
					cTam[i] = "8";
					break;
				case 'j':
					cTam[i] = "9";
					break;
				case 'J':
					cTam[i] = "9";
					break;
				case 'k':
					cTam[i] = "10";
					break;
				case 'K':
					cTam[i] = "10";
					break;
				case 'l':
					cTam[i] = "11";
					break;
				case 'L':
					cTam[i] = "11";
					break;
				case 'm':
					cTam[i] = "12";
					break;
				case 'M':
					cTam[i] = "12";
					break;
				case 'n':
					cTam[i] = "13";
					break;
				case 'N':
					cTam[i] = "13";
					break;
				case 'ñ':
					cTam[i] = "14";
					break;
				case 'Ñ':
					cTam[i] = "14";
					break;
				case 'o':
					cTam[i] = "15";
					break;
				case 'O':
					cTam[i] = "15";	
					break;
				case 'p':
					cTam[i] ="16";
					break;
				case 'P':							
					cTam[i] = "16";;
					break;
				case 'q':
					cTam[i] = "17";
					break;
				case 'Q':
					cTam[i] = "17";
					break;
				case 'r':
					cTam[i] = "18";
					break;
				case 'R':
					cTam[i] = "18";
					break;
				case 's':
					cTam[i] = "19";
					break;
				case 'S':
					cTam[i] = "19";
					break;
				case 't':
					cTam[i] = "20";
					break;
				case 'T':
					cTam[i] = "20";
					break;
				case 'u':
					cTam[i] = "21";
					break;
				case 'U':
					cTam[i] = "21";
					break;
				case 'v':
					cTam[i] = "22";
					break;
				case'V':
					cTam[i] = "22";
					break;
				case 'w':
					cTam[i] = "23";
					break;
				case 'W':
					cTam[i] = "23";
					break;
				case 'x':
					cTam[i] = "24";
					break;
				case 'X':
					cTam[i] = "24";
					break;
				case 'y':
					cTam[i] = "25";
					break;
				case 'Y':
					cTam[i] = "25";
					break;
				case 'z':
					cTam[i] = "26";
					break;
				case 'Z':
					cTam[i] = "26";
					break;
				case ' ':
					cTam[i] = "27";
					break;
				default:
					cTam[i] = "27";
					break;	
				}	
			}
			
			
			//DE VECTOR A MATRIZ CON LETRAS CAMBIADAS ============================================================
			int col = cadena.length()/3;
			mCadena= new double [3][col];
			
			int aux1=0;
			for(int i=0; i<col; i++) {
				for(int j=0; j<3; j++) {
					mCadena[j][i] = Double.parseDouble(cTam[aux1++]);
				}
			}
				
			
			//INGRESAR MATRIZ "A" POR CONSOLA ============================================================
		    System.out.print("Ingrese ruta de la MATRIZ A: ");
		    String ruta = sc.next();
		    File archivo = new File(ruta);
		    Scanner reader = new Scanner(archivo);
		    String data="";
		    while(reader.hasNextLine()) {
		            data += reader.nextLine()+"\n";
		        }
			
		    String filas [] = data.split("\n");
			
		    String aux[]=filas[0].split(",");
			
		    matrizA = new double[filas.length][aux.length];
			
		        for(int i =0; i<filas.length;i++) {
		            aux=filas[i].split(",");
		                for(int j=0;j<aux.length;j++) {
		                    matrizA[i][j]=Double.parseDouble(aux[j]);
		                }
		        }

			//INGRESAR MATRIZ "B" POR CONSOLA ============================================================
		    System.out.println("");
			System.out.print("Ingrese ruta de la MATRIZ B: ");
		    String ruta1 = sc.next();
		    File archivo1 = new File(ruta1);
		    Scanner reader1 = new Scanner(archivo1);
		    String data1="";
		        while(reader1.hasNextLine()) {
		            data1 += reader1.nextLine()+"\n";
		        }
			
		    String filas1 [] = data1.split("\n");
			
		    String ax1[]=filas1[0].split(",");
			
		    matrizB = new double[filas1.length][ax1.length];
			
		        for(int i =0; i<filas1.length;i++) {
		            ax1=filas1[i].split(",");
		                for(int j=0;j<ax1.length;j++) {
		                    matrizB[i][j]=Double.parseDouble(ax1[j]);
		                }     
		        }
		       

			//MULTIPLICAR MATRICES A*M ============================================================
			int fl=filas.length;
			int cl=col;
			mM= new double [fl][cl];
			
		    for(int i=0;i<filas.length;i++){
		    	for(int j=0;j<col;j++){
		    			for(int h=0;h<aux.length;h++){
		    				mM[i][j]+=matrizA[i][h]*mCadena[h][j];
		    			}
		    	}
		    }
		    

			//SUMAR MATRICES MATRICES (A*M)+B ============================================================
			int flm=filas.length;
			int clm=col;
			mS= new double [flm][clm];
			
		    for (int i = 0; i < mM.length; i++) {
		        for (int j = 0; j < mM[0].length; j++) {
		            mS[i][j]= mM[i][j] + matrizB[i][j];
		        }
		    }
			
		    System.out.println("");
		    System.out.println("La MATRIZ ENCRIPTADA es:");
			for(int i=0; i<flm; i++) {
				for(int j=0; j<clm; j++) {
					System.out.print("["+Math.round(mS[i][j])+"]");
				}
				System.out.println("");
			}
			
			System.out.println("");
			
			
			//INVERSA MATRIZ A ============================================================
			double dC11 = ((-1)*(-1))*((matrizA [1][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[1][2]));
			double dC21 = ((-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[0][2]));
			double dC31 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[1][2])-(matrizA[1][1])*(matrizA[0][2]));
			//DETERMINANTE
			double detMA =matrizA[0][0]*(dC11)+matrizA[1][0]*(dC21)+matrizA[2][0]*(dC31);
			
			System.out.println("");
			if(detMA != 0) {

				double dC12 = ((-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[1][2]));
				double dC22 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[0][2]));
				double dC32 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][2])-(matrizA[1][0])*(matrizA[0][2]));
				double dC13 = ((-1)*(-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[1][1]));
				double dC23 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[0][1]));
				double dC33 = ((-1)*(-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][1])-(matrizA[1][0])*(matrizA[0][1]));
				
				//MATRIZ INVERSA
				double [][]cf =new double [3][3];
				cf[0][0]=dC11/detMA;	cf[0][1]=dC12/detMA;	cf[0][2]=dC13/detMA;
				cf[1][0]=dC21/detMA;	cf[1][1]=dC22/detMA;	cf[1][2]=dC23/detMA;
				cf[2][0]=dC31/detMA;	cf[2][1]=dC32/detMA;	cf[2][2]=dC33/detMA;
				
				
				mT = new double [3][3];
				
				for(int i=0; i<cf.length; i++) {
					for(int j=0; j<cf[0].length; j++) {
						mT[j][i]=cf[i][j];
					}
				}
				
			}else {
				
			}
			
				
			//RESTA MATRICES (C - B) ============================================================
			int flm3=filas.length;
			int clm3=col;
			mR= new double [flm3][clm];
			
		    for (int i = 0; i < mS.length; i++) {
		        for (int j = 0; j < mS[0].length; j++) {
		            mR[i][j]= mS[i][j] - matrizB[i][j];
		        }
		    }
			

			//MULTIPLICAR MATRICES (C-B)*(A^-1) ============================================================
			int fl2=filas.length;
			int cl2=col;
			mM2= new double [fl2][cl2];
			
		    for(int i=0;i<filas.length;i++){
		    	for(int j=0;j<col;j++){
		    			for(int h=0;h<aux.length;h++){
		    				mM2[i][j]+=mT[i][h]*mR[h][j];
		    			}
		    	}
		    }
		    
		    System.out.println("La MATRIZ DESENCRIPTADA es:");
			for(int i=0; i<fl2; i++) {
				for(int j=0; j<cl2; j++) {
					System.out.print("["+Math.round(mM2[i][j])+"]");
				}
				System.out.println("");
			}
			
			
			//MATRIZ A VECTOR ============================================================
			int []vn = new int[cadena.length()];
			int co=0;
			for(int i = 0; i<cl2; i++) {
			    for(int j = 0; j < fl2; j++) {
			            vn[co] = (int)Math.round(mM2[j][i]); 
			            co++;
			    }
			}
			
			String[] v = new String[vn.length];
			int cont=0;
			for(int i = 0; i<vn.length; i++) {
			    v[cont] = String.valueOf(vn[i]); 
			    cont++; 
			}

			
			//NUMEROS A LETRAS ============================================================
			for(int i=0; i<cadena.length(); i++) {

			switch(v[i]) {
				case "0":
					v[i] = "a";	
					break;
				case "1":
					v[i] ="b";
					break;
				case "2":							
					v[i] = "c";;
					break;
				case "3":
					v[i] = "d";
					break;
				case "4":
					v[i] = "e";
					break;
				case "5":
					v[i] = "f";
					break;
				case "6":
					v[i] = "g";
					break;
				case "7":
					v[i] = "h";
					break;
				case "8":
					v[i] = "i";
					break;
				case "9":
					v[i] = "j";
					break;
				case "10":
					v[i] = "k";
					break;
				case "11":
					v[i] = "l";
					break;
				case "12":
					v[i] = "m";
					break;
				case "13":
					v[i] = "n";
					break;
				case "14":
					v[i] = "ñ";
					break;
				case "15":
					v[i] = "o";
					break;
				case "16":
					v[i] = "p";
					break;
				case "17":
					v[i] = "q";
					break;
				case "18":
					v[i] = "r";
					break;
				case "19":
					v[i] = "s";
					break;
				case "20":
					v[i] = "t";
					break;
				case "21":
					v[i] = "u";
					break;
				case "22":
					v[i] = "v";
					break;
				case "23":
					v[i] = "w";
					break;
				case "24":
					v[i] = "x";
					break;
				case "25":
					v[i] = "y";
					break;
				case "26":
					v[i] = "z";
					break;
				case "27":
					v[i] = " ";
					break;
				}	
			}
			
			System.out.println("");
			System.out.println("TEXTO DESCIFRADO: ");
			for(int i=0; i<v.length; i++) {
				System.out.print(v[i]);
			}
			
			System.out.println("");
			System.out.println("");

			reader.close();
			reader1.close();
			
		}catch(Exception e) {
			System.out.println("Error: " +e);
		}
		
	}

	
	//=====================================================
	//ATAQUE
	public static void ataque() {
		System.out.println("");
		System.out.println("NO SALIO :((");
		System.out.println("");
	}
	
	
	//=====================================================
	//REPORTES
	public static void reporte() {
		System.out.println("");
		System.out.println("------------------------GENERAR REPORTE------------------------");
		
		try {
			
			String reruta = "Reporte.html";
			FileWriter archivore = new FileWriter(reruta);
			
			archivore.write("<!DOCTYPE html>\r\n"
					+"<html>\r\n "
					+ "<head>\r\n"
					+"<title>Reporte</title>"
					+ "<link rel=\"stylesheet\" href=\"./style.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<br> "
					);
			archivore.write("<h1><center>ENCRIPTAR</center></h1>");
			
		System.out.print("Ingrese una cadena de texto: ");
		String cadena = sc.nextLine();
		archivore.write("<p>Texto a encriptar: </p>");
		archivore.write("<p>"+cadena+"</p>");
		archivore.write("<br>");
		
		//VALIDAR SI EL TAMAÑO ES MULTIPLO DE 3 ============================================================
		if(cadena.length()%3 != 0) {
			String espacio=" ";
	
			while(cadena.length()%3 != 0) {
				cadena += espacio;
			}
				
		}else{
			
		}	

		
		String[] cTam = new String[cadena.length()];
		
		
		//CAMBIO DE LETRAS POR NUMEROS ============================================================
		for(int i=0; i<cadena.length(); i++) {
			let = cadena.charAt(i);
			cTam[i]=Character.toString(let);

		switch(cTam[i].charAt(0)) {
			case 'a':
				cTam[i] = "0";	
				break;
			case 'A':
				cTam[i] ="0";
				break;
			case 'b':							
				cTam[i] = "1";;
				break;
			case 'B':
				cTam[i] = "1";
				break;
			case 'c':
				cTam[i] = "2";
			case 'C':
				cTam[i] = "2";
				break;
			case 'd':
				cTam[i] = "3";
				break;
			case 'D':
				cTam[i] = "3";
			case 'e':
				cTam[i] = "4";
				break;
			case 'E':
				cTam[i] = "4";
				break;
			case 'f':
				cTam[i] = "5";
				break;
			case 'F':
				cTam[i] = "5";
				break;
			case 'g':
				cTam[i] = "6";
				break;
			case 'G':
				cTam[i] = "6";
				break;
			case'h':
				cTam[i] = "7";
				break;
			case 'H':
				cTam[i] = "7";
				break;
			case 'i':
				cTam[i] = "8";
				break;
			case 'I':
				cTam[i] = "8";
				break;
			case 'j':
				cTam[i] = "9";
				break;
			case 'J':
				cTam[i] = "9";
				break;
			case 'k':
				cTam[i] = "10";
				break;
			case 'K':
				cTam[i] = "10";
				break;
			case 'l':
				cTam[i] = "11";
				break;
			case 'L':
				cTam[i] = "11";
				break;
			case 'm':
				cTam[i] = "12";
				break;
			case 'M':
				cTam[i] = "12";
				break;
			case 'n':
				cTam[i] = "13";
				break;
			case 'N':
				cTam[i] = "13";
				break;
			case 'ñ':
				cTam[i] = "14";
				break;
			case 'Ñ':
				cTam[i] = "14";
				break;
			case 'o':
				cTam[i] = "15";
				break;
			case 'O':
				cTam[i] = "15";	
				break;
			case 'p':
				cTam[i] ="16";
				break;
			case 'P':							
				cTam[i] = "16";;
				break;
			case 'q':
				cTam[i] = "17";
				break;
			case 'Q':
				cTam[i] = "17";
			case 'r':
				cTam[i] = "18";
				break;
			case 'R':
				cTam[i] = "18";
				break;
			case 's':
				cTam[i] = "19";
			case 'S':
				cTam[i] = "19";
				break;
			case 't':
				cTam[i] = "20";
				break;
			case 'T':
				cTam[i] = "20";
				break;
			case 'u':
				cTam[i] = "21";
				break;
			case 'U':
				cTam[i] = "21";
				break;
			case 'v':
				cTam[i] = "22";
				break;
			case'V':
				cTam[i] = "22";
				break;
			case 'w':
				cTam[i] = "23";
				break;
			case 'W':
				cTam[i] = "23";
				break;
			case 'x':
				cTam[i] = "24";
				break;
			case 'X':
				cTam[i] = "24";
				break;
			case 'y':
				cTam[i] = "25";
				break;
			case 'Y':
				cTam[i] = "25";
				break;
			case 'z':
				cTam[i] = "26";
				break;
			case 'Z':
				cTam[i] = "26";
				break;
			case ' ':
				cTam[i] = "27";
				break;
			default:
				cTam[i] = "27";
				break;	
			}	
		}
		
		
		//DE VECTOR A MATRIZ CON LETRAS CAMBIADAS ============================================================
		int col = cadena.length()/3;
		mCadena= new double [3][col];
		
		int aux1=0;
		for(int i=0; i<col; i++) {
			for(int j=0; j<3; j++) {
				mCadena[j][i] = Double.parseDouble(cTam[aux1++]);
			}
		}
		
		archivore.write("<h2><center>Matriz Letras (M)</center></h2>");
		archivore.write("<div class=\"table-wrapper\">");
		archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<3; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<col; j++) {		
				archivore.write("<th>"+mCadena[i][j]+"</th>\n");
			}
			archivore.write("</tr>\n");
		}
		archivore.write("</table>\n");
		archivore.write("</div>");
		
		
		//INGRESAR MATRIZ "A" POR CONSOLA ============================================================
	    System.out.print("Ingrese ruta de la MATRIZ A: ");
	    String ruta = sc.next();
	    File archivo = new File(ruta);
	    Scanner reader = new Scanner(archivo);
	    String data="";
	    while(reader.hasNextLine()) {
	            data += reader.nextLine()+"\n";
	        }
		
	    String filas [] = data.split("\n");
		
	    String aux[]=filas[0].split(",");
		
	    matrizA = new double[filas.length][aux.length];
		
	        for(int i =0; i<filas.length;i++) {
	            aux=filas[i].split(",");
	                for(int j=0;j<aux.length;j++) {
	                    matrizA[i][j]=Double.parseDouble(aux[j]);
	                }
	        }

	        archivore.write("<h2><center>Matriz A</center></h2>");
			archivore.write("<div class=\"table-wrapper\">");
			archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<filas.length; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<aux.length; j++) {
				archivore.write("<th>"+matrizA[i][j]+"</th>\n");
			}
			archivore.write("</tr>\n");
		}
		archivore.write("</table>\n");
		archivore.write("</div>");
		
		
		//INGRESAR MATRIZ "B" POR CONSOLA ============================================================
	
		System.out.print("Ingrese ruta de la MATRIZ B: ");
	    String ruta1 = sc.next();
	    File archivo1 = new File(ruta1);
	    Scanner reader1 = new Scanner(archivo1);
	    String data1="";
	        while(reader1.hasNextLine()) {
	            data1 += reader1.nextLine()+"\n";
	        }
		
	    String filas1 [] = data1.split("\n");
		
	    String ax1[]=filas1[0].split(",");
		
	    matrizB = new double[filas1.length][ax1.length];
		
	        for(int i =0; i<filas1.length;i++) {
	            ax1=filas1[i].split(",");
	                for(int j=0;j<ax1.length;j++) {
	                    matrizB[i][j]=Double.parseDouble(ax1[j]);
	                }     
	        }
	       

	        archivore.write("<h2><center>Matriz B</center></h2>");
			archivore.write("<div class=\"table-wrapper\">");
			archivore.write("<table class=\"fl-table\">\n");
	    for(int i=0; i<filas.length; i++) {
	    	archivore.write("<tr>\n");
	    	for(int j=0; j<ax1.length; j++) {
	    		archivore.write("<th>"+matrizB[i][j]+"</th>\n");
	    	}
	    	archivore.write("</tr>\n");
	    }
	    archivore.write("</table>\n"); 
	    archivore.write("</div>");
	    
		
		//MULTIPLICAR MATRICES A*M ============================================================
		int fl=filas.length;
		int cl=col;
		mM= new double [fl][cl];
		
	    for(int i=0;i<filas.length;i++){
	    	for(int j=0;j<col;j++){
	    			for(int h=0;h<aux.length;h++){
	    				mM[i][j]+=matrizA[i][h]*mCadena[h][j];
	    			}
	    	}
	    }
	    
        archivore.write("<h2><center>A*M</center></h2>");
		archivore.write("<div class=\"table-wrapper\">");
		archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<fl; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<cl; j++) {
				archivore.write("<th>"+mM[i][j]+"</th>\n");
			}
			archivore.write("</tr>\n");
		}
		 archivore.write("</table>\n");  
		 archivore.write("</div>");
		
		

		//SUMAR MATRICES MATRICES (A*M)+B ============================================================
		int flm=filas.length;
		int clm=col;
		mS= new double [flm][clm];
		
	    for (int i = 0; i < mM.length; i++) {
	        for (int j = 0; j < mM[0].length; j++) {
	            mS[i][j]= mM[i][j] + matrizB[i][j];
	        }
	    }
		

	    archivore.write("<h2><center>(A*M)+B = C</center></h2>");
		archivore.write("<div class=\"table-wrapper\">");
		archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<flm; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<clm; j++) {
				 archivore.write("<th>"+Math.round(mS[i][j])+"</th>\n");
			}
			archivore.write("</tr>\n");
		}
		archivore.write("</table>\n");
		archivore.write("</div>");
		
		
		
		//INVERSA MATRIZ A ============================================================
		double dC11 = ((-1)*(-1))*((matrizA [1][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[1][2]));
		double dC21 = ((-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[2][2])-(matrizA[2][1])*(matrizA[0][2]));
		double dC31 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][1])*(matrizA[1][2])-(matrizA[1][1])*(matrizA[0][2]));
		//DETERMINANTE
		double detMA =matrizA[0][0]*(dC11)+matrizA[1][0]*(dC21)+matrizA[2][0]*(dC31);
		
		if(detMA != 0) {
			

			double dC12 = ((-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[1][2]));
			double dC22 = ((-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][2])-(matrizA[2][0])*(matrizA[0][2]));
			double dC32 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][2])-(matrizA[1][0])*(matrizA[0][2]));
			double dC13 = ((-1)*(-1)*(-1)*(-1))*((matrizA [1][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[1][1]));
			double dC23 = ((-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[2][1])-(matrizA[2][0])*(matrizA[0][1]));
			double dC33 = ((-1)*(-1)*(-1)*(-1)*(-1)*(-1))*((matrizA [0][0])*(matrizA[1][1])-(matrizA[1][0])*(matrizA[0][1]));
			
			//MATRIZ INVERSA
			double [][]cf =new double [3][3];
			cf[0][0]=dC11/detMA;	cf[0][1]=dC12/detMA;	cf[0][2]=dC13/detMA;
			cf[1][0]=dC21/detMA;	cf[1][1]=dC22/detMA;	cf[1][2]=dC23/detMA;
			cf[2][0]=dC31/detMA;	cf[2][1]=dC32/detMA;	cf[2][2]=dC33/detMA;
			
			
			mT = new double [3][3];
			
			for(int i=0; i<cf.length; i++) {
				for(int j=0; j<cf[0].length; j++) {
					mT[j][i]=cf[i][j];
				}
			}
			
			archivore.write("<br>\n");
			archivore.write("<br>\n");
			archivore.write("<br>\n");
			archivore.write("<h1><center>DESENCRIPTAR</center></h1>");

			archivore.write("<h2><center>A^-1</center></h2>");
			archivore.write("<div class=\"table-wrapper\">");
			archivore.write("<table class=\"fl-table\">\n");
			for(int i=0; i<mT.length; i++) {
				archivore.write("<tr>\n");
				for(int j=0; j<mT.length; j++) {
					archivore.write("<th>"+mT[i][j]+"</th>\n");
				}
				archivore.write("</tr>\n");
			}
			archivore.write("</table>\n");
			archivore.write("</div>");
			
		}else {
			
		}
		
		
		
		//RESTA MATRICES (C - B) ============================================================
		int flm3=filas.length;
		int clm3=col;
		mR= new double [flm3][clm];
		
	    for (int i = 0; i < mS.length; i++) {
	        for (int j = 0; j < mS[0].length; j++) {
	            mR[i][j]= mS[i][j] - matrizB[i][j];
	        }
	    }
		
	    
	    archivore.write("<h2><center>(C-B)</center></h2>");
		archivore.write("<div class=\"table-wrapper\">");
		archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<flm3; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<clm3; j++) {
				 archivore.write("<th>"+mR[i][j]+"</th>\n");
			}
			archivore.write("<tr>\n");
		}
		archivore.write("</table>\n");
		archivore.write("</div>");
		
		
		//MULTIPLICAR MATRICES (C-B)*(A^-1) ============================================================
		int fl2=filas.length;
		int cl2=col;
		mM2= new double [fl2][cl2];
		
	    for(int i=0;i<filas.length;i++){
	    	for(int j=0;j<col;j++){
	    			for(int h=0;h<aux.length;h++){
	    				mM2[i][j]+=mT[i][h]*mR[h][j];
	    			}
	    	}
	    }
	    
	    archivore.write("<h2><center>(C-B)*(A^-1) = M</center></h2>");
		archivore.write("<div class=\"table-wrapper\">");
		archivore.write("<table class=\"fl-table\">\n");
		for(int i=0; i<fl2; i++) {
			archivore.write("<tr>\n");
			for(int j=0; j<cl2; j++) {
				archivore.write("<th>"+Math.round(mM2[i][j])+"</th>\n");
			}
			archivore.write("<tr>\n");
		}
		archivore.write("</table>\n"); 
		archivore.write("</div>");
		
		
		//MATRIZ A VECTOR ============================================================
		int []vn = new int[cadena.length()];
		int co=0;
		for(int i = 0; i<cl2; i++) {
		    for(int j = 0; j < fl2; j++) {
		            vn[co] = (int)Math.round(mM2[j][i]); 
		            co++;
		    }
		}
		
		String[] v = new String[vn.length];
		int cont=0;
		for(int i = 0; i<vn.length; i++) {
		    v[cont] = String.valueOf(vn[i]); 
		    cont++; 
		}

		
		//NUMEROS A LETRAS ============================================================
		for(int i=0; i<cadena.length(); i++) {

		switch(v[i]) {
			case "0":
				v[i] = "a";	
				break;
			case "1":
				v[i] ="b";
				break;
			case "2":							
				v[i] = "c";;
				break;
			case "3":
				v[i] = "d";
				break;
			case "4":
				v[i] = "e";
				break;
			case "5":
				v[i] = "f";
				break;
			case "6":
				v[i] = "g";
				break;
			case "7":
				v[i] = "h";
				break;
			case "8":
				v[i] = "i";
				break;
			case "9":
				v[i] = "j";
				break;
			case "10":
				v[i] = "k";
				break;
			case "11":
				v[i] = "l";
				break;
			case "12":
				v[i] = "m";
				break;
			case "13":
				v[i] = "n";
				break;
			case "14":
				v[i] = "ñ";
				break;
			case "15":
				v[i] = "o";
				break;
			case "16":
				v[i] = "p";
				break;
			case "17":
				v[i] = "q";
				break;
			case "18":
				v[i] = "r";
				break;
			case "19":
				v[i] = "s";
				break;
			case "20":
				v[i] = "t";
				break;
			case "21":
				v[i] = "u";
				break;
			case "22":
				v[i] = "v";
				break;
			case "23":
				v[i] = "w";
				break;
			case "24":
				v[i] = "x";
				break;
			case "25":
				v[i] = "y";
				break;
			case "26":
				v[i] = "z";
				break;
			case "27":
				v[i] = " ";
				break;
			}	
		}
		
		archivore.write("<p>Texto desencriptado: </p>");
		archivore.write("<p>"+cadena+"</p>");
		
		System.out.println("");
		System.out.println("REPORTE CREADO EXITOSAMENTE");

		reader.close();
		reader1.close();
		
		  archivore.write("<br>");
		  archivore.write("<br>");
		  archivore.write("<br>");
	      archivore.write("</body>\r\n"+
                  "</html>\r\n");
	      archivore.close();  
		
		}catch(Exception e){
			System.out.println("Error al crear el reporte: " +e);
		}

	}
	

}//=====================================================
//CIERRA CLASE PRINCIPAL
