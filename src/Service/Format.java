package Service;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;

//Classe que contém lógica para formatação de campos numéricos e outros campos de input.
public class Format {
	public static void setFormatoCpf(JFormattedTextField field) {
		MaskFormatter formatador;
		DefaultFormatterFactory formatadorFactory;
		try {
			formatador = new MaskFormatter("###.###.###-##");
			formatador.setValidCharacters("0123456789");
			formatador.setCommitsOnValidEdit(true);
			formatador.setPlaceholderCharacter('_');
			formatador.setValueContainsLiteralCharacters(false);
			formatadorFactory = new DefaultFormatterFactory(formatador);
			
			field.setFormatterFactory(formatadorFactory);
		} catch (Exception e) {
			System.err.println("Erro na formataï¿½ï¿½o do JFormattedTextField " + field.getName());
			e.printStackTrace();
		}
	}
	
	public static void setFormatoRg(JFormattedTextField field) {	
		MaskFormatter formatador;
		DefaultFormatterFactory formatadorFactory;
		try {
			formatador = new MaskFormatter("###.###.###-##");
			formatador.setValidCharacters("0123456789");;
			formatador.setCommitsOnValidEdit(true);
			formatador.setPlaceholderCharacter('_');
			formatador.setValueContainsLiteralCharacters(false);
			formatadorFactory = new DefaultFormatterFactory(formatador);
			
			field.setFormatterFactory(formatadorFactory);
		} catch (Exception e) {
			System.err.println("Erro na formata\u00E7\u00E3o do JFormattedTextField " + field.getName());
			e.printStackTrace();
		}
	}
	
	public static void setFormatoFone(JFormattedTextField field) {	
		MaskFormatter formatador;
		DefaultFormatterFactory formatadorFactory;
		try {
			formatador = new MaskFormatter("#####-####");
			formatador.setValidCharacters("0123456789");
			formatador.setCommitsOnValidEdit(true);
			formatador.setPlaceholderCharacter('_');
			formatador.setValueContainsLiteralCharacters(false);
			formatadorFactory = new DefaultFormatterFactory(formatador);
			
			field.setFormatterFactory(formatadorFactory);
		} catch (Exception e) {
			System.err.println("Erro na formata\u00E7\u00E3o do JFormattedTextField " + field.getName());
			e.printStackTrace();
		}
	}
	
	public static void setFormatoPlaca(JFormattedTextField field) {	
		MaskFormatter formatador;
		DefaultFormatterFactory formatadorFactory;
		try {
			formatador = new MaskFormatter("UUU-####");
			formatador.setCommitsOnValidEdit(true);
			formatador.setPlaceholderCharacter('_');
			formatador.setValueContainsLiteralCharacters(false);
			formatadorFactory = new DefaultFormatterFactory(formatador);
			
			field.setFormatterFactory(formatadorFactory);
		} catch (Exception e) {
			System.err.println("Erro na formata\u00E7\u00E3o do JFormattedTextField " + field.getName());
			e.printStackTrace();
		}
	}
}
