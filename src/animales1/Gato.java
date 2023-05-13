package animales1;

import java.util.Objects;

public class Gato extends Animal1 {

    private String raza;

    public Gato(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {
        super(codigo, fechaNacimiento, sexo, peso);

        if (codigo.charAt(0) != 'g' || "".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
            this.raza = raza;
        }

    }

    public Gato(Gato otroGato) throws IllegalArgumentException {
        super(otroGato);
    }

    public Gato(String raza, Animal1 OtroAnimal) {
        super(OtroAnimal);
        this.raza = raza;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        if ("".equals(raza)) {
            throw new IllegalArgumentException();
        } else {
            this.raza = raza;
        }
    }

    @Override
    public void setCodigo(String codigo) throws IllegalArgumentException {
        if (codigo.charAt(0) != 'p') {
            throw new IllegalArgumentException();
        } else {
            super.setCodigo(codigo);
        }
    }

    public String cazar() {
        return "Me encanta cazar bichejos";
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String alegrarse() {
        return "Ronroneo y me froto contra tus piernas";
    }

    @Override
    public String enfadarse() {
        return "Me bufo y saco las u??as";
    }

    @Override
    public String queSoy() {
        return "Soy un gato";

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        super.setFechaNacimiento(fechaNacimiento);
    }

    @Override
    public String getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    @Override
    public double getPeso() {
        return super.getPeso();
    }

    @Override
    public char getSexo() {
        return super.getSexo();
    }

    @Override
    public String toString() {
        return "Gato{Animal{codigo=" + getCodigo() + ", fechaNacimiento=" + getFechaNacimiento() + ", sexo=" + getSexo() + ", peso=" + getPeso() + "}raza=" + getRaza() + '}';
    }
}
