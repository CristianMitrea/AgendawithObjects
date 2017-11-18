package fasttrackit.ro;

import java.util.Scanner;

public class AgendawithObjects {

    static Person[] agendaDeNume = new Person[4];
    static int pozitie = 0;

    public static void initializareAgenda() {
        for (int i = 0; i <agendaDeNume.length ; i++) {
            agendaDeNume[i] = new Person();
        }
    }

    public static void afisareMeniu() {
        System.out.println("1> Afisare");
        System.out.println("2> Adaugare");
        System.out.println("3> Stergere");
        System.out.println("4> Cautare");
        System.out.println("5> Modificare");
        System.out.println("0> Exit");
    }

    public static String citireNume(String label) { // citeste nume de la tastatura
        System.out.print(label);
        Scanner kbdInput = new Scanner(System.in);
        return kbdInput.nextLine();
    }

    public static void afisareAgenda() { // afiseaza continutul agendei
        int counter = 0;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i].name != null) {
                System.out.println(i + ": " + "Nume: " + agendaDeNume[i].name + " Telefon: " + agendaDeNume[i].phone);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Agenda este goala, va rog adaugati nume");
        }
        System.out.println();
    }

    public static void adaugareAgenda() { // adauga nume in agenda atata timp cat gaseste elemente null
        int counter = 0;
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i].name == null) {
                String nume = citireNume("Introduceti numele de adaugat:");
                agendaDeNume[i].name = nume;
                String telefon = citireNume("Introduceti telefonul de adaugat:");
                agendaDeNume[i].phone = telefon;
                counter++;
                break;
            }
        }
        if (counter == 0)
            System.out.println("Agenda plina, ia alta mai mare");
        System.out.println();
    }


    public static int cautareAgenda(String label) { //se opreste la primul gasit
        int found = -1;
        String nume = citireNume(label);
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (nume.equalsIgnoreCase(agendaDeNume[i].name)) {
                //agendaDeNume[i] = null;
                System.out.println("Nume gasit pe pozitia " + i + ": " + agendaDeNume[i].name + " Telefon: " + agendaDeNume[i].phone);
                System.out.println();
                found = i;
                break;
            }
        }
        if (found == -1){
            System.out.println("Numele nu a fost gasit in agenda");
            System.out.println();
        }
        return found;
    }

    public static void stergereAgenda() { // sterge primul nume gasit
        //int indexCautat = -1;
        int indexCautat = cautareAgenda("Introduceti numele de sters: ");
        if(indexCautat!=-1) {
            agendaDeNume[indexCautat].name = null;
            agendaDeNume[indexCautat].phone = null;
            System.out.println("Nume sters din agenda");
            System.out.println();
        }
    }

    public static void modificareAgenda() { //inlocuieste primul nume gasit

        int indexCautat = cautareAgenda("Introduceti numele de inlocuit: ");
        if(indexCautat!=-1) {
            String numeNou = citireNume("Introduceti noul nume: ");
            String telefonNou = citireNume("Introduceti noul telefon: ");
            agendaDeNume[indexCautat].name = numeNou;
            agendaDeNume[indexCautat].phone = telefonNou;
            System.out.println("Nume inlocuit in agenda");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initializareAgenda();
        int optiune = -1;
        do {
            afisareMeniu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();
            switch (optiune) {
                case 1: {
                    afisareAgenda();
                    break;
                }

                case 2: {
                    adaugareAgenda();
                    break;
                }

                case 3: {
                    stergereAgenda();
                    break;
                }
                case 4: {
                    cautareAgenda("Introduceti numele de cautat:");
                    break;
                }
                case 5: {
                    modificareAgenda();
                    break;
                }
            }
        }
        while (optiune != 0);
    }
}
