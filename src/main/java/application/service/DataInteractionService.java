package application.service;

import application.repository.RepositoryUser;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class DataInteractionService
{
    private RepositoryUser repositoryUser;

    @Autowired
    public void setRepositoryUser(RepositoryUser repositoryUser)
    {
        this.repositoryUser = repositoryUser;
    }
}