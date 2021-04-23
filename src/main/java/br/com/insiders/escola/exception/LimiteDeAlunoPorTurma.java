package br.com.insiders.escola.exception;

public class LimiteDeAlunoPorTurma extends RuntimeException{

    public LimiteDeAlunoPorTurma(String msg){
        super(msg);
    }
}
