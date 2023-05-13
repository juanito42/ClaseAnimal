package granjaescuela;

import animales1.Animal1;
import animales1.Gato1;
import animales1.Perro1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class GranjaEscuela {

    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

        ArrayList<Animal1> miGranja = new ArrayList();

        String codigo;
        String fechaNacimiento;
        char sexo;
        double peso;
        String raza;
        String tipoAnimal;

        int numAnimales;
        Animal1 animal;
        Perro1 perro;
        Gato1 gato;

        System.out.println("Procesando animales de la granja");
        System.out.println("----------------------------------");
        numAnimales = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numAnimales; i++) {

            tipoAnimal = sc.nextLine();

            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.nextLine().charAt(0);
            peso = sc.nextDouble();
            sc.nextLine();

            if (tipoAnimal.equals("perro")) {
                raza = sc.nextLine();
                try {
                    perro = new Perro1(codigo, fechaNacimiento, sexo, peso, raza);
                    miGranja.add(perro);

                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando perro. Datos incorrectos. Procesando siguiente animal");
                }
            } else if (tipoAnimal.equals("gato")) {
                raza = sc.nextLine();
                try {
                    gato = new Gato1(codigo, fechaNacimiento, sexo, peso, raza);
                    miGranja.add(gato);

                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando gato. Datos incorrectos. Procesando siguiente animal");
                }
            }

        
        Iterator<Animal1> iterador = miGranja.iterator();
        while (iterador.hasNext()) {
            animal = (Animal1) iterador.next();
            System.out.println("");
            
            if (animal instanceof Perro1) {
                
                System.out.println(animal.toString());
                System.out.println(animal.queSoy());
                System.out.println("Hago " + animal.hacerSonido());
                System.out.println("Cuando estoy alegre " + animal.alegrarse());
                System.out.println("Cuando me enfado " + animal.enfadarse());
            } else if (animal instanceof Gato1) {
                
                System.out.println(animal.toString());
                System.out.println(animal.queSoy());
                System.out.println("Hago " + animal.hacerSonido());
                System.out.println("Cuando estoy alegre " + animal.alegrarse());
                System.out.println("Cuando me enfado " + animal.enfadarse());
            }
        }
        miGranja.clear();
      }
    }

}
