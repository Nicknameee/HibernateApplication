package application.repository;

import application.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUser
{
    private UserRepository repository;

    @Autowired
    public RepositoryUser(UserRepository repository)
    {
        this.repository = repository;
    }

    public List<UserModel> getAll()
    {
        return repository.findAll();
    }
    public UserModel getBy(Integer id)
    {
        return repository.getById(id);
    }
    public UserModel getByLogin(String login)
    {
        return repository.getByLogin(login);
    }
    public void save(UserModel userModel)
    {
        repository.save(userModel);
    }
    public void update(String login , UserModel userModel)
    {
        repository.updateUser(userModel.getLogin() , userModel.getPassword() , login);
    }
    public void delete(String login)
    {
        repository.deleteUser(login);
    }
}
