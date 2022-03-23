package com.sicred.receita.service;

import com.sicred.receita.dto.ContaDTO;

import java.util.List;

public class ValidaContaService {
    ReceitaService receitaService = new ReceitaService();

    public List<ContaDTO> validaReceita(List<ContaDTO> contas) {
        contas.parallelStream().forEach(pessoa ->{
            boolean resultadoBacen;
            try {
                resultadoBacen = receitaService.atualizarConta(pessoa.getAgencia() != null ? pessoa.getAgencia() : null,
                        pessoa.getConta() != null ? pessoa.getConta().replace("-","") : null,
                        pessoa.getSaldo() != null ? Double.parseDouble(pessoa.getSaldo().replace(",",".")) : null,
                        pessoa.getStatus() != null ? pessoa.getStatus() : null);
            }
            catch(RuntimeException e){
                resultadoBacen = false;
                System.out.println(e);
            }
            catch(InterruptedException e){
                resultadoBacen = false;
                System.out.println(e);
            }

            pessoa.setValidoBacen(Boolean.toString(resultadoBacen));

        });

        return contas;
    }
}
