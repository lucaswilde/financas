package com.financas.uteis;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;


public final class Utilidades {

	/**
	 * Retorna o tempo em horas e minutos entre duas datas
	 */
	public static String diferencaDatas(Date date1, Date date2)
	{
		long differenceMilliSeconds = date1.getTime() - date2.getTime();
		long horas = differenceMilliSeconds / 1000 / 60 / 60;
		long min = (differenceMilliSeconds / 1000 / 60) - (horas * 60);
		DecimalFormat formatter = new DecimalFormat("00");
		return (formatter.format(horas) + ":" + formatter.format(min));
	}

	/**
	 * Retorna a data do dia anterior
	 */
	public static Date subtrairDias(Date data, Integer nrDias)
	{
		Calendar aux = Calendar.getInstance();
		aux.setTime(data);
		aux.add(Calendar.DAY_OF_MONTH, -nrDias);
		return new Date(aux.getTimeInMillis());
	}
	
	/**
	 * Retorna a data acrescida dos dias enviados por parâmetro
	 */
	public static Date adicionarDias(Date data, Integer nrDias)
	{
		Calendar aux = Calendar.getInstance();
		aux.setTime(data);
		aux.add(Calendar.DAY_OF_MONTH, nrDias);
		return new Date(aux.getTimeInMillis());
	}
	
	/**
	 * Adiciona a quantidade de minutos na data
	 */
	public static Date adicionarMinutos(Date data, Long minutos)
	{
		Calendar aux = Calendar.getInstance();
		aux.setTime(data);
		aux.add(Calendar.MINUTE, Integer.parseInt(removeCaracteresAlfabeticos(minutos.toString())));
		return new Date(aux.getTimeInMillis());
	}
	
	/**
	 * Retorna a idade da pessoa a partir de sua data nascimento
	 */
	public static Integer getIdade(Date dtNascimento)
	{
		Calendar hoje = Calendar.getInstance();
		Calendar nascimento = Calendar.getInstance();
		nascimento.setTime(dtNascimento);
		return (hoje.YEAR - nascimento.YEAR);
	}
	
	/**
	 * Remove os valores alfabéticos de uma string
	 */
	public static String removeCaracteresAlfabeticos(String s){
		Pattern pattern = Pattern.compile("[^0-9]*");		
		Matcher matcher = pattern.matcher(s);
		return matcher.replaceAll("");
	}
	
	/**
	 * Retorna data setando hora mínima
	 */
	public static Date setHoraMinima(Date dataReceb){
		Calendar dataMinima = Calendar.getInstance();
		
		dataMinima.setTime(dataReceb);
		dataMinima.set(Calendar.HOUR_OF_DAY, 0);
		dataMinima.set(Calendar.HOUR, 0);
		dataMinima.set(Calendar.MINUTE, 0);
		dataMinima.set(Calendar.SECOND, 0);
		dataMinima.set(Calendar.MILLISECOND, 0);
		dataMinima.set(Calendar.AM_PM, 0);
		
		Date menor = dataMinima.getTime();
		return menor;
	}
	
	/**
	 * Retorna data setando hora máxima
	 */
	public static Date setHoraMaxima(Date dataReceb){
		Calendar dataMaxima = Calendar.getInstance();
		
		dataMaxima.setTime(dataReceb);
		dataMaxima.set(Calendar.HOUR_OF_DAY, 23);
		dataMaxima.set(Calendar.HOUR, 23);
		dataMaxima.set(Calendar.MINUTE, 59);
		dataMaxima.set(Calendar.SECOND, 59);
		dataMaxima.set(Calendar.MILLISECOND, 9999);
		dataMaxima.set(Calendar.AM_PM, 0);
		
		Date maior = dataMaxima.getTime();
		return maior;
	}
	
	/**
	 * Retorna String(cpf) com máscara
	 */
	public static String atribuiMascaraCpf(String cpf) throws ParseException{
		try {
			MaskFormatter format = new MaskFormatter("###.###.###-##"); 
			format.setValueContainsLiteralCharacters(false); 
			cpf = format.valueToString(cpf);
			return cpf;
		} catch (Exception e) {
			return cpf;
		}
	}
	
	public static byte[] getBytesFromBase64(String base64) {
		byte[] bytes;
		try {
			bytes = new sun.misc.BASE64Decoder().decodeBuffer(base64);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 

		return bytes;
	}
	
	public static String getBase64FromBytes(byte[] bytes) {
		String base64;
		base64 = new sun.misc.BASE64Encoder().encode(bytes); 

		return base64;
	}
	
	/**
	 * Contatena numeros separando cada um com uma virgula
	 * 
	 * @param lista
	 * @return
	 */
	public static String concatCodigoToSql(List<Integer> lista){
		String cod = ""; 
		if (lista != null && lista.size() != 0) {
        	for(Integer c : lista){
        		if(cod.equals("")){
        			cod += c.toString();
        		}else{
        			cod += ", "+c.toString();
        		}
        	}
		}
		return cod;
	}
}