package com.sicred.receita.dto;


public class ContaDTO {

   private String agencia;
   private  String conta;
   private String saldo;
   private String status;
   private String validoBacen;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getAgencia() {
      return agencia;
   }

   public void setAgencia(String agencia) {
      this.agencia = agencia;
   }

   public String getConta() {
      return conta;
   }

   public void setConta(String conta) {
      this.conta = conta;
   }



   public String getSaldo() {
      return saldo;
   }

   public void setSaldo(String saldo) {
      this.saldo = saldo;
   }



   public String getValidoBacen() {
      return validoBacen;
   }

   public void setValidoBacen(String validoBacen) {
      this.validoBacen = validoBacen;
   }

}
