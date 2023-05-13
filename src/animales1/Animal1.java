package animales1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal1 {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;
    
    
    public Animal1(String codigo, String fechaNacimiento, char sexo, double peso) throws IllegalArgumentException {

        if (!esCodigoValido(codigo) || !esSexoValido(sexo) || peso <= 0) {

            throw new IllegalArgumentException();
        }
        this.codigo = codigo;
        this.fechaNacimiento = generarFecha(fechaNacimiento);
        this.sexo = sexo;
        this.peso = peso;
    }
    
     public Animal1(Animal1 OtroAnimal) {
        this.codigo = OtroAnimal.codigo;
        this.fechaNacimiento = OtroAnimal.fechaNacimiento;
        this.sexo = OtroAnimal.sexo;
        this.peso = OtroAnimal.peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setCodigo(String codigo) {
        if (!esCodigoValido(codigo)) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public void setSexo(char sexo) {
        if (!esSexoValido(sexo)) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }

    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }

    }

    public String getFechaNacimiento() {
        return getFechaNacimiento('-');
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private boolean esSexoValido(char sexo) {
        return (sexo == 'M' || sexo == 'H');
    }

    private boolean esCodigoValido(String codigo) {
        if (!codigo.matches("[a-z0-9]{5}")) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }

    }

    public String getFechaNacimiento(char separador) {
        String fecha = null;
        if (separador != '-' && separador != '/') {
            throw new IllegalArgumentException();
        } else {
            if (this.fechaNacimiento != null) {
                fecha = String.format("%04d%c%02d%c%02d", this.fechaNacimiento.getYear(),
                        separador,
                        this.fechaNacimiento.getMonthValue(), separador, this.fechaNacimiento.getDayOfMonth());
            }
            return fecha;
        }
    }

    private LocalDate generarFecha(String fecha) {
        int dia;
        int mes;
        int anyo;
        if (!fecha.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")
                && !fecha.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try {

                dia = Integer.parseInt(fecha.subSequence(0, 2).toString());
                mes = Integer.parseInt(fecha.subSequence(3, 5).toString());
                anyo = Integer.parseInt(fecha.subSequence(6, fecha.length()).toString());
                return LocalDate.of(anyo, mes, dia);

            } catch (NumberFormatException | DateTimeException ex1) {

                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.codigo);
        hash = 73 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 73 * hash + this.sexo;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal1 other = (Animal1) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Animal1{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
    
    public abstract String hacerSonido();
    
    public abstract String alegrarse();

    public abstract String enfadarse();

    public abstract String queSoy();
    
    
    
    
    
    
}
