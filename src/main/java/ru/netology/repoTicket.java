package ru.netology;


public class repoTicket {

    protected Ticket[] repository = new Ticket[0];

    public void save(Ticket newTicket) {
        int length = repository.length + 1;
        Ticket[] tmp = new Ticket[length];
        for (int i = 0; i < repository.length; i++) {
            tmp[i] = repository[i];
        }
        tmp[tmp.length - 1] = newTicket;
        repository = tmp;
    }

    public Ticket findById(int searchId) {
        for (int i = 0; i < repository.length; i++) {
            if (repository[i].getId() == searchId) {
                return repository[i];
            }
        }
        return null;
    }

    public void removeById(int removeId) {
        if (repository.length != 0) {
            if (findById(removeId) == null) {
                throw new NotFoundException("Element with id: " + removeId + " not found");
            }
            Ticket[] tmp = new Ticket[repository.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < repository.length; i++) {
                if (repository[i].getId() != removeId) {
                    if (copyToIndex + 1 == repository.length) {
                        return;
                    }
                    tmp[copyToIndex] = repository[i];
                    copyToIndex++;
                }
            }
            repository = tmp;
        }
    }


    public Ticket[] findAll() {
        return repository;
    }


}
