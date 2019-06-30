package DAO;

import java.io.Serializable;
import java.util.ArrayList;

public class Serial<Obj> implements Serializable{
	private java.io.FileOutputStream fileOut;
	private java.io.ObjectOutputStream objOut;
	private java.io.FileInputStream fileIn;
	private java.io.ObjectInputStream objIn;
	
	public void Serializar(ArrayList<Obj> lista, String nomeArquivo) {
		try {
			java.nio.file.Path url = java.nio.file.Paths.get("", "src", "Serial", nomeArquivo);
			System.out.println("SERIALIZAÇÃO EM PROCESSO;\nCaminho: " + url.toAbsolutePath().toString());
			
			// Criação de arquivo (Caso já não há um criado; caso haja...
			java.io.File arquivo = new java.io.File(url.toAbsolutePath().toString());
			arquivo.createNewFile();// ...esta linha não ira fazer nada.)	
			
			fileOut = new java.io.FileOutputStream(arquivo);
			objOut = new java.io.ObjectOutputStream(fileOut);
			objOut.writeObject(lista);
			objOut.close();
			fileOut.close();
		} catch(Exception ex) {
			System.err.println("Erro na serialização;");
			ex.printStackTrace();
		}
	}
	public ArrayList<Obj> DeSerializar(String nomeArquivo) {
		ArrayList<Obj> aux = null;
		java.nio.file.Path url = java.nio.file.Paths.get("", "src", "Serial", nomeArquivo);
		System.out.println("DESERIALIZAÇÃO EM PROCESSO;\nCaminho: " + url.toAbsolutePath().toString());
		java.io.File arquivo = new java.io.File(url.toAbsolutePath().toString());
		try {	
			// 
			arquivo.createNewFile(); // Criação de arquivo (Caso já não há um criado; caso haja, está linha não ira fazer nada.)
			
			fileIn = new java.io.FileInputStream(arquivo);
			objIn = new java.io.ObjectInputStream(fileIn);
			aux = (ArrayList<Obj>) objIn.readObject();
			objIn.close();
			fileIn.close();
		} catch (java.io.InvalidClassException ex) {
			System.err.println("Invalid Class Exception: Classe a ser carregada não condiz com tipo de classe do programa. Inicializando arquivos novamente...");
			arquivo.delete();
			return null;
		} catch (Exception ex) {
			System.err.println("Erro na deserialização;");
			ex.printStackTrace();
		}	
		return aux;
	}
}
