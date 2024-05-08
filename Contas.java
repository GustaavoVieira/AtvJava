/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Contas {
      private String nome, email, num_Conta;
      private float valor_Conta = 0;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_Conta() {
        return num_Conta;
    }

    public void setNum_Conta(String num_Conta) {
        this.num_Conta = num_Conta;
    }


    public float getValor_Conta() {
        return valor_Conta;
    }

    public void setValor_Conta(float valor_Conta) {
        this.valor_Conta = valor_Conta;
    }
    
    //menu
    public void menu(){
        String [] opcao = {"Criar conta"};
        int op = JOptionPane.showOptionDialog(null, "Clique para continuar", "menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcao, "");
            switch (op) {
            case 0:
                dados();
                break;
            default:
                throw new AssertionError();
        }
    }
    //Método para escolher
    public void escolher(){
        String [] opcoes = {"Depositar","Sacar","Nova Conta","Editar","Excluir","Fechar"};
        int op = JOptionPane.showOptionDialog(null, "Escolha", "Faça sua escolha", 0,JOptionPane.QUESTION_MESSAGE , null, opcoes, "");
        switch (op) {
            case 0:
                this.depositar();
                break;
            case 1:
                this.sacar();
                break;
            case 2:
               this.dados();
            case 3:
                this.editar();
                break;
            case 4:
                this.excluir();
                break;
            case 5:
                this.areaFechada();
            default:
                throw new AssertionError();
        }
    }
    // adc dados
    public void dados(){
        this.nome = (JOptionPane.showInputDialog( "Qual o seu nome?"));
        this.email = (JOptionPane.showInputDialog("Qual o seu email?"));
        this.num_Conta = (JOptionPane.showInputDialog("Digite o número da conta"));
        this.valor_Conta = (Float.parseFloat(JOptionPane.showInputDialog("Qual o valor inicial da conta? ")));
        this.escolher();
    }
    //Método para depositar;   
    public void depositar(){
        String op;
        op = (JOptionPane.showInputDialog("Qual o número da conta?"));
        if(getNum_Conta().equals(op)){
            float ValorDepositado = Float.parseFloat(JOptionPane.showInputDialog("Deposite um valor: "));
            if(ValorDepositado < 0){
                JOptionPane.showMessageDialog(null, "[ERROR] Depósito inválido");
            }else{
                setValor_Conta(getValor_Conta()+ValorDepositado);
                JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.");
                this.areaFechada();
            } 
        }else{
            JOptionPane.showMessageDialog(null, "está conta não existe");
        }
        this.escolher();
    }
    
    //Método para sacar;
    public void sacar(){
        String op;
        op = (JOptionPane.showInputDialog("Qual o número da conta?"));
        if(getNum_Conta().equals(op)){
        float ValorSacado = Float.parseFloat(JOptionPane.showInputDialog("Saque um valor: "));
        if(ValorSacado > getValor_Conta()){
            JOptionPane.showMessageDialog(null, "[ERROR] Saque inválido.");
        }else if(ValorSacado < 0){
            JOptionPane.showMessageDialog(null, "[ERROR] Saque inválido");
        }else{
            setValor_Conta(getValor_Conta() - ValorSacado);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.");
            this.areaFechada();
        }
        }else{
            JOptionPane.showMessageDialog(null, "está conta não existe");
        }
        
        this.escolher();
    }
    //Método para exibir;
    public void ExibirDados() {
       String [] dados = {getNome(), getEmail(),getNum_Conta()};
       float [] dadoInteiro = {getValor_Conta()};
         JOptionPane.showMessageDialog(null, "Nome: "+dados[0]+"\n"+"Email: "+dados[1]+"\n"+"Numero da conta: "+dados[2]+"\n"+"Valor da conta: "+ dadoInteiro[0]);
    }
    //método fechar
    public void areaFechada(){
        this.ExibirDados();
    }

    //metodo editar
    public void editar(){
          String [] opcoes = {"Nome", "Email", "Número da Conta", "Todos"};
        int op = JOptionPane.showOptionDialog(null, "Escolha", "Qual vpcê deseja editar?", 0,JOptionPane.QUESTION_MESSAGE , null, opcoes, "");
        switch (op) {
            case 0:
                this.nome = (JOptionPane.showInputDialog("Edite seu nome"));
                break;
            case 1:
                this.email = (JOptionPane.showInputDialog("Edite o seu email o seu email"));
                break;
            case 2:
                this.num_Conta = (JOptionPane.showInputDialog("Qual o novo número da conta?"));
                break;
            case 3:
                this.nome = (JOptionPane.showInputDialog("Edite seu nome"));
                this.email = (JOptionPane.showInputDialog("Edite o seu email o seu email"));
                this.num_Conta = (JOptionPane.showInputDialog("Qual o novo número da conta?"));
                break;
            default:
                throw new AssertionError();
        }
        JOptionPane.showMessageDialog(null, "Dados editados com seucesso!!");
        this.areaFechada();
        this.escolher();
    }
    //método exclur
    public void excluir(){
        String num;
        num = JOptionPane.showInputDialog("Qual o número da conta?");
        if(num == null ? num_Conta == null : num.equals(num_Conta))
        {
            JOptionPane.showMessageDialog(null, "Sua conta foi excluida com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Essa conta não existe");
        }
      }
}