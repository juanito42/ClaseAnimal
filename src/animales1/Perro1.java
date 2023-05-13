package animales1;

import java.util.Objects;

public class Perro1 {

    public class Perro extends Animal1 {

        private String raza;

        public Perro(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {
            super(codigo, fechaNacimiento, sexo, peso);

            if (codigo.charAt(0) != 'p' || "".equals(raza)) {
                throw new IllegalArgumentException();
            } else {
                this.codigo = codigo;
                this.raza = raza;
            }

        }

        public Perro(Perro otroPerro) throws IllegalArgumentException {
            super(otroPerro);
        }

        public Perro(String raza, Animal1 OtroAnimal) {
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

        public String pasear() {
            return "Me encanta que me saquen a pasear";
        }

        @Override
        public String hacerSonido() {
            return "Guau";
        }

        @Override
        public String alegrarse() {
            return "Salto de alegria y muevo la cola";
        }

        @Override
        public String enfadarse() {
            return "Grunio y ensenio los dientes";
        }

        @Override
        public String queSoy() {
            return "Soy un perro";

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
            return "Perro{Animal{codigo=" + getCodigo() + ", fechaNacimiento=" + getFechaNacimiento() + ", sexo=" + getSexo() + ", peso=" + getPeso() + "}raza=" + getRaza() + '}';
        }
    }
}