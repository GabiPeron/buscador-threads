package com.atv;

public class Buscador {
  private int[] vet;
  private int alvo;
  private int resultado;
  public static boolean encontrou;

  public Buscador(int[] vet, int alvo) {
    this.vet = vet;
    this.alvo = alvo;
    this.resultado = -1;
    encontrou = false;
  }

  public int getResultado() {
    return this.resultado;
  }

  public void setResultado(int posicao) {
    if (resultado == -1) {
      resultado = posicao;
    }
  }

  public void start() {
    for (int i = 0; i < this.vet.length; i++) {
      if (!encontrou) {
        if (this.vet[i] == alvo) {
          this.setResultado(i);

          encontrou = true;

          break;
        }
      } else {
        break;
      }
    }
  }
}
