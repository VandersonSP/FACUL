package br.com.fam.modelo;

import java.util.Objects;

public class DadosAgenda {

    public DadosAgenda(String nome, int telefone, Sexo sexo, double altura) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.altura = altura;
    }

    private String nome;
    private int telefone;
    private Sexo sexo;
    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadosAgenda that = (DadosAgenda) o;
        return telefone == that.telefone &&
                Double.compare(that.altura, altura) == 0 &&
                Objects.equals(nome, that.nome) &&
                sexo == that.sexo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, sexo, altura);
    }

    @Override
    public String toString() {
        return String.join(" ", nome, String.valueOf(telefone), sexo.toString(), String.valueOf(altura));
    }
}
