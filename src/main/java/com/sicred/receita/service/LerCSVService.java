package com.sicred.receita.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sicred.receita.dto.ContaDTO;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LerCSVService {

    ValidaContaService validaContaService = new ValidaContaService();


    public List<ContaDTO> lerContasComValidacao(String caminhoArquivoCSV) throws IOException {


        Reader reader = Files.newBufferedReader(Paths.get(caminhoArquivoCSV));

        CsvToBean<ContaDTO> csvToBean = new CsvToBeanBuilder(reader)
                .withType(ContaDTO.class)
                .withSeparator(';')
                .build();

        List<ContaDTO> contas = csvToBean.parse();

        return validaContaService.validaReceita(contas);
    }




}
