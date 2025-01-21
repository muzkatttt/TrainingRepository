package ru.aston.threads.locks;

public class AccountThread extends Thread {

    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account accountFrom, Account accountTo) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();
            try {
                if (accountFrom.takeOff(10)) {
                    accountTo.add(10);
                }
            } finally {
                accountFrom.getLock().unlock(); // разблокировка аккаунта после транзакции
                accountTo.getLock().unlock();
            }
        }
    }


    private void lockAccounts() {
        while(true){
            //accountFrom.getLock().lock(); // захват монитора аккаунта
            boolean fromLockResult = accountFrom.getLock().tryLock();
            boolean toLockResult = accountTo.getLock().tryLock();
            if(fromLockResult&& toLockResult){
                break;
            } if (fromLockResult){ // если получилось захватить lock первого аккаунта
                accountFrom.getLock().unlock();
            } if (toLockResult){
                accountTo.getLock().unlock();
            }
        }
    }
}
