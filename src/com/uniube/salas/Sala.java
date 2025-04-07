package com.uniube.salas;

public class Sala {

    private int numeroSala;
    private int capacidade;
    private boolean disponivel = true;


    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }


    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void reservar(){
        setDisponivel(false);
    }

    public void liberar(){
        setDisponivel(true);
    }

    public void exibirDados(){
        String status = disponivel ? "Sim" : "Não";
        System.out.println("Número da sala: " + numeroSala +
                "\nCapacidade: " + capacidade +
                "\nDisponibilidade: " + status);
    }

}
