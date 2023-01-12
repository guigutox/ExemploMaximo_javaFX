/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package exemplomaximo_javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author guilh
 */
public class FXMLDocumentController implements Initializable {
    
    Banco b = new Banco();
    
    @FXML
    private Label label;
       
    @FXML
    private CheckBox chk_fatura;

    @FXML
    private Label lbl_fatura;

    @FXML
    private Label lbl_saldo;

    @FXML
    private TextField txt_deposito;

    @FXML
    private TextField txt_saque;
    
    @FXML
    private Label lbl_erro;
    
    @FXML
    private Label lbl_erroS;
    

    
    @FXML
    private void depositar(ActionEvent event) {
        
       float valor = Float.valueOf(txt_deposito.getText()).floatValue();
        
        if(b.getFatura() > valor && chk_fatura.isSelected()){
            lbl_erro.setText("ERRO o valor é insuficiente para pagar a fatura!");
        }else if(b.getFatura() <= valor && chk_fatura.isSelected()){
            lbl_erro.setText("");
            b.depositar(valor, true);
        }else{
            b.depositar(valor, false);
        }
        
        lbl_saldo.setText("Saldo atual: R$"+b.getSaldo());
        lbl_fatura.setText("Fatura atual: R$"+b.getFatura());
    }
    @FXML
    private void sacar(ActionEvent event){
        float valor = Float.valueOf(txt_saque.getText()).floatValue();
        
        if(b.getSaldo() < valor){
            lbl_erroS.setText("Erro saldo é menor do que o valor que deseja sacar!");
        }else{
            b.sacar(valor);
        }
        lbl_saldo.setText("Saldo atual: R$"+b.getSaldo());
        lbl_fatura.setText("Fatura atual: R$"+b.getFatura());
    }
    
    @FXML
    public void carregar(){
        lbl_saldo.setText("Saldo atual: R$"+b.getSaldo());
        lbl_fatura.setText("Fatura atual: R$"+b.getFatura());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
