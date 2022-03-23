package com.sicred.receita;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sicred.receita.dto.ContaDTO;
import com.sicred.receita.service.EscreverCSVService;
import com.sicred.receita.service.LerCSVService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class SincronizacaoReceita {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(SincronizacaoReceita.class, args);

        LerCSVService lerCSVService = new LerCSVService();
        EscreverCSVService escreverCSVService = new EscreverCSVService();

        if (args.length > 0) {

            System.out.println("PROCESSANDO: " + args[0]);

            List<ContaDTO> contas = lerCSVService.lerContasComValidacao(args[0]);

            try {
                escreverCSVService.contas(contas);
            } catch (IOException e) {
                System.out.println(e);
            } catch (CsvRequiredFieldEmptyException e) {
                System.out.println(e);
            } catch (CsvDataTypeMismatchException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("ERRRO: Ao executar o JAR, inserir como parametro o diretorio com nome do arquiva dentro de aspas duplas.");
        }
    }
}
