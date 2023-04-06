package edu.joseph.faturamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaturamentoDiario {

	private List<Double> faturamentoDiario;

	public FaturamentoDiario(String path) {
		faturamentoDiario = new ArrayList<>();

		try {
			String conteudo = new String(Files.readAllBytes(Paths.get(path)));
			JSONArray jsonArray = new JSONArray(conteudo);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				double valor = obj.getDouble("valor");
                if (valor != 0.0) {
                    faturamentoDiario.add(valor);
                }
			}

		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}

	public double getMenorValor() {
		return faturamentoDiario.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
	}

	public double getMaiorValor() {
		return faturamentoDiario.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
	}

	public int getDiasAcimaDaMedia() {
		double mediaMensal = faturamentoDiario.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		return (int) faturamentoDiario.stream().filter(d -> d > mediaMensal).count();
	}

	public static void main(String[] args) {
		FaturamentoDiario fd = new FaturamentoDiario("C:\\Users\\josea\\OneDrive\\Documentos\\WorkSpace java\\teste-gupy\\Entrada padrão\\dados.json");

		System.out.println("Menor valor de faturamento: " + fd.getMenorValor());
		System.out.println("Maior valor de faturamento: " + fd.getMaiorValor());
		System.out.println("Dias acima da média: " + fd.getDiasAcimaDaMedia());

	}
}
