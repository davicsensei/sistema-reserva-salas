package com.uniube.main;

import com.uniube.reservas.Reserva;
import com.uniube.salas.Sala;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação das salas iniciais
        List<Sala> salas = new ArrayList<>();
        Sala sala1 = new Sala();
        sala1.setNumeroSala(101);
        sala1.setCapacidade(40);

        Sala sala2 = new Sala();
        sala2.setNumeroSala(202);
        sala2.setCapacidade(30);

        salas.add(sala1);
        salas.add(sala2);

        System.out.println("Bem-vindo ao sistema de reserva de salas!\n");

        // Leitura dos dados do professor
        System.out.print("Digite seu nome: ");
        String nomeProfessor = scanner.nextLine();

        System.out.print("Digite a data para reserva (dd/mm/aaaa): ");
        String dataReserva = scanner.nextLine();

        // Exibe salas disponíveis
        System.out.println("\nSalas disponíveis:");
        for (Sala sala : salas) {
            if (sala.isDisponivel()) {
                System.out.println("Sala " + sala.getNumeroSala()
                        + " Capacidade: " + sala.getCapacidade()
                        + " alunos Disponível: " + sala.isDisponivel());
            }
        }

        // Seleção da sala
        System.out.print("\nDigite o número da sala que deseja reservar: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        // Busca a sala escolhida
        Sala salaEscolhida = null;
        for (Sala sala : salas) {
            if (sala.getNumeroSala() == numeroSala && sala.isDisponivel()) {
                salaEscolhida = sala;
                break;
            }
        }

        if (salaEscolhida == null) {
            System.out.println("Sala não disponível ou inválida!");
            scanner.close();
            return;
        }

        // Realiza a reserva
        Reserva reserva = new Reserva();
        reserva.setNomeProfessor(nomeProfessor);
        reserva.setDataReserva(dataReserva);
        reserva.realizarReserva(salaEscolhida);

        System.out.println("\nReserva realizada com sucesso!");
        reserva.exibirReserva();

        // Opção de cancelamento
        System.out.print("\nDeseja cancelar a reserva? (sim/nao): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("sim")) {
            reserva.cancelarReserva();
            System.out.println("Reserva cancelada com sucesso!");
        }

        System.out.println("\nObrigado por utilizar o sistema de reserva!");
        scanner.close();
    }
}
