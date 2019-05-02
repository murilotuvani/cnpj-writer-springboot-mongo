package net.cartola.receita.cnpj.model;

import java.io.Serializable;

public class CnaeSecundaria implements Serializable {

	private static final long serialVersionUID = 3522164548737116198L;

	private long cnpjEmpresa;
    private int cnaeSecundaria;

    public long getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(long cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public int getCnaeSecundaria() {
        return cnaeSecundaria;
    }

    public void setCnaeSecundaria(int cnaeSecundaria) {
        this.cnaeSecundaria = cnaeSecundaria;
    }

    @Override
    public String toString() {
        return "CnaeSecundaria{cnpjEmpresa=" + cnpjEmpresa + ", cnaeSecundaria=" + cnaeSecundaria + '}';
    }
}
