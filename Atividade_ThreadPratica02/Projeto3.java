package Atividade_ThreadPratica02;

public class Projeto3 {
    static int i = -1;
    static double saldo = 2000;

    public static void main(String[] args) {
        Projeto3.MeuRunnable runnable = new Projeto3.MeuRunnable();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        Thread t6 = new Thread(runnable);
        Thread t7 = new Thread(runnable);
        Thread t8 = new Thread(runnable);
        Thread t9 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }

    public static class MeuRunnable implements Runnable{
        static Object Porta1 = new Object();
        static Object Porta2 = new Object();

        @Override
        public void run(){
            String name = Thread.currentThread().getName();
            double saque = Math.random()*10000;
            double deposito = Math.random()*10000;
            synchronized (Porta1){
                if((saldo - saque)>0){
                    saldo = saldo - saque;
                    System.out.printf("%s: sacando %.2f reais, o saldo atual é %.2f %n", name, saque, saldo);
                }else{
                    System.out.printf("Não é possivel sacar %.2f pois o saldo é %.2f %n", saque, saldo);
//                    System.out.println("Não é possivel sacar "+ saque+" pois o saldo é "+saldo);
                }
            }
            synchronized (Porta2){
                saldo = saldo + deposito;
                System.out.printf("%s : depositando %.2f reais, o saldo atual é %.2f %n", name, deposito, saldo);
//                System.out.println(name + ": depositando "+deposito +" reais, o saldo atual "+ saldo);
            }

        }
    }
}
