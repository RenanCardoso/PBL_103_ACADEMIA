package Modules.FormatterFields;

import javax.swing.*;

public class FormatterField {
    String campoFormatado;

    public FormatterField(){
        
    }

    public String formatarCPF(JTextField txt){
        this.campoFormatado = txt.getText().replace(".","");
        this.campoFormatado = campoFormatado.replace("-","");

        return campoFormatado;
    }

    public String formatarCelular(JTextField txt){
        this.campoFormatado = txt.getText().replace("(","");
        this.campoFormatado = campoFormatado.replace(")","");
        this.campoFormatado = campoFormatado.replace("-","");
        this.campoFormatado = campoFormatado.replace(" ","");

        return campoFormatado;
    }
}
