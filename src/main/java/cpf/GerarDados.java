package cpf;

import java.util.Locale;

import net.datafaker.Faker;

public class GerarDados {

	Faker faker = new Faker(new Locale("pt-BR"));

	public String gerarCpfDigito(String separacao, String digito_1) {
		boolean valorSeparacao = false;
		String str1;
		switch ((str1 = separacao).hashCode()) {
		case -903422143:
			if (!str1.equals("XXX.XXX.XXX-XX"))
				break;
			valorSeparacao = true;
			break;
		}
		String cpf = null;
		String digito = null;
		while (!digito_1.equals(digito)) {
			cpf = this.faker.cpf().valid(valorSeparacao);
			digito = cpf.substring(cpf.length() - 2);
		}
		return cpf;
	}

	public String gerarCpfOrigem(String separacao, String origem) {
		boolean valorSeparacao = false;
		String str1;
		switch ((str1 = separacao).hashCode()) {
		case -903422143:
			if (!str1.equals("XXX.XXX.XXX-XX"))
				break;
			valorSeparacao = true;
			break;
		}
		String valor = null;
		String str2;
		switch ((str2 = origem).hashCode()) {
		case 2082:
			if (str2.equals("AC")) {
				valor = "2";
				break;
			}
		case 2091:
			if (str2.equals("AL")) {
				valor = "4";
				break;
			}
		case 2092:
			if (str2.equals("AM")) {
				valor = "2";
				break;
			}
		case 2095:
			if (str2.equals("AP")) {
				valor = "2";
				break;
			}
		case 2111:
			if (str2.equals("BA")) {
				valor = "5";
				break;
			}
		case 2146:
			if (str2.equals("CE")) {
				valor = "3";
				break;
			}
		case 2178:
			if (str2.equals("DF")) {
				valor = "1";
				break;
			}
		case 2222:
			if (str2.equals("ES")) {
				valor = "7";
				break;
			}
		case 2280:
			if (str2.equals("GO")) {
				valor = "1";
				break;
			}
		case 2452:
			if (str2.equals("MA")) {
				valor = "3";
				break;
			}
		case 2458:
			if (str2.equals("MG")) {
				valor = "6";
				break;
			}
		case 2470:
			if (str2.equals("MS")) {
				valor = "1";
				break;
			}
		case 2471:
			if (str2.equals("MT")) {
				valor = "1";
				break;
			}
		case 2545:
			if (str2.equals("PA")) {
				valor = "2";
				break;
			}
		case 2546:
			if (str2.equals("PB")) {
				valor = "4";
				break;
			}
		case 2549:
			if (str2.equals("PE")) {
				valor = "4";
				break;
			}
		case 2553:
			if (str2.equals("PI")) {
				valor = "3";
				break;
			}
		case 2562:
			if (str2.equals("PR")) {
				valor = "9";
				break;
			}
		case 2616:
			if (str2.equals("RJ")) {
				valor = "7";
				break;
			}
		case 2620:
			if (str2.equals("RN")) {
				valor = "4";
				break;
			}
		case 2621:
			if (str2.equals("RO")) {
				valor = "2";
				break;
			}
		case 2624:
			if (str2.equals("RR")) {
				valor = "2";
				break;
			}
		case 2625:
			if (str2.equals("RS")) {
				valor = "0";
				break;
			}
		case 2640:
			if (str2.equals("SC")) {
				valor = "9";
				break;
			}
		case 2642:
			if (str2.equals("SE")) {
				valor = "5";
				break;
			}
		case 2653:
			if (str2.equals("SP")) {
				valor = "8";
				break;
			}
		case 2683:
			if (str2.equals("TO")) {
				valor = "1";
				break;
			}
		default:
			System.out.println("erro case");
			break;
		}
		int contador = 0;
		String cpf = null;
		boolean digito = false;
		while (!digito) {
			cpf = this.faker.cpf().valid(valorSeparacao);
			if (separacao.equalsIgnoreCase("XXX.XXX.XXX-XX")) {
				digito = valor.contains(cpf.substring(10, 11));
			} else {
				digito = valor.contains(cpf.substring(8, 9));
			}
			if (contador == 50000) {
				cpf = String.valueOf(origem) + " Ndisponivel!";
				break;
			}
			contador++;
		}
		return cpf;
	}

}
