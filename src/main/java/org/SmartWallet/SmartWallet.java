package org.SmartWallet;


public class SmartWallet {
    private String Usuario;
    private double saldo;

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    private boolean estadoUsuario;
    public SmartWallet(String Usuario) {
        this.Usuario = Usuario;
        this.saldo = 0;
        this.estadoUsuario = true;
    }
    public double getSaldo() {
        return saldo;
    }

    public boolean deposit(double amount){
        if (amount < 0){
            return false;
        }
        saldo += amount;
        if (Usuario=="Standard"&& saldo>5000){
            return false;
        }
        if(amount>100){
            saldo=saldo+(amount*0.01);
        }
        return(true);
    }
    public boolean withdraw(double amount){
        if(amount <=0 || saldo<amount){
            return false;
        }
        saldo=saldo-amount;
        if(saldo==0){
            estadoUsuario=false;
        }
        return true;
    }

}
