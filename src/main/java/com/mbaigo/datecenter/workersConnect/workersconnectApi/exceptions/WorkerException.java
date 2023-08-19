package com.mbaigo.datecenter.workersConnect.workersconnectApi.exceptions;

public class WorkerException extends RuntimeException{
    public WorkerException(String message) {
        super(message);
    }

    public static WorkerException workerNotFoundByEmail(String email) {
        return new WorkerException("Worker not found with email: " + email);
    }

    public static WorkerException workerNotFoundByFirstName(String firstName) {
        return new WorkerException("Worker not found with name: " + firstName);
    }

    public static WorkerException workerNotFoundByCity(String city) {
        return new WorkerException("Worker not found with city: " + city);
    }

    public static WorkerException workerNotFoundByCountry(String country) {
        return new WorkerException("Worker not found with country: " + country);
    }

    public static WorkerException workerNotFoundByLastdiplome(String lastediplome) {
        return new WorkerException("Worker not found with lastediplome: " + lastediplome);
    }

    public static WorkerException workerNotFoundByCompetenceTitle(String competenceTitle) {
        return new WorkerException("Worker not found with competenceTitle: " + competenceTitle);
    }
}
