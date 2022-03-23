package com.sicred.receita.service;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sicred.receita.dto.ContaDTO;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EscreverCSVService {

    public void contas(List<ContaDTO> contas) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Writer writer = Files.newBufferedWriter(Paths.get("contas.csv"));
        StatefulBeanToCsv<ContaDTO> beanToCsv = new StatefulBeanToCsvBuilder(writer).withSeparator(';').build();

        beanToCsv.write(contas);
        writer.flush();
        writer.close();

        System.out.println("SUCESSO: Relatório gerado com nome contas.csv");
    }
}
