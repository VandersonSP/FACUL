package br.com.fam.modelo;

public enum Sexo {
    MASCULINO,
    FEMININO;

    public static Sexo valueOf(char sexo) {
        if (sexo == 'M')
            return MASCULINO;

        return FEMININO;
    }

    @Override
    public String toString() {
        if (this.name().equals("MASCULINO"))
            return "M";
        return "F";
    }
}
