package com.uniube.reservas;

import com.uniube.salas.Sala;

public class Reserva {

    private String nomeProfessor;
    private String dataReserva;
    private Sala salaReservada;


    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }


    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }


    public Sala getSalaReservada() {
        return salaReservada;
    }

    public void setSalaReservada(Sala salaReservada) {
        this.salaReservada = salaReservada;
    }


    public void realizarReserva(Sala sala) {
        if (sala.isDisponivel()){
            sala.reservar();
            this.salaReservada = sala;
        }
    }


    public void cancelarReserva() {
        if (salaReservada != null) {
            salaReservada.liberar(); // Libera a sala
            salaReservada = null; // Remove a associação
        }
    }


    public void exibirReserva() {
        System.out.println("--- Detalhes da Reserva ---");
        System.out.println("Professor: " + nomeProfessor);
        System.out.println("Data: " + dataReserva);
        if (salaReservada != null) {

            salaReservada.exibirDados(); // Reaproveita o método de exibição da Sala
        } else {
            System.out.println("Nenhuma sala vinculada.");
        }
    }


}
