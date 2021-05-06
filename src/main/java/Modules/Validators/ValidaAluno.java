package Modules.Validators;

import javax.swing.*;

public class ValidaAluno {
    private boolean campoObrigatório;

    public boolean validarTxt(JTextField campoTxt, JLabel labelCampo) {

        if (campoTxt.getText().length() <= 0){
            JOptionPane.showMessageDialog(null, "Campo " + labelCampo.getText() + " é obrigatório.");
            return campoObrigatório = true;
        }
        return campoObrigatório = false;
    }
}
