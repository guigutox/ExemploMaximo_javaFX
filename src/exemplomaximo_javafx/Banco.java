/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplomaximo_javafx;

/**
 *
 * @author guilh
 */
public class Banco {
    
    private float saldo = 1000;
    private float fatura = 100;
    
    public void depositar(float valor, boolean flagFatura){
        if(flagFatura){
            float x = valor-fatura;
            fatura = fatura-valor;
            if(fatura < 0){
                fatura = 0;
            }
            saldo = saldo + x;
        }else{
            saldo = saldo + valor;
        }
    }
    
    public void sacar(float valor){
        saldo = saldo - valor;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public float getFatura(){
        return this.fatura;
    }
    
}
