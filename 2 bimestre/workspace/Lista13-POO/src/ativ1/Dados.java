package ativ1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Dados implements  Serializable{
	private String descricao;
	private Date data;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static StringBuilder notitf = new StringBuilder();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(String data) throws ParseException {
		this.data = sdf.parse(data);
	}

	public Dados(String descricao, String dat) {
		
		try {
			this.descricao = descricao;
			this.data = sdf.parse(dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date dataHoje() throws ParseException {
		Date da = new Date();
		String s = da.toString();
		System.out.println(s);
		String[] str = s.split(" ");
		@SuppressWarnings("deprecation")
		String datis = (str[2] + "-" + (da.getMonth() + 1) + "-" + str[5]);

		Date dataNow = sdf.parse(datis);
		return dataNow;
	}

	public void dataDiff(Date dataLow, Date dataHigh) {
		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();
		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();
		startTime.setTime(dataLow);
		endTime.setTime(dataHigh);
		int dif_multiplier = 1;
		// Verifica a ordem de inicio das datas
		if (dataLow.compareTo(dataHigh) < 0) {
			baseTime.setTime(dataHigh);
			curTime.setTime(dataLow);
			dif_multiplier = 1;
		} else {
			baseTime.setTime(dataLow);
			curTime.setTime(dataHigh);
			dif_multiplier = -1;
		}
		int result_years = 0;
		int result_months = 0;
		int result_days = 0;
		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando
		// no total de dias. Ja leva em consideracao ano bissesto
		while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
				|| curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {
			int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);
		}
		// Marca que é um saldo negativo ou positivo
		result_months = result_months * dif_multiplier;
		// Retirna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));
		int dif = result_years + result_months + result_days;
		if (dif < 3) {
			if (dif == 0)
				notitf.append("O evento: " + descricao + " ocorrerá Hoje!!!\n__________________________________\n");
			else
				notitf.append("Faltam " + dif + " dias para " + descricao +    "\n__________________________________\n");
		}

	}

	public static void imprimeNotify() {
		if (notitf.length() != 0) {
			StringBuilder str = notitf;
			JOptionPane.showMessageDialog(null, str, "Proximos Eventos", 1);
		}
		notitf = new StringBuilder();
		System.out.println(notitf);
	}

}
