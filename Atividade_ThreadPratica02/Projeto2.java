package Atividade_ThreadPratica02;

public class Projeto2 {
    static int i = -1;
    static int saldo = 2000;

    public static void main(String[] args) {
        Projeto2.MeuRunnable runnable = new Projeto2.MeuRunnable();
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
        @Override
        public void run(){
            String name = Thread.currentThread().getName();
            synchronized (this){
            saldo = saldo - 100;
            }
            System.out.println(name + ": sacando 100 reais, saldo atual "+ saldo);
        }
    }
}
